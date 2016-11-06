package com.niit.shoppingmallfe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeControllerMall {
	
	@RequestMapping("/")
	public ModelAndView Login() {

		System.out.println("Hello!Controller in execution");
		ModelAndView mv = new ModelAndView("/login");
		mv.addObject("message", "Hello Spring MVC Framework!");
		return mv;
	}
}