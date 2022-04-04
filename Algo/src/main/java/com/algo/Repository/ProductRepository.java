package com.algo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.algo.model.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Integer>{

}
