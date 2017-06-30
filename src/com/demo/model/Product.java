package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name = "idProduct")
	private int productId;
	
	@Column(name = "nameProduct")
	private String productName;
	
	@Column(name = "descProduct")
	private String productDescption;
	
	@Column(name = "pPrice")
	private double productPrice;
	
	public Product() {
	}
	
	public Product(String productName,
			String productDescption, double productPrice) {
		super();
		
		this.productName = productName;
		this.productDescption = productDescption;
		this.productPrice = productPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescption() {
		return productDescption;
	}

	public void setProductDescption(String productDescption) {
		this.productDescption = productDescption;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
}
