package com.niit.shoppingmall.model;

import java.util.ArrayList
;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;


@Entity
@Table(name="supplier")
@Component
public class SupplierMall{
	@Id
	@GeneratedValue
	@Column(name="supp_id")
	private int id;
	
	@NotEmpty
	@NotNull
	@Column(name="supp_name")
	private String supp_name;
	
	@NotEmpty
	@NotNull
	@Column(name="supp_description")
	private String description;
	
	@NotEmpty
	@NotNull
	@Column(name="supp_address")
	private String address;
	
	@NotEmpty
	@NotNull
	@Column(name="supp_email_id")
	private String email_id;
	
	@NotEmpty
	@NotNull
	@Column(name="supp_contact_number")
	private String contact_number;
	

	@OneToMany(mappedBy="supplierMall")
	private List<ProductMall> productMall = new ArrayList<ProductMall>();
	
	public SupplierMall() {
		// TODO Auto-generated constructor stub
	}
	
	public SupplierMall(String supp_name, String description, String address, String email_id, String contact_number) {
		super();
		this.supp_name = supp_name;
		this.description = description;
		this.address = address;
		this.email_id = email_id;
		this.contact_number = contact_number;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSupp_name() {
		return supp_name;
	}

	public void setSupp_name(String supp_name) {
		this.supp_name = supp_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	/*public List<ProductMall> getProductMall() {
		return productMall;
	}

	public void setProductMall(List<ProductMall> productMall) {
		this.productMall = productMall;
	}*/

	
}



/*@Entity
@Table(name="supplier")
@Component
public class SupplierMall {
	
	@Id
	@Column(name="id")
	private String id;
	private String name;
	private String description;
	private double salary; 
	private String address;
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}*/
