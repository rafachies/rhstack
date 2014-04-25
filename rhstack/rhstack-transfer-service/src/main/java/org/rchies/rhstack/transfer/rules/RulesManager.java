package org.rchies.rhstack.transfer.rules;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Singleton
public abstract class RulesManager {

	private KieContainer kContainer;
	
	@PostConstruct
	public void postConstruct() {
		KieServices kieServices = KieServices.Factory.get();
		ReleaseId releaseId = kieServices.newReleaseId("org.rchies.rhstack", "transferrules", "1.0.0" );
		kContainer = kieServices.newKieContainer(releaseId);
	}
	
	public void execute(Object ... facts) {
		KieSession kSession = kContainer.newKieSession();
		for (Object fact : facts) {
			kSession.insert(fact);
		}
		kSession.fireAllRules();
	}
	
	public abstract String getSessionName();
}