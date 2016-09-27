package com.niit.shoppingmall.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name="category")
@Component
public class CategoryMall {
	
	@Id
	@Column(name="CAT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	@Column(name="CAT_NAME")
	private String name;
	private String description;
	/*private List<ProductMall> productMall;*/
	
	@OneToMany
	@JoinColumn(name="PROD_ID")
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
	/*@OneToMany(targetEntity=ProductMall.class, mappedBy="categoryMall", cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public List<ProductMall> getProductMall() {
		return productMall;
	}
	public void setProductMall(List<ProductMall> productMall) {
		this.productMall = productMall;
	}*/

}
