package com.niit.shoppingmall.dao;

import java.util.List;


import com.niit.shoppingmall.model.ProductMall;


public interface ProductMallDAO {
	public int save(ProductMall productMall);
	public List<ProductMall> getList();
	public ProductMall getRowById(int id);
	public int updateRow(ProductMall productMall);
	public int deleteRow(int id);
	//public boolean deleteRow(ProductMall productMall);

}
