package org.rchies.rhstack.transfer.entity;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 5279393080137015396L;

	private Long id;
	private String accountId;
	private Double balance;
	private String accountType;
	private Boolean blocked;
	
	public void debit(Double debitValue) {
		this.balance -= debitValue;
	}
	
	public void credit(Double creditValue) {
		this.balance += creditValue;
	}
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Boolean getBlocked() {
		return blocked;
	}
	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}
	
}
