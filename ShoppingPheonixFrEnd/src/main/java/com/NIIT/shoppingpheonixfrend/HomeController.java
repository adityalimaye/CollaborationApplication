package com.NIIT.shoppingpheonixfrend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
		@RequestMapping("/")
		public ModelAndView home() {
		   
		   System.out.println("Hello!Controller in execution");
		   ModelAndView mv = new ModelAndView("Home");
		   mv.addObject("message", "Hello Spring MVC Framework!");
		   return mv;
	   }
}


