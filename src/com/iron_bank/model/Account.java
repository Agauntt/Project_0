package com.iron_bank.model;

import java.util.Date;

public class Account {
	private long acctId;
	private double balance;
	private Date openDate;
	private String acct_type;
	private double interest;
	private long ownerId;
	
	
	public Account() {
		
	}


	public Account(long acctId, double balance, Date openDate, String acct_type, double interest, long ownerId) {
		super();
		this.acctId = acctId;
		this.balance = balance;
		this.openDate = openDate;
		this.acct_type = acct_type;
		this.interest = interest;
		this.ownerId = ownerId;
	}

	public Account(double balance, Date openDate, String acct_type, double interest, long ownerId) {
		super();
		this.balance = balance;
		this.openDate = openDate;
		this.acct_type = acct_type;
		this.interest = interest;
		this.ownerId = ownerId;
	}


	public long getAcctId() {
		return acctId;
	}


	public void setAcctId(long acctId) {
		this.acctId = acctId;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public Date getOpenDate() {
		return openDate;
	}


	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}


	public String getAcct_type() {
		return acct_type;
	}


	public void setAcct_type(String acct_type) {
		this.acct_type = acct_type;
	}


	public double getInterest() {
		return interest;
	}


	public void setInterest(double interest) {
		this.interest = interest;
	}


	public long getOwnerId() {
		return ownerId;
	}


	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}


	@Override
	public String toString() {
		return "Account [acctId=" + acctId + ", balance=" + balance + ", openDate=" + openDate + ", acct_type="
				+ acct_type + ", interest=" + interest + ", ownerId=" + ownerId + "]";
	}
	
}