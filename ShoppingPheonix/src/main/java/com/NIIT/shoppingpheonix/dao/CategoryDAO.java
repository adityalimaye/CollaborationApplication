package com.NIIT.shoppingpheonix.dao;

import com.NIIT.shoppingpheonix.model.Category;
import java.util.*;

public interface CategoryDAO {
	//Declare all CRUD operations
	
	public boolean save(Category category);
	public boolean update(Category category); 
	public boolean delete(Category category);
	public Category get(Category category);
	public List<Category> List(Category category);
}
