package com.niit.shoppingmall.dao;

import java.util.List;

import com.niit.shoppingmall.model.CategoryMall;



public interface CategoryMallDAO {

	public boolean save(CategoryMall categoryMall);
	public List<CategoryMall> getList();
	public CategoryMall getRowById(String id);
	public int updateRow(CategoryMall categoryMall);
	public String deleteRow(String id);
}
