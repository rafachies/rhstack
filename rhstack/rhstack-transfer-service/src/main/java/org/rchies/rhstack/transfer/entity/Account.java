package org.rchies.rhstack.transfer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "accountid")
	private String accountId;
	
	@Column(name = "balance")
	private Double balance;
	
	@Column(name = "accounttype")
	private String accountType;
	
	@Column(name = "blocked")
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
