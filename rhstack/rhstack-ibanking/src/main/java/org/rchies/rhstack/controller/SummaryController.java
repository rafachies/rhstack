package org.rchies.rhstack.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.rchies.rhstack.client.RestClient;
import org.rchies.rhstack.client.SummaryClient;
import org.rchies.rhstack.model.AccountSummary;
import org.rchies.rhstack.transfer.dto.TransferRequest;
import org.rchies.rhstack.transfer.entity.Account;

@Named
@RequestScoped
public class SummaryController {

	private String accountId;
	private Integer months;
	private String correlationKey;

	@Inject
	private RestClient<SummaryClient> restClient;

	@Inject
	private FacesContext facesContext;


	public String askSummary() {
		SummaryClient summaryClient = restClient.getProxy(SummaryClient.class);
		AccountSummary accountSummary = new AccountSummary();
		accountSummary.setAccountId(accountId);
		accountSummary.setMonths(months);
		summaryClient.askSummary(accountSummary, correlationKey);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary request sent. Wait until it's approved", "Success");
		facesContext.addMessage(null, message);
		return "home";
	}

	public String approveSummary() {
		SummaryClient summaryClient = restClient.getProxy(SummaryClient.class);
		summaryClient.approveSummary(correlationKey);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Summary mail approved", "Success");
		facesContext.addMessage(null, message);
		return "home";
	}
	
	public String drools() {
		try{
			TransferRequest transferRequest = new TransferRequest();
			transferRequest.setValue(10000.00);
			Account account = new Account();
			account.setAccountType("REGULAR");
			KieServices kieServices = KieServices.Factory.get();
			ReleaseId releaseId = kieServices.newReleaseId( "org.rchies.rhstack", "rhstackrules", "1.0.0" );
			KieContainer kContainer = kieServices.newKieContainer( releaseId );
			KieScanner kScanner = kieServices.newKieScanner( kContainer );
			kScanner.start( 10000L );
			KieSession kSession = kContainer.newKieSession("rhstackKieSession");
			kSession.insert(transferRequest);
			kSession.insert(account);
			kSession.fireAllRules();
			System.out.println("Transfer approved: " + transferRequest.getApproved());
			System.out.println("Transfer rejection reason: " + transferRequest.getRejectionReason());
			kSession.dispose();
			return "home";
		} catch (Exception e) {
			throw new RuntimeException("Unable to call rules", e);
		}

	}

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Integer getMonths() {
		return months;
	}
	public void setMonths(Integer months) {
		this.months = months;
	}
	public String getCorrelationKey() {
		return correlationKey;
	}
	public void setCorrelationKey(String correlationKey) {
		this.correlationKey = correlationKey;
	}
}
