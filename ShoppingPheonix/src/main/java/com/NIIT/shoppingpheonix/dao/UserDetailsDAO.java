package com.NIIT.shoppingpheonix.dao;

import java.util.List;

import com.NIIT.shoppingpheonix.model.UserDetails;

public interface UserDetailsDAO {

	public boolean save(UserDetails userdetails);
	public boolean update(UserDetails userdetails); 
	public boolean delete(UserDetails userdetails);
	public UserDetails get(UserDetails userdetails);
	public List<UserDetails> List(UserDetails userdetails);
}
