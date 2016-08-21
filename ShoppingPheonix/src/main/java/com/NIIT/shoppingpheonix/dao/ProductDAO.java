package com.NIIT.shoppingpheonix.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.NIIT.shoppingpheonix.model.Product;

@Repository
public interface ProductDAO {
	//Declare all CRUD operations
	
	public boolean save(Product product);
	public boolean update(Product product); 
	public boolean delete(Product product);
	public Product get(String id);
	public List<Product> list();
}



