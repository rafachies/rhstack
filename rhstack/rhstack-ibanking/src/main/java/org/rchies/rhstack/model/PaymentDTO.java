package org.rchies.rhstack.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentDTO {

	private double paymentValue;
	private String accountId;
	private String paymentCode;
	private String username;
	private Boolean approved;
	private String rejectionReason;
	
	public PaymentDTO() {
		this.approved = true;
		this.rejectionReason = "";
	}

	public double getPaymentValue() {
		return paymentValue;
	}

	public void setPaymentValue(double paymentValue) {
		this.paymentValue = paymentValue;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	
}
