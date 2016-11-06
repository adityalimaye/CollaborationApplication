package com.niit.shoppingmall.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="product")
@Component

public class ProductMall {
	
	@Id
	@GeneratedValue
	@Column(name="prod_id")
	private int id;
	
	@NotEmpty
	@NotNull
	@Column(name="prod_name")
	private String name;
	
	@NotEmpty
	@NotNull
	@Column(name="prod_description")
	private String description;

	@Column(name="prod_price")
	private double price;
	
	
	@Column(name="imagepath")
	private String imagepath;
	
	@Transient
	private MultipartFile fileData;

	@ManyToOne
	@JoinColumn(name="supp_id")
	private SupplierMall supplierMall;
	
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	private CategoryMall categoryMall;
	
	public ProductMall() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductMall(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public MultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(MultipartFile fileData) {
		this.fileData = fileData;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
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

}