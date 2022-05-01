package net.fhirfactory.pegacorn.mimic.ldapserver;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class PractitionerLoadRoute extends RouteBuilderCommonBase {
    
    private static final Logger LOG = LoggerFactory.getLogger(RouteBuilderCommonBase.class);

    @Override
    protected void configureManagedRoutes() {
                   
    	// A  timer route which will run at startup and every 30 seconds and load the practitoner data if the LDAP directory is empty.
        from("timer://practitionerLoaderRegularInterview?fixedRate=true&period=30000")
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