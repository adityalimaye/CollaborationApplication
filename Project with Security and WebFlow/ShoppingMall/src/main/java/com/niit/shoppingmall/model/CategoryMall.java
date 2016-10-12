package com.niit.shoppingmall.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name="category")
@Component
public class CategoryMall{
	
	@Id
	@GeneratedValue
	@Column(name="cat_id")
	private int id;
	

	@Column(name="cat_name")
	private String cat_name;
	
	
	@Column(name="cat_description")
	private String description;
	
	@OneToMany(mappedBy="categoryMall")
	private List<ProductMall> productMall = new ArrayList<ProductMall>();
	
	public CategoryMall() {
		// TODO Auto-generated constructor stub
	}
	
	public CategoryMall(String cat_name, String description) {
		super();
		this.cat_name = cat_name;
		this.description = description;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductMall> getProductMall() {
		return productMall;
	}

	public void setProductMall(List<ProductMall> productMall) {
		this.productMall = productMall;
	}
	
}













/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="category")
@Component
public class CategoryMall {
	
	@Id
	
	private String id;
	private String name;
	private String description;
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

}*/
