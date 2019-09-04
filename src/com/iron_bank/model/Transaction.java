package com.iron_bank.model;

import java.sql.Date;

public class Transaction {

	private long acctId;
	private Date transDate;
	private double amount;
	private double balance;
	private long transId;
	
	public Transaction() {
		
	}
	
	public Transaction(Date transDate, double amount, double balance, long transId) {
		super();
		this.transDate = transDate;
		this.amount = amount;
		this.balance = balance;
		this.transId = transId;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getTransId() {
		return transId;
	}

	public void setTransId(long transId) {
		this.transId = transId;
	}

	@Override
	public String toString() {
		return "Transaction [acctId= " + acctId + "transDate=" + transDate + ", amount=" + amount + ", balance=" + balance + ", transId="
				+ transId + "]";
	}

	public long getAcctId() {
		return acctId;
	}

	public void setAcctId(long acctId) {
		this.acctId = acctId;
	}

}
