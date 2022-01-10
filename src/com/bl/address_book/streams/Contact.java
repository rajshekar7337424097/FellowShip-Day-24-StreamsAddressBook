package com.bl.address_book.streams;

public class Contact {
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailID;
	private String zipCode;
	
	
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ","
				+ " lastName=" + lastName + ", "
						+ "phoneNumber=" + phoneNumber
				+ ", emailID=" + emailID + ", "
						+ "zipCode=" + zipCode + "]";
	}
	
	

}
