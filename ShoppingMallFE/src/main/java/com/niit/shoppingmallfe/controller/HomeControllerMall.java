package com.niit.shoppingmallfe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeControllerMall {
	
	@RequestMapping("/")
	public ModelAndView Home() {

		System.out.println("Hello!You are on the home page");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("message", "Hi!Glad to see you here");
		return mv;
	}

	@RequestMapping("/FlyAroundTheGlobe")
	public ModelAndView FlyAroundTheGlobe(){
		System.out.println("Hello!On Admin Page");
		ModelAndView mv = new ModelAndView("/FlyAroundTheGlobe");
		mv.addObject("message","Successfully Logged In");
		return mv;
	}
	@RequestMapping("/Register")
	public ModelAndView Register() {

		System.out.println("Hello!Registration Page");
		ModelAndView mv = new ModelAndView("Register");
		mv.addObject("message", "Please Register with correct credentials");
		mv.addObject("Register Check!", true);
		return mv;
	}
}