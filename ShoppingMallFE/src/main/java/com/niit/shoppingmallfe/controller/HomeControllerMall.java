package com.niit.shoppingmallfe.controller;

import java.io.File;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingmall.dao.ProductMallDAO;
import com.niit.shoppingmall.model.ProductMall;

@Controller
public class HomeControllerMall {
	
	/*@Autowired 
	ProductMallDAO productMallDAO;
	@Autowired
	ProductMall productMall;
	
	public ProductMallDAO getProductMallDAO() {
		return productMallDAO;
	}

	public void setProductMallDAO(ProductMallDAO productMallDAO) {
		this.productMallDAO = productMallDAO;
	}*/

	@RequestMapping("/")
	public ModelAndView Login() {

		System.out.println("Hello!Controller in execution");
		ModelAndView mv = new ModelAndView("/login");
		mv.addObject("message", "Hello Spring MVC Framework!");
		return mv;
	}
	
	
	
	/*public ModelAndView Home() {

		System.out.println("Hello!Controller in execution");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("message", "Hi!Glad to see you here");
		return mv;
	}
	
	@RequestMapping("/GroupTourConfirm")
	public ModelAndView GroupTourConfirm(){
		System.out.println("Hello you are Confirming user details");
		ModelAndView mv = new ModelAndView("/GroupTourConfirm");
		mv.addObject("message","Hi!Glad to see you here");
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
	
	
	@RequestMapping("/Register")
	public ModelAndView Register() {

		System.out.println("Hello!Registration Page");
		ModelAndView mv = new ModelAndView("Register");
		mv.addObject("message", "Please Register with correct credentials");
		mv.addObject("Register Check!", true);
		return mv;
	}
	
	@RequestMapping("/AddProduct")
	public ModelAndView AddProduct() {

		System.out.println("Adding Product");
		
		ModelAndView mv = new ModelAndView("AddProduct");
		mv.addObject("productMall", new ProductMall());
		
		List<ProductMall> productMallList = productMallDAO.getList();
		mv.addObject("productMallList",productMallList);
		mv.addObject("AddProduct", true);
		return mv;
	}	
	
	@RequestMapping("/saveproduct")
	public ModelAndView SaveProduct(@ModelAttribute("productMall") ProductMall productMall, BindingResult result) {

		
		ModelAndView mv = new ModelAndView("AddProduct");
		mv.addObject("productMall", true);
		productMallDAO.save(productMall);
		System.out.println("Save Product Successfull");
		List<ProductMall> productMallList = productMallDAO.getList();
		mv.addObject("productMallList",productMallList);
		return new ModelAndView("redirect:AddProduct");
	}
	
	@RequestMapping("/Delete")
	 public ModelAndView deleteUser(@RequestParam String id) {
	  String productMallDelete= productMallDAO.deleteRow(id);
	  return new ModelAndView("redirect:AddProduct");
	 }
	
	
	@RequestMapping("/Edit")
	public ModelAndView EditProduct(@RequestParam String id,@ModelAttribute("productMall") ProductMall productMall){
		ModelAndView mv = new ModelAndView("AddProduct");
		List<ProductMall> productMallList = productMallDAO.getList();
		mv.addObject("productMallList",productMallList);
		ProductMall productMallEdit = productMallDAO.getRowById(id);
		mv.addObject("productMallEdit",productMallEdit);
		return mv;
	}
	
	
	@RequestMapping("/Edit")
	 public ModelAndView editUser(@RequestParam String id,@ModelAttribute("productMall") String productMall) {
		ModelAndView mv = new ModelAndView("AddProduct");
		List<ProductMall> productMallList = productMallDAO.getList();
		mv.addObject("productMallList",productMallList);
		ProductMall productMallEdit = productMallDAO.getRowById(id);
		mv.addObject("productMallEdit", productMallEdit);
		return new ModelAndView("redirect:AddProduct");
	 }

	@RequestMapping("/Update")
	 public ModelAndView updateUser(@ModelAttribute("productMall") ProductMall productMall, BindingResult result) {
	  ModelAndView mv = new ModelAndView("AddProduct");	
	 
	  List<ProductMall> productMallList = (List<ProductMall>) productMallDAO.getList();
	  mv.addObject("productMallList",productMallList);
	  productMallDAO.updateRow(productMall);
	  return new ModelAndView("redirect:AddProduct");
	 }*/
	
}