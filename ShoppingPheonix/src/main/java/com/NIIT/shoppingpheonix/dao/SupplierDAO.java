package com.NIIT.shoppingpheonix.dao;

import java.util.List;

import com.NIIT.shoppingpheonix.model.Supplier;

public interface SupplierDAO {

	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier); 
	public boolean delete(Supplier supplier);
	public Supplier get(Supplier supplier);
	public List<Supplier> List(Supplier supplier);
	
}
