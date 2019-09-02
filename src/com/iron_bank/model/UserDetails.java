package com.iron_bank.model;

import java.util.Date;

public class UserDetails extends User {

	private String firstName;
	private String lastName;
	private String contact;
	private String email;
	private String address;
	private String city;
	private String state;
	private int zip;
	private Date dob;
	private int ssn;
	
	public UserDetails() {
		// Blank constructor
	}
	
	public UserDetails(Long acctId, String userName, String passWord, int pin, String firstName, String lastName, String contact, String email, String address, String city,
			String state, int zip, Date dob, int ssn) {
		super(acctId, userName, passWord, pin);
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.dob = dob;
		this.ssn = ssn;
	}

	public UserDetails(String firstName, String lastName, String contact, String email, String address,
			String city, String state, int zip, Date dob, int ssn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.dob = dob;
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	
	@Override
	public String toString() {
		return "UserDetails [firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact + ", email="
				+ email + ", address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + ", dob="
				+ dob + ", ssn=" + ssn + "]";
	}
	
	public String toStringDetails() {
		return "Name = " + firstName + " " + lastName + "\nContact number = " + contact + "\nEmail Address = "
				+ email + "\nAddress = " + address + "\nCity = " + city + "\nState = " + state + "\nZIP = " + zip + "\nDate of birth = "
				+ dob + "\nSSN = " + ssn;
	}
	
}
