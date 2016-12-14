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
			return new ResponseEntity<List<Users>>(users,HttpStatus.NO_CONTENT);
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
	
	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public ResponseEntity<Users> login(@RequestBody Users users, HttpSession session) {
		logger.debug("Starting of the method login" );
		
		String user_id = users.getUser_id();
		String password = users.getPassword();
		 users = usersDAO.authenticate(user_id, password);
		if (users == null) {
			users = new Users();
			users.setErrorCode("404"); // NLP NullPointerException
			users.setErrorMessage("User does not exist with this id:" + user_id);
		} else {
			users.setIsOnline('Y');
			users.setErrorCode("200"); // NLP NullPointerException
			users.setErrorMessage("You have successfully logged");
	
			usersDAO.updateRow(users);

			session.setAttribute("loggedInUserID", users.getUser_id());
		}
		logger.debug("Ending of the method login" );
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/logout/", method = RequestMethod.GET)
	public ResponseEntity<Users> logout(HttpSession session) {
		logger.debug("Starting of the method logout" );
		
		String loggedInUserID= (String) session.getAttribute("loggedInUserID");
		
		logger.debug("loggedInUserID : " + loggedInUserID);
		
		users =usersDAO.getRowById(loggedInUserID);
		
		logger.debug("user:"+ users);
		users.setIsOnline('N');

		session.invalidate();

		if (usersDAO.updateRow(users)) {
			users.setErrorCode("200");
			users.setErrorMessage("You have logged out successfully");
		} else {
			users.setErrorCode("404");
			users.setErrorMessage("You could not logged. please contact admin");
		}
		logger.debug("Ending of the method logout" );
		return new ResponseEntity<Users>(users, HttpStatus.OK);

	}

	@RequestMapping(value = "/register/", method = RequestMethod.POST)
	public ResponseEntity<Users> register(@RequestBody Users users) {
		logger.debug("Starting of the method register" );
		if (usersDAO.getRowById(users.getUser_id()) != null) {
			users.setErrorCode("404");
			users.setErrorMessage("With this id, the record is already exist.  Please choose another id");
		} else {
			users.setStatus('N');
			if (usersDAO.save(users)) {
				users.setErrorCode("200");
				users.setErrorMessage("Your Registration is Successfull");

			} else {
				users.setErrorCode("405");
				users.setErrorMessage("Unable process your registration. Please contact Admin");
			}
		}
		logger.debug("Ending of the method register" );
		return new ResponseEntity<Users>(users, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/accept/{id}", method = RequestMethod.GET)
	public ResponseEntity<Users> accept(@PathVariable("user_id") String user_id) {
		logger.debug("Starting of the method register" );
		
		 	users = updateStatus(user_id, 'A', "");
			return new  ResponseEntity<Users>(users,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/reject/{id}/{reason}", method = RequestMethod.GET)
	public ResponseEntity<Users> reject(@PathVariable("user_id") String user_id ,@PathVariable("reason")  String reason) {
		logger.debug("Starting of the method register" );
		
		users = updateStatus(user_id, 'R', reason);
		return new  ResponseEntity<Users>(users,HttpStatus.OK);
		}
	
	
	private Users updateStatus(String user_id, char status, String reason)
	{
		logger.debug("Starting of the method updateStatus" );
		
		logger.debug("status: " + status);
		users = usersDAO.getRowById(user_id);
	  
	  if(users==null)
	  {
		  users = new Users();
		  users.setErrorCode("404");
		  users.setErrorMessage("Could not update the status");
	  }
	  else
	  {
		  users.setStatus(status);
		  users.setReason(reason);
		  usersDAO.updateRow(users);
	  }  
	  logger.debug("Ending of the method updateStatus" );
	return users;
	  
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
		usersDAO.deleteUser(user_id);
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
