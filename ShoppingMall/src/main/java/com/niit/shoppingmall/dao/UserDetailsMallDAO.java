package com.niit.shoppingmall.dao;

import java.util.List;

import com.niit.shoppingmall.model.UserDetailsMall;


public interface UserDetailsMallDAO {
	public String save(UserDetailsMall userDetailsMall);
	public List<UserDetailsMall> getList();
	public UserDetailsMall getRowById(String id);
	public String updateRow(UserDetailsMall userDetailsMall);
	public String deleteRow(String id);

}
