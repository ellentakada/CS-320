package com.contactservice;


/**
 * Application start-up program
 * 
 * @Ellen Takada, ellen.takada@snhu.edu
 */

public class Contact {
	
	protected String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;

	private Contact() {
	}

	public Contact(String id) {
		this();
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}

	public boolean setFirstName(String fName) {
		if (fName.equals(null) || fName.isEmpty() || fName.length() >= 10) {
			System.out.println("Invalid First Name.");
			return false;
		}
		else {
			this.firstName = fName;
		}
		return true;
	}
	
	public boolean setLastName(String lName) {
		if (lName.equals(null) || lName.isEmpty() || lName.length() >= 10) {
			System.out.println("Invalid Last Name.");
			return false;
		}
		else {
			this.lastName = lName;
		}
		return true;
	}
	
	public boolean setPhoneNumber(String pNumber) {
		if (pNumber.equals(null) || pNumber.isEmpty() || pNumber.length() != 10) {
			System.out.println("Invalid Phone Number.");
			return false;
		}
		else {
			this.phoneNumber = pNumber;
		}
		return true;
	}
	
	public boolean setAddress(String address) {
		if (address == null || address.isEmpty() || address.length() >= 30) {
			System.out.println("Invalid Address.");
			return false;
		}
		else {
			this.address = address;
		}
		return true;
	}
	
	
}