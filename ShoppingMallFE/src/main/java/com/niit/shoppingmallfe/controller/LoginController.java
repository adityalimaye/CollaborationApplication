package com.niit.shoppingmallfe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("Login")
	public ModelAndView getLoginForm(@RequestParam(required=false)String authfailed,String logout,String denied){
			String message = "";
			
			if(authfailed != null){
				message="Invalid username or password,try again!!!";
			}
			else if(logout != null){
				message="Logged Out Successfully,login again to continue!";
			}
			else if(denied != null){
				message = "Access denied for this user!!!";
			}
		return new ModelAndView("Login","message",message);
	}
	
	@RequestMapping("user")
	 public String geUserPage() {
	  return "user";
	 }

	 @RequestMapping("admin")
	 public String geAdminPage() {
	  return "admin";
	 }

	 @RequestMapping("403page")
	 public String ge403denied() {
		 System.out.println("ACCESS IS DENIED!!!");
	  return "redirect:login?denied";
	 }
}

