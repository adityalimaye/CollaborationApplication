package com.niit.collaborationapplication.dao;

import java.util.List;

import com.niit.collaborationapplication.model.Users;


public interface UsersDAO{
	/*public Users makeAdmin(Users users);*/
	public List<Users> getList();
	public Users getRowById(String user_id);
	public boolean save(Users users);
	public boolean updateRow(Users users);
	public boolean deleteUser(String user_id);
	public Users authenticate(String user_id,String password);
	
}
