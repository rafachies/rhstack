package org.rchies.rhstack.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class TransferDTO {

	private double value;
	private String debitAccountId;
	private String creditAccountId;
	private String username;
	
	private Boolean approved;
	private String rejectionReason;
	
	public TransferDTO() {
		this.approved = true;
		this.rejectionReason = "";
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getDebitAccountId() {
		return debitAccountId;
	}

	public void setDebitAccountId(String debitAccountId) {
		this.debitAccountId = debitAccountId;
	}

	public String getCreditAccountId() {
		return creditAccountId;
	}

	public void setCreditAccountId(String creditAccountId) {
		this.creditAccountId = creditAccountId;
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
