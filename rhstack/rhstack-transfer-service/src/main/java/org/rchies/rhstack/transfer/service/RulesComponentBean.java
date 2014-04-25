package org.rchies.rhstack.transfer.service;

import javax.inject.Inject;

import org.rchies.rhstack.transfer.dto.TransferRequest;
import org.rchies.rhstack.transfer.rules.RulesManager;
import org.rchies.rhstack.transfer.rules.annotation.TransferRules;
import org.slf4j.Logger;
import org.switchyard.component.bean.Service;

@Service(RulesComponent.class)
public class RulesComponentBean implements RulesComponent {

	@Inject
	private Logger logger;

	@Inject @TransferRules
	private RulesManager rulesManager;

	@Override
	public TransferRequest execute(TransferRequest transferRequest) {
		logger.info("RulesComponent called for {}", transferRequest);
		
		rulesManager.execute(transferRequest, transferRequest.getDebitAccount());
		
		logger.info("Transfer approved: {}", transferRequest.getApproved());
		logger.info("Transfer rejection reason: {}", transferRequest.getRejectionReason());
		return transferRequest;
	}



	//	@Override
	//	public TransferRequest execute(TransferRequest transferRequest) {
	//		try {
	//			logger.info("RulesComponent called for {}", transferRequest);
	//			KieServices kieServices = KieServices.Factory.get();
	//			KieContainer kieContainer = kieServices.newKieClasspathContainer();
	//			KieSession kSession = kieContainer.newKieSession("rhstackKieSession");
	//			
	//			kSession.insert(transferRequest);
	//			kSession.insert(transferRequest.getDebitAccount());
	//			kSession.fireAllRules();
	//			logger.info("Transfer approved: {}", transferRequest.getApproved());
	//			logger.info("Transfer rejection reason: {}", transferRequest.getRejectionReason());
	//			kSession.dispose();
	//		} catch (Exception e) {
	//			throw new RuntimeException("Unable to call rules", e);
	//		}
	//		return transferRequest;
	//	}

//		@Override
//		public TransferRequest execute(TransferRequest transferRequest) {
//			try {
//				
//				KieServices kieServices = KieServices.Factory.get();
//				ReleaseId releaseId = kieServices.newReleaseId( "org.rchies.rhstack", "rhstackrules", "1.0.0" );
//				KieContainer kContainer = kieServices.newKieContainer( releaseId );
//				KieScanner kScanner = kieServices.newKieScanner( kContainer );
//				kScanner.start( 10000L );
//				KieSession kSession = kContainer.newKieSession("rhstackKieSession");
//				kSession.insert(transferRequest);
//				kSession.insert(transferRequest.getDebitAccount());
//				kSession.fireAllRules();
//				logger.info("Transfer approved: {}", transferRequest.getApproved());
//				logger.info("Transfer rejection reason: {}", transferRequest.getRejectionReason());
//				kSession.dispose();
//			} catch (Exception e) {
//				throw new RuntimeException("Unable to call rules", e);
//			}
//			return transferRequest;
//		}
		
	//	public static void main(String[] args) {
	//		try {
	//			TransferRequest transferRequest = new TransferRequest();
	//			transferRequest.setValue(10000.00);
	//			Account account = new Account();
	//			account.setAccountType("REGULAR");
	//			KieServices kieServices = KieServices.Factory.get();
	//			ReleaseId releaseId = kieServices.newReleaseId( "org.rchies.rhstack", "rhstackrules", "1.0.0" );
	//			KieContainer kContainer = kieServices.newKieContainer( releaseId );
	//			KieScanner kScanner = kieServices.newKieScanner( kContainer );
	//			kScanner.start( 10000L );
	//			KieSession kSession = kContainer.newKieSession("rhstackKieSession");
	//			kSession.insert(transferRequest);
	//			kSession.insert(account);
	//			kSession.fireAllRules();
	//			System.out.println("Transfer approved: " + transferRequest.getApproved());
	//			System.out.println("Transfer rejection reason: " + transferRequest.getRejectionReason());
	//			kSession.dispose();
	//		} catch (Exception e) {
	//			throw new RuntimeException("Unable to call rules", e);
	//		}
	//	}
}
