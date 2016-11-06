package com.niit.shoppingmall.dao;

import java.util.List;

import com.niit.shoppingmall.model.SupplierMall;


public interface SupplierMallDAO {
	public int save(SupplierMall supplierMall);
	public List<SupplierMall> getList();
	public SupplierMall getRowById(int id);
	public int updateRow(SupplierMall supplierMall);
	public int deleteRow(int id);

}
