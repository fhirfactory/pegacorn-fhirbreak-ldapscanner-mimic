package net.fhirfactory.pegacorn.mimic.ldapserver;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class PractitionerLoadRoute extends RouteBuilderCommonBase {
    
    private static final Logger LOG = LoggerFactory.getLogger(RouteBuilderCommonBase.class);

    @Override
    protected void configureManagedRoutes() {
      
    	// A quartz timer route which will load the practitoner data if the LDAP directory is empty.
        from("quartz://practitionerLoader?cron=0/30 0/1 * 1/1 * ? *")
        .process(exchange -> {
        	PractitionerCSVReader csvReader = new PractitionerCSVReader();
        	csvReader.load();
        });
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
