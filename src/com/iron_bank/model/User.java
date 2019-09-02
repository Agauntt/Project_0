package com.iron_bank.model;


public class User {

	protected long acctId;
	private String userName;
	private transient String passWord;
	private int pin;
	
	public User() {
		//
	}
	
	public User(long acctId, String userName, String passWord, int pin) {
		super();
		this.acctId = acctId;
		this.userName = userName;
		this.passWord = passWord;
		this.pin = pin;
		
	}

	public long getAcctId() {
		return acctId;
	}

	public void setAcctId(long acctId) {
		this.acctId = acctId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "User [acctId=" + acctId + ", userName=" + userName + ", pin=" + pin + "]";
	}
}
