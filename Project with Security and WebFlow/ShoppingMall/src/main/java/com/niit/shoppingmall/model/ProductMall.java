package com.niit.shoppingmall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	@ManyToOne
	@JoinColumn(name="supp_id")
	private SupplierMall supplierMall;
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	private CategoryMall categoryMall;
	
	/*@Column(name="cat_id")
	private int cat_id;
	
	@Column(name="supp_id")
	private int supp_id;*/
	
	/*private CategoryMall categoryMall;
	
	private SupplierMall supplierMall;*/
	
	public ProductMall() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductMall(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
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

	public SupplierMall getSupplierMall() {
		return supplierMall;
	}

	public void setSupplierMall(SupplierMall supplierMall) {
		this.supplierMall = supplierMall;
	}

	public CategoryMall getCategoryMall() {
		return categoryMall;
	}

	public void setCategoryMall(CategoryMall categoryMall) {
		this.categoryMall = categoryMall;
	}

	

	
	
	
	
	/*public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public int getSupp_id() {
		return supp_id;
	}

	public void setSupp_id(int supp_id) {
		this.supp_id = supp_id;
	}*/

	
	
	

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
