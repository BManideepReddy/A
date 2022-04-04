package com.algo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class ProductModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ProductId;
	private String SellerName;
	private String ProCategory;
	private String ProType;
	private String ProName;
	private String ProPrice;
	
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProCategory() {
		return ProCategory;
	}
	public void setProCategory(String proCategory) {
		ProCategory = proCategory;
	}
	public String getProType() {
		return ProType;
	}
	public void setProType(String proType) {
		ProType = proType;
	}
	public String getProName() {
		return ProName;
	}
	public void setProName(String proName) {
		ProName = proName;
	}
	public String getProPrice() {
		return ProPrice;
	}
	public void setProPrice(String proPrice) {
		ProPrice = proPrice;
	}
	public String getSellerName() {
		return SellerName;
	}
	public void setSellerName(String sellerName) {
		SellerName = sellerName;
	}
	@Override
	public String toString() {
		return "ProductModel [ProductId=" + ProductId + ", SellerName=" + SellerName + ", ProCategory=" + ProCategory
				+ ", ProType=" + ProType + ", ProName=" + ProName + ", ProPrice=" + ProPrice + "]";
	}
	
	

}
