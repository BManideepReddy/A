package com.algo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "seller_details")
public class SellerRegistrationForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 8)
	private int sellerRefId;
	private String sellerId;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private String phoneNumber;
	private String emailId;
	private String password;
	@Transient
	private String verifypassword;

	public int getSellerRefId() {
		return sellerRefId;
	}

	public void setSellerRefId(int sellerRefId) {
		this.sellerRefId = sellerRefId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;

	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifypassword() {
		return verifypassword;
	}

	public void setVerifypassword(String verifypassword) {
		this.verifypassword = verifypassword;
	}

	@Override
	public String toString() {
		return "SellerRegistrationForm [sellerRefId=" + sellerRefId + ", sellerId=" + sellerId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + ", emailId=" + emailId + ", password=" + password + ", verifypassword=" + verifypassword
				+ "]";
	}

}
