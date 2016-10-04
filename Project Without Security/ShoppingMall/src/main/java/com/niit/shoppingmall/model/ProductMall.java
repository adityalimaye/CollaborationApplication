package com.niit.shoppingmall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="product")
@Component

public class ProductMall {
	
	@Id
	@GeneratedValue
	@Column(name="prod_id")
	private int id;
	
	@Column(name="prod_name")
	private String name;
	
	
	@Column(name="prod_description")
	private String description;
	
	@Column(name="prod_price")
	private double price;
	
	@Column(name="cat_name")
	private String cat_name;
	
	@Column(name="supp_name")
	private String supp_name;
	
	/*private CategoryMall categoryMall;
	
	private SupplierMall supplierMall;*/
	
	public ProductMall() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getSupp_name() {
		return supp_name;
	}

	public void setSupp_name(String supp_name) {
		this.supp_name = supp_name;
	}
	
	

	/*public CategoryMall getCategoryMall() {
		return categoryMall;
	}

	public void setCategoryMall(CategoryMall categoryMall) {
		this.categoryMall = categoryMall;
	}

	public SupplierMall getSupplierMall() {
		return supplierMall;
	}

	public void setSupplierMall(SupplierMall supplierMall) {
		this.supplierMall = supplierMall;
	}*/
	
}








/*import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Product")
@Component
public class ProductMall {
	
	@Id
	private String  id;
	private String name;
	private String description;
	private double price;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}*/
