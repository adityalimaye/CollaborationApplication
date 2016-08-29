package com.NIIT.shoppingpheonix.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.NIIT.shoppingpheonix.model.Category;


public interface CategoryDAO {
	//Declare all CRUD operations
	
	public boolean save(Category category);
	public boolean update(Category category); 
	public boolean delete(Category category);
	public Category get(String id);
	public List<Category> list();
}

