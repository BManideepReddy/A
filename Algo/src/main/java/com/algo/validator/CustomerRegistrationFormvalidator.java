package com.algo.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.algo.model.CustomerRegistrationForm;
import com.algo.model.SellerRegistrationForm;

@Service
public class CustomerRegistrationFormvalidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors error) {
		// TODO Auto-generated method stub
		CustomerRegistrationForm customerForm = (CustomerRegistrationForm) arg0;
		String pass = customerForm.getPassword();
		if(customerForm.getFirstName().isEmpty())
			error.rejectValue("firstName", "", "First Name Cannot be Empty");
		if(customerForm.getLastName().isEmpty())
			error.rejectValue("lastName", "", "Last Name Cannot be Empty");
		if(customerForm.getDob().isEmpty())
			error.rejectValue("dob", "", "Date of Birth should be selected");
		if(customerForm.getGender() == null)
			error.rejectValue("gender", "", "Gender should be selected");
		if(customerForm.getCustomerId().isEmpty())
			error.rejectValue("customerId", "", "User ID cannot be Empty");
		if(customerForm.getPhoneNumber().isEmpty())
			error.rejectValue("phoneNumber", "", "Phone Number cannot be Empty");
		if(!(customerForm.getPhoneNumber().isEmpty())) {
		if(customerForm.getPhoneNumber().length() != 10)
			error.rejectValue("phoneNumber", "", "Phone Number Should have exact 10 numbers");
		}
		if(customerForm.getEmailId().isEmpty())
			error.rejectValue("emailId", "", "Email ID cannot be Empty");
		
		if(customerForm.getCustomerId().length()<8)
			error.rejectValue("customerId", "", "User ID should be 8 or more characcters");
		if(customerForm.getPassword().isEmpty())
			error.rejectValue("password", "", "Password cannot be empty");
		if(customerForm.getVerifyPassword().isEmpty())
			error.rejectValue("verifyPassword", "", "Re-Enter Password cannot be empty");
		if(!(customerForm.getVerifyPassword().matches(pass)))
			error.rejectValue("verifyPassword", "", "Re-Enter password should match with password");
	
		
	}

}
