package org.rchies.rhstack.payment.dto;

import org.apache.commons.lang.builder.ToStringBuilder;


public class PaymentRequest {

	private static final String NO_REASON = "";
	
	private Double paymentValue;
	private String paymentCode;
	private String accountId;
	
	private String username;
	
	private Boolean approved;
	private String rejectionReason;
	
	public PaymentRequest() {
		this.approved = true;
		this.rejectionReason = NO_REASON;
	}
	
	public Double getPaymentValue() {
		return paymentValue;
	}
	public void setPaymentValue(Double paymentValue) {
		this.paymentValue = paymentValue;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public Boolean getApproved() {
		return approved;
	}
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	public String getRejectionReason() {
		return rejectionReason;
	}
	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this).toString();
	}
}
