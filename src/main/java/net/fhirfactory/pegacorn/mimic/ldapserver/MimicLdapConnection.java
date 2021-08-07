package net.fhirfactory.pegacorn.mimic.ldapserver;

import java.io.IOException;
import java.util.Map;

import org.apache.directory.api.ldap.model.cursor.CursorException;
import org.apache.directory.api.ldap.model.cursor.SearchCursor;
import org.apache.directory.api.ldap.model.entry.DefaultEntry;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.message.Response;
import org.apache.directory.api.ldap.model.message.SearchRequest;
import org.apache.directory.api.ldap.model.message.SearchRequestImpl;
import org.apache.directory.api.ldap.model.message.SearchResultEntry;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.api.ldap.model.name.Dn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fhirfactory.pegacorn.buildingblocks.datamodels.ldap.BaseLdapConnection;
import net.fhirfactory.pegacorn.buildingblocks.datamodels.ldap.LdapAttribute;
import net.fhirfactory.pegacorn.buildingblocks.datamodels.ldap.LdapAttributeNameEnum;
import net.fhirfactory.pegacorn.buildingblocks.datamodels.ldap.PractitionerLdapEntry;

/**
 * LDAP mimic connection.  Mimic just allows entries to be added to an LDAP server.
 * 
 * @author Brendan Douglas
 *
 */
public class MimicLdapConnection extends BaseLdapConnection {
	
    public MimicLdapConnection() throws LdapException {

	}


	private static final Logger LOG = LoggerFactory.getLogger(MimicLdapConnection.class);

	
	/**
	 * Add a practitioner entry.
	 * 
	 * @param newEntry
	 * @throws LdapException
	 */
	public void addEntry(PractitionerLdapEntry newEntry) throws LdapException, IOException {
				
		try {
			Entry entry = new DefaultEntry(newEntry.getDN(baseDN),
		            "ObjectClass: 1.3.6.1.4.1.18060.17.2.5",
		            "ObjectClass: top");
			
			for (Map.Entry<LdapAttributeNameEnum, LdapAttribute> attribute : newEntry.getAttributes().entrySet()) {
		        entry.add(attribute.getKey().getName(), attribute.getValue().getValue());
			}
			
			entry.add("cn", newEntry.getCommonName());
			entry.add("displayName", newEntry.getCommonName());
			
			connect();
			
			connection.add(entry);
			
		} finally {
			close();
		}
	}
	
	
	public boolean isDirectoryEmpty() throws LdapException, IOException, CursorException {
				
		 // Create the SearchRequest object
	    SearchRequest searchRequest = new SearchRequestImpl();
	    searchRequest.setScope(SearchScope.ONELEVEL);
	    searchRequest.addAttributes("*","+");
	    searchRequest.setTimeLimit(0);
	    searchRequest.setBase(new Dn(baseDN));
	    searchRequest.setFilter("(objectclass=*)");

	    SearchCursor searchCursor = null;

		try {
			connect();
			
			searchCursor = connection.search(searchRequest);
			
		    while (searchCursor.next())
		    {
			
		        Response response = searchCursor.get();
				
				if (response instanceof SearchResultEntry) {
					return false; // Not empty.  I am sure there is a better way of detecting if the directory is empty but this is just for mimic.
		        }
		    }
		} finally {
			close();
			
			searchCursor.close();
		}
		
		return true;
	}


	@Override
	public Logger getLogger() {
		return LOG;
	}
	
	
}
