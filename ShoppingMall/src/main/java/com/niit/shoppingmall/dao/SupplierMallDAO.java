package com.niit.shoppingmall.dao;

import java.util.List;

import com.niit.shoppingmall.model.SupplierMall;


public interface SupplierMallDAO {
	public boolean save(SupplierMall supplierMall);
	public List<SupplierMall> getList();
	public SupplierMall getRowById(String id);
	public int updateRow(SupplierMall supplierMall);
	public String deleteRow(String id);

}
