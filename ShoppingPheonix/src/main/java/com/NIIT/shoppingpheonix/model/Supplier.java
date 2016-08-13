package com.NIIT.shoppingpheonix.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
//import javax.persistence.Id;

@Entity
@Table(name="suppliertab")
@Component
public class Supplier {
	
	@javax.persistence.Id
	private String name;
	private String Id;
	private String address;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
