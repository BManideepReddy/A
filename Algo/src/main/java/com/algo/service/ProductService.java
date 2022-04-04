package com.algo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algo.Repository.ProductRepository;
import com.algo.model.ProductModel;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void saveProduct(ProductModel productModel) {
		productRepository.save(productModel);
	}

	public List<ProductModel> getAllSellerProducts(String sellerName) {
		List<ProductModel> productList = new ArrayList<>();
		productRepository.findAll().forEach(productList::add);
		List<ProductModel> sellerProductList = new ArrayList<>();
		Iterator itr = productList.iterator();
		while (itr.hasNext()) {
			ProductModel sellerProduct = (ProductModel) itr.next();
			if (sellerProduct.getSellerName().contentEquals(sellerName)) {
				sellerProductList.add(sellerProduct);
			}
		}
		return sellerProductList;
	}
	
	public List<ProductModel> getAllProduct() {
		List<ProductModel> productList = new ArrayList<>();
		productRepository.findAll().forEach(productList::add);
		return productList;
		
	}
	
	public List<ProductModel> getProducts(String proType) {
		List<ProductModel> productList = new ArrayList<>();
		productRepository.findAll().forEach(productList::add);
		List<ProductModel> searchProductList = new ArrayList<>();
		Iterator itr = productList.iterator();
		while (itr.hasNext()) {
			ProductModel searchProduct = (ProductModel) itr.next();
			if (searchProduct.getProType().contentEquals(proType)) {
				searchProductList.add(searchProduct);
			}
		}
		return searchProductList;
	}

}
