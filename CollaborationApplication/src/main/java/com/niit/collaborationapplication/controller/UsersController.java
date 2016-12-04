package com.niit.collaborationapplication.controller;

import java.util.List;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationapplication.dao.UsersDAO;
import com.niit.collaborationapplication.model.Users;

@RestController
public class UsersController {
		
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	Users users;
	
	@Autowired
	UsersDAO usersDAO;
	
	/*	http://localhost:8080/CollaborationApplication/users/makeAdmin/aditya123	*/
	@RequestMapping(value="/users/makeAdmin/{user_id}", method = RequestMethod.POST)
	public ResponseEntity<Users> makeAdmin(@PathVariable("user_id") String empID){
		users = usersDAO.getRowById(empID);
		
		if(users == null){
			users = new Users();
			users.setErrorCode("404");
			users.setErrorMessage("Employee does not exist");
			return new ResponseEntity<Users>(users, HttpStatus.NOT_FOUND);
		}
		
		String role = "{Employee,Admin}";
		
		users.setUser_role(role);
		usersDAO.updateRow(users);
		
		return new ResponseEntity<Users>(users,HttpStatus.NOT_FOUND);
	}
	
	/*	http://localhost:8080/CollaborationApplication/users	*/
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public ResponseEntity<List<Users>> listAllUsers(){
		logger.debug("->->->-> Calling method listAllUsers");
		List<Users> users = usersDAO.getList();
		if(users.isEmpty()){
			return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Users>>(users,HttpStatus.OK);
	}
	
	/*	http://localhost:8080/CollaborationApplication/users/rah123	*/
	@RequestMapping(value="/users/{user_id}", method = RequestMethod.GET)
	public ResponseEntity<Users> getUserById(@PathVariable("user_id")String user_id){
		logger.debug("->->->-> Calling method getUserById");
		
		Users users = usersDAO.getRowById(user_id);
		if(users == null){
			logger.debug("->->->-> User with id{} not found"+user_id);
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Users>(users,HttpStatus.OK);
	}
	
	/*	http://localhost:8080/CollaborationApplication/users/	*/
	@RequestMapping(value="/users/", method = RequestMethod.POST)
	public ResponseEntity<Users> createUsers(@RequestBody Users users){
		logger.debug("->->->-> calling method createUser");
		if(usersDAO.getRowById(users.getUser_id())==null){
					
			usersDAO.save(users);
			return new ResponseEntity<Users>(users,HttpStatus.OK);
		}
			
		logger.debug("User already exist with this id!" +users.getUser_id());
		users.setErrorMessage("User already exist with this id:" +users.getUser_id());
		return new ResponseEntity<Users>(users,HttpStatus.OK);
		
	}
	
	/*	http://localhost:8080/CollaborationApplication/users/rah123	*/
	@RequestMapping(value="/users/{user_id}",method= RequestMethod.PUT)
	public ResponseEntity<Users> updateUser(@PathVariable("user_id") String user_id,@RequestBody Users users){
		logger.debug("->->->-> calling method updateUser");
		if(usersDAO.getRowById(user_id)==null){
			logger.debug("User does not exist with this id");
			users.setErrorMessage("User does not exist with this id:" +users.getUser_id());
			users = new Users();
			return new ResponseEntity<Users>(users,HttpStatus.NOT_FOUND);
		}
		
		usersDAO.updateRow(users);
		logger.debug("->->->-> User updated successfully");
		return new ResponseEntity<Users>(users,HttpStatus.OK);
	}
	
	/*	http://localhost:8080/CollaborationApplication/users/sam123	*/
	@RequestMapping(value="/users/{user_id}",method = RequestMethod.DELETE)
	public ResponseEntity<Users> deleteUsers(@PathVariable("user_id") String user_id){
		logger.debug("->->->->calling method DeleteUser");
		Users users = usersDAO.getRowById(user_id);
		if (users==null) {
			logger.debug("->->->->User does not exist with this id"+user_id);
			users = new Users();
			users.setErrorMessage("User does not exist with this id:" +users.getUser_id());
			return new ResponseEntity<Users>(users,HttpStatus.NOT_FOUND);
		}
		usersDAO.deleteRow(user_id);
		logger.debug("Users deleted successfully");
		return new ResponseEntity<Users>(HttpStatus.OK);
	}
	
	/*	http://localhost:8080/CollaborationApplication/users/authenticate	*/
	@RequestMapping(value="/users/authenticate",method= RequestMethod.POST)
	public ResponseEntity<Users> authenticate(@RequestBody Users users, HttpSession session){
		logger.debug("->->->->calling method authenticate");
		users = usersDAO.authenticate(users.getUser_id(), users.getPassword());
		
		if(users==null){
			users = new Users();
			users.setErrorMessage("Invalid Credentials!Please enter valid credentials");
		}
		else
		{
			logger.debug("Valid Credentials");
			session.setAttribute("loggedInUser", users);
			session.setAttribute("loggedInUserID", users.getUser_id());
		}
		
		return new ResponseEntity<Users>(users,HttpStatus.OK);
	}

}
