package com.niit.shoppingmallfe.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView getLoginForm(@RequestParam(required=false) String authfailed,String logout,String denied){
		
		String message ="";
		if(authfailed!=null){
			message = "Invalid UserName or Password, try again!";
		}else if(logout!=null){
			message="Logged Out Successfully, Login again to continue !";
		}else if(denied!=null){
			message="Access denied for this user!";
		}
		return new ModelAndView("/login","message",message);	
				
	}
	
	//@PreAuthorize(value = "hasRole('ROLE_USER')")
	@RequestMapping("/UserLanding")
	 public String geUserPage() {
	  return "UserLanding";
	 }

	//@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	 @RequestMapping("/FlyAroundTheGlobe")
	 public String geAdminPage() {
	  return "FlyAroundTheGlobe";
	 }

	 @RequestMapping("403page")
	 public String ge403denied() {
	  return "redirect:login?denied";
	 }
	 
	 @RequestMapping("/grpTour1")
	 public String grpTour1(){
		 return "grpTour1";
	 }
	 
	 @RequestMapping("/londonBridge")
	 public String londonBridge(){
		 return "londonBridge";
	}
	 
	 @RequestMapping("/manasluExpedition")
	 public String manasluExpedition(){
		 return "manasluExpedition";
	 }
	 
	 @RequestMapping("/theMariendom")
	 public String theMariendom(){
		 return "theMariendom";
	 }
	 
	 @RequestMapping("/veniceItaly")
	 public String veniceItaly(){
		 return "veniceItaly";
	 }
	
}
