package com.niit.shoppingmall.dao;

import java.util.List;


import com.niit.shoppingmall.model.ProductMall;


public interface ProductMallDAO {
	public boolean save(ProductMall productMall);
	public List<ProductMall> getList();
	public ProductMall getRowById(String id);
	public int updateRow(ProductMall productMall);
	public String deleteRow(String id);
	//public boolean deleteRow(ProductMall productMall);

}
