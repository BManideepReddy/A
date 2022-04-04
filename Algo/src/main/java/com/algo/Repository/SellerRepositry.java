package com.algo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.algo.model.SellerRegistrationForm;

@Repository
public interface SellerRepositry extends CrudRepository<SellerRegistrationForm, Integer>{

}
