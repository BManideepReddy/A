package com.algo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algo.Repository.SellerRepositry;
import com.algo.model.LoginModel;
import com.algo.model.SellerRegistrationForm;

@Service
public class SellerService {
	@Autowired
	private SellerRepositry sellerRepository;
	
	public void saveSeller(SellerRegistrationForm seller) {
		sellerRepository.save(seller);
	}
	
	public boolean validateSellerCredentials(LoginModel loginModel) {
		List<SellerRegistrationForm> sellers = new ArrayList<>();
		sellerRepository.findAll().forEach(sellers::add);
		Iterator itr = sellers.iterator();
		while(itr.hasNext()) {
			SellerRegistrationForm seller = (SellerRegistrationForm) itr.next();
			if(seller.getSellerId().contentEquals(loginModel.getUserId()) && seller.getPassword().contentEquals(loginModel.getPassword()))
				return true;
		}
		
		return false;
	}
	public SellerRegistrationForm getSellerCredentials(LoginModel loginModel) {
		List<SellerRegistrationForm> sellers = new ArrayList<>();
		sellerRepository.findAll().forEach(sellers::add);
		Iterator itr = sellers.iterator();
		while(itr.hasNext()) {
			SellerRegistrationForm seller = (SellerRegistrationForm) itr.next();
			if(seller.getSellerId().contentEquals(loginModel.getUserId()) && seller.getPassword().contentEquals(loginModel.getPassword()))
				return seller;
		}
		
		return null;
	}
}
