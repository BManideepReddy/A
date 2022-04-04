package com.algo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "customer_details")
public class CustomerRegistrationForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 8)
	private int CustomerRefId;
	private String CustomerId;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private String phoneNumber;
	private String emailId;
	private String password;
	@Transient
	private String verifyPassword;


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

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public int getCustomerRefId() {
		return CustomerRefId;
	}

	public void setCustomerRefId(int customerRefId) {
		CustomerRefId = customerRefId;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	@Override
	public String toString() {
		return "CustomerRegistrationForm [CustomerRefId=" + CustomerRefId + ", CustomerId=" + CustomerId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", password=" + password
				+ ", verifypassword=" + verifyPassword + "]";
	}


}
