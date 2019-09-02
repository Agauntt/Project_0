package com.iron_bank.model;

import java.util.Date;

public class Account {
	private long acctId;
	private int balance;
	private Date openDate;
	private int ownerId;
	
	
	public Account() {
		
	}
	
	public Account(long acctId, int balance, Date openDate, int ownerId) {
		super();
		this.acctId = acctId;
		this.balance = balance;
		this.openDate = openDate;
		this.ownerId = ownerId;
	}

	public long getAcctId() {
		return acctId;
	}

	public void setAcctId(long acctId) {
		this.acctId = acctId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "Account [acctId=" + acctId + ", balance=" + balance + ", openDate=" + openDate + ", ownerId=" + ownerId
				+ "]";
	}
	
}