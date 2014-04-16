package org.rchies.rhstack.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.xml.bind.annotation.XmlElement;

@Named
@RequestScoped
public class Payment {

	@XmlElement(name = "paymentValue")
	private double value;
	
	@XmlElement(name = "accountId")
	private String account;
	
	@XmlElement(name = "paymentCode")
	private String code;
	
	@XmlElement(name = "username")
	private String username;
	
	@XmlElement(name = "approved")
	private Boolean approved;
	
	@XmlElement(name = "rejectionReason")
	private String rejectionReason;
	
	public Payment() {
		this.approved = true;
		this.rejectionReason = "";
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
