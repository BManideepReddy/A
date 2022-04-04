package com.algo.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.algo.model.ProductModel;
@Service
public class AddProductFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors error) {
		// TODO Auto-generated method stub
		ProductModel productModel = (ProductModel) arg0;
		if (productModel.getProName().isEmpty())
			error.rejectValue("ProName", "" ,"Product name cant be empty");
		if (productModel.getProPrice().isEmpty())
			error.rejectValue("ProPrice", "", "Product Price cant be Empty");
		
		
	}

}
