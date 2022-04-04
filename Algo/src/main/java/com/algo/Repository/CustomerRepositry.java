package com.algo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.algo.model.CustomerRegistrationForm;

@Repository
public interface CustomerRepositry extends CrudRepository<CustomerRegistrationForm, Integer>{

}
