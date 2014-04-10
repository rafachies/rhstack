package org.rchies.rhstack.transfer.dto;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.rchies.rhstack.transfer.entity.Account;


public class TransferRequest {

	
	private static final String NO_REASON = "";
	
	private Double value;
	private String username;
	private String debitAccountId;
	private String creditAccountId;
	
	@JsonIgnore
	private Account debitAccount;
	
	@JsonIgnore
	private Account creditAccount;
	
	@JsonIgnore
	private Boolean approved;
	
	@JsonIgnore
	private String rejectionReason;
	
	
	public TransferRequest() {
		this.approved = true;
		this.rejectionReason = NO_REASON;
	}

	public Double getValue() {
		return value;
	}



	public void setValue(Double value) {
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



	public Account getDebitAccount() {
		return debitAccount;
	}



	public void setDebitAccount(Account debitAccount) {
		this.debitAccount = debitAccount;
	}



	public Account getCreditAccount() {
		return creditAccount;
	}



	public void setCreditAccount(Account creditAccount) {
		this.creditAccount = creditAccount;
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
