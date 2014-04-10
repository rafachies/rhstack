package org.rchies.rhstack.transfer.service;

import javax.inject.Inject;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.rchies.rhstack.transfer.dto.TransferRequest;
import org.slf4j.Logger;
import org.switchyard.component.bean.Service;

@Service(RulesComponent.class)
public class RulesComponentBean implements RulesComponent {

	@Inject
	private Logger logger;
	
	@Override
	public TransferRequest execute(TransferRequest transferRequest) {
		try {
			logger.info("RulesComponent called for {}", transferRequest);
			KieServices kieServices = KieServices.Factory.get();
			KieContainer kieContainer = kieServices.newKieClasspathContainer();
			KieSession kSession = kieContainer.newKieSession("rhstackKieSession");
			kSession.insert(transferRequest);
			kSession.insert(transferRequest.getDebitAccount());
			kSession.fireAllRules();
			logger.info("Transfer approved: {}", transferRequest.getApproved());
			logger.info("Transfer rejection reason: {}", transferRequest.getRejectionReason());
			kSession.dispose();
		} catch (Exception e) {
			throw new RuntimeException("Unable to call rules", e);
		}
		return transferRequest;

	}
}
