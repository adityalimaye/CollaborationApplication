package com.NIIT.shoppingmart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.NIIT.shoppingpheonix.dao.CategoryDAO;
import com.NIIT.shoppingpheonix.dao.ProductDAO;
import com.NIIT.shoppingpheonix.model.Product;


@Controller
public class HomeController {

	@Autowired
	ProductDAO productDAO;
	
	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	//@Autowired
	//CategoryDAO categoryDAO;
	
	@RequestMapping("/")
	public ModelAndView FlyAroundTheGlobe() {

		System.out.println("Hello!Controller in execution");
		ModelAndView mv = new ModelAndView("FlyAroundTheGlobe");
		mv.addObject("message", "Hello Spring MVC Framework!");
		return mv;
	}

	@RequestMapping("/Home")
	public ModelAndView Home() {

		System.out.println("Hello!Controller in execution");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("message", "Hi!Glad to see you here");
		return mv;
	}

	@RequestMapping("/Login")
	public ModelAndView Login() {

		System.out.println("Hello!Login Page");
		ModelAndView mv = new ModelAndView("Login");
		mv.addObject("message", "Please Login with correct credentials");
		mv.addObject("Login Check!", true);
		return mv;
	}

	@RequestMapping("/AddProduct")
	public ModelAndView AddProduct() {

		System.out.println("Adding Product");
		ModelAndView mv = new ModelAndView("AddProduct");
		mv.addObject("product", new Product());
		mv.addObject("AddProduct", true);
		return mv;

	}

	@RequestMapping("/saveproduct")
	public ModelAndView SaveProduct(@ModelAttribute("product") Product product, BindingResult result) {

		
		System.out.println("Save Product Successfull");
		ModelAndView mv = new ModelAndView("AddProduct");
		mv.addObject("product", true);
		productDAO.save(product);
		return new ModelAndView("FlyAroundTheGlobe");
		
	}
}
