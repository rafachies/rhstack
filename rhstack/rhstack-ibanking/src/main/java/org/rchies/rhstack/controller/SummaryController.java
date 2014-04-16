package org.rchies.rhstack.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.rchies.rhstack.client.RestClient;
import org.rchies.rhstack.client.SummaryClient;
import org.rchies.rhstack.model.AccountSummary;

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
