package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "Category")
public class Category {
	@Id
	@GeneratedValue
	@Column(name = "idCategory")
	private int categoryID;
	
	@Column(name = "nameCategory")
	private String categoryName;
	
	@Column(name = "descCategory")
	private String categoryDescription;
	
	public Category() {
	}

	public Category(String categoryName,
			String categoryDescription) {
		
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
}
