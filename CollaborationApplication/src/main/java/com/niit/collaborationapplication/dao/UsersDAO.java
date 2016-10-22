package com.niit.collaborationapplication.dao;

import java.util.List;

import com.niit.collaborationapplication.model.Users;


public interface UsersDAO{
	public List<Users> getList();
	public Users getRowById(String user_id);
	public String save(Users users);
	public String updateRow(Users users);
	public String deleteRow(String user_id);
	public Users authenticate(String user_id,String password);
	
}
