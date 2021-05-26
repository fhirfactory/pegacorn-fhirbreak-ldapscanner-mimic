package net.fhirfactory.pegacorn.mimic.ldapserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.bean.CsvToBeanBuilder;

import net.fhirfactory.pegacorn.buildingblocks.datamodels.ldap.PractitionerLdapEntry;

/**
 * Loads a CSV file of practitioners into LDAP.
 * 
 * @author Brendan Douglas
 *
 */
public class PractitionerCSVReader {
    private static final Logger LOG = LoggerFactory.getLogger(RouteBuilderCommonBase.class);
	
	public PractitionerCSVReader() {
	}
	
	public void load() {
	 	
	 	// Read the CSV file and create a practitioner.
	 	
	 	try {
	 		
		 	MimicLdapConnection connection = new MimicLdapConnection();
		 	
		 	// Check to see if there are records.
		 	if (!connection.isDirectoryEmpty()) {
		 		LOG.info("The directory is not empty so not adding practitioner entries");
		 		return;
		 	}
		 	
		 	LOG.info("Start - The directory was empty so loading the practitioner entries");
	 		
	 		 StringBuilder sb = new StringBuilder();

	         try (BufferedReader reader = new BufferedReader(
	                 new InputStreamReader(getClass().getClassLoader().getResourceAsStream("practitioner/practitioner-load.csv"), StandardCharsets.UTF_8))) {

	             for (String line; (line = reader.readLine()) != null;) {
	            	 if (sb.length() > 0) {
	            		 sb.append(System.lineSeparator());
	            	 }
	            	 
	                 sb.append(line);
	             }
	         }
	 			         
	 		 List<PractitionerCSVRecord> beans = new CsvToBeanBuilder(new StringReader(sb.toString())).withType(PractitionerCSVRecord.class).withSkipLines(1).build().parse();
			
			PractitionerLdapEntry practitioner = new PractitionerLdapEntry("dc=practitioners,dc=com");
			
			
			for (PractitionerCSVRecord bean : beans) {				
				practitioner.setGivenName(bean.getGivenName());
				practitioner.setSurname(bean.getSurname());
				
				practitioner.setMobileNumber(bean.getMobileNumber());
				practitioner.setEmailAddress(bean.getEmailAddress());
				practitioner.setPreferredName(bean.getPreferredName());
				practitioner.setAgsNumber(bean.getAgsNumber());
				practitioner.setJobTitle(bean.getJobTitle());
				practitioner.setPersonalTitle(bean.getPersonalTitle());
				practitioner.setBranch(bean.getBranch());
				practitioner.setBusinessUnit(bean.getBusinessUnit());
				practitioner.setDivision(bean.getDivision());
				practitioner.setSection(bean.getSection());
				practitioner.setSubSection(bean.getSubsection());
				practitioner.setTelephoneNumber(bean.getTelephoneNumber());
				practitioner.setPager(bean.getPager());
				practitioner.setSuffix(bean.getSuffix());
				practitioner.setIRN(bean.getIRN());
				practitioner.setGS1(bean.getGS1());
				
				connection.addEntry(practitioner);
			}
			
		 	LOG.info("End - The directory was empty so loading the practitioner entries.  Count = {}", beans.size());
    		
		} catch(Exception e) {
			throw new RuntimeException("Error loading practitioner data" , e);
		}
	}
}
