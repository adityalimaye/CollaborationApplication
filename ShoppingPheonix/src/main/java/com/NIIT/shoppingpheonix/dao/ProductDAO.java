package com.NIIT.shoppingpheonix.dao;

import com.NIIT.shoppingpheonix.model.Product;
import java.util.*;

public interface ProductDAO {
	//Declare all CRUD operations
	
	public boolean save(Product product);
	public boolean update(Product product); 
	public boolean delete(Product product);
	public Product get(Product product);
	public List<Product> List(Product product);
}
