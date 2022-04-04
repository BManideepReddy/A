package com.algo.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.algo.model.SellerRegistrationForm;

@Service
public class SellerRegistrationFormvalidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors error) {
		// TODO Auto-generated method stub
		SellerRegistrationForm sellerForm = (SellerRegistrationForm) arg0;
		String pass = sellerForm.getPassword();
		if(sellerForm.getFirstName().isEmpty())
			error.rejectValue("firstName", "", "First Name Cannot be Empty");
		if(sellerForm.getLastName().isEmpty())
			error.rejectValue("lastName", "", "Last Name Cannot be Empty");
		if(sellerForm.getDob().isEmpty())
			error.rejectValue("dob", "", "Date of Birth should be selected");
		if(sellerForm.getGender() == null)
			error.rejectValue("gender", "", "Gender should be selected");
		if(sellerForm.getSellerId().isEmpty())
			error.rejectValue("sellerId", "", "User ID cannot be Empty");
		if(sellerForm.getPhoneNumber().isEmpty())
			error.rejectValue("phoneNumber", "", "Phone Number cannot be Empty");
		if(!(sellerForm.getPhoneNumber().isEmpty())) {
		if(sellerForm.getPhoneNumber().length() != 10)
			error.rejectValue("phoneNumber", "", "Phone Number Should have exact 10 numbers");
		}
		if(sellerForm.getEmailId().isEmpty())
			error.rejectValue("emailId", "", "Email ID cannot be Empty");
		
		if(sellerForm.getSellerId().length()<8)
			error.rejectValue("sellerId", "", "User ID should be 8 or more characcters");
		if(sellerForm.getPassword().isEmpty())
			error.rejectValue("password", "", "Password cannot be empty");
		if(sellerForm.getVerifypassword().isEmpty())
			error.rejectValue("verifypassword", "", "Re-Enter Password cannot be empty");
		if(!(sellerForm.getVerifypassword().matches(pass)))
			error.rejectValue("verifypassword", "", "Re-Enter password should match with password");
	
		
	}

}
