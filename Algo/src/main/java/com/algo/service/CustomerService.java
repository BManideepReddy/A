package com.algo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algo.Repository.CustomerRepositry;
import com.algo.model.CustomerRegistrationForm;
import com.algo.model.LoginModel;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepositry customerRepository;
	
	public void saveCustomer(CustomerRegistrationForm customer) {
		customerRepository.save(customer);
	}
	
	public boolean validateCustomerCredentials(LoginModel loginModel) {
		List<CustomerRegistrationForm> customers = new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		Iterator itr = customers.iterator();
		while(itr.hasNext()) {
			CustomerRegistrationForm customer = (CustomerRegistrationForm) itr.next();
			if(customer.getCustomerId().contentEquals(loginModel.getUserId()) && customer.getPassword().contentEquals(loginModel.getPassword()))
				return true;
		}
		
		return false;
	}
	public CustomerRegistrationForm getCustomerCredentials(LoginModel loginModel) {
		List<CustomerRegistrationForm> customers = new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		Iterator itr = customers.iterator();
		while(itr.hasNext()) {
			CustomerRegistrationForm customer = (CustomerRegistrationForm) itr.next();
			if(customer.getCustomerId().contentEquals(loginModel.getUserId()) && customer.getPassword().contentEquals(loginModel.getPassword()))
				return customer;
		}
		
		return null;
	}
}
