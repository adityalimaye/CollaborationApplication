package com.niit.shoppingmall.dao;

import java.util.List;

import com.niit.shoppingmall.model.CategoryMall;



public interface CategoryMallDAO {

	public int save(CategoryMall categoryMall);
	public List<CategoryMall> getList();
	public CategoryMall getRowById(int id);
	public int updateRow(CategoryMall categoryMall);
	public int deleteRow(int id);
}
