package org.rchies.rhstack.transfer.dto;

import java.io.Serializable;

import org.rchies.rhstack.transfer.entity.Account;


public class TransferRequest implements Serializable {

	
	private static final long serialVersionUID = -6929638948657958511L;

	private static final String NO_REASON = "";
	
	private Double value;
	private String username;
	private String debitAccountId;
	private String creditAccountId;
	
	private Account debitAccount;
	
	private Account creditAccount;
	
	private Boolean approved;
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

}
