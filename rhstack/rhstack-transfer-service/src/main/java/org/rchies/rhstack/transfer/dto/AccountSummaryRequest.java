package org.rchies.rhstack.transfer.dto;

public class AccountSummaryRequest {

	private String accountId;
	private Integer months;
	
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
}
