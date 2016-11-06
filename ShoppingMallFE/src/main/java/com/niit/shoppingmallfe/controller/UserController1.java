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

import com.niit.shoppingmall.dao.UserDetailsMallDAO;
import com.niit.shoppingmall.model.UserDetailsMall;

@Controller
public class UserController1 {

	@Autowired
	UserDetailsMallDAO userDetailsMallDAO;
	
	@Autowired
	UserDetailsMall userDetailsMall;

	public UserDetailsMallDAO getUserDetailsMallDAO() {
		return userDetailsMallDAO;
	}

	public void setUserDetailsMallDAO(UserDetailsMallDAO userDetailsMallDAO) {
		this.userDetailsMallDAO = userDetailsMallDAO;
	}
	
	private String saveDirectory = "E:/Images/";
	
	@RequestMapping("/memberDetails")
	public ModelAndView AddUser() {

		System.out.println("Adding User");
		
		ModelAndView mv = new ModelAndView("memberDetails");
		mv.addObject("userDetailsMall", new UserDetailsMall());
		
		List<UserDetailsMall> userDetailsMallList = userDetailsMallDAO.getList();
		mv.addObject("userDetailsMallList",userDetailsMallList);
		mv.addObject("memberDetails", true);
		return mv;
	}	
	
	@RequestMapping("/saveuser1")
	public ModelAndView SaveUser(@ModelAttribute("userDetailsMall") UserDetailsMall userDetailsMall, BindingResult result, HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileUpload)throws Exception {

		
		ModelAndView mv = new ModelAndView("memberDetails");
		
		mv.addObject("userDetailsMall", true);
		userDetailsMallDAO.save(userDetailsMall);
		System.out.println("Save User Successfull");
		List<UserDetailsMall> userDetailsMallList = userDetailsMallDAO.getList();
		mv.addObject("userDetailsMallList",userDetailsMallList);
		
		System.out.println("description: " + request.getParameter("description"));
         
	        if (fileUpload != null && fileUpload.length > 0) {
	            for (CommonsMultipartFile aFile : fileUpload){
	                 
	                System.out.println("Saving file: " + aFile.getOriginalFilename());
	                 
	                if (!aFile.getOriginalFilename().equals("")) {
	                    aFile.transferTo(new File(saveDirectory + aFile.getOriginalFilename()));
	                }
	            }
	        }
	 
	        // returns to the view "Result"
	    return new ModelAndView("redirect:confirmDetails");
	}

	
	
	@RequestMapping(value="/confirmDetails")
	public ModelAndView ConfirmDetails(@RequestParam String id, @ModelAttribute("userDetailsMall") UserDetailsMall userDetailsMall){
		ModelAndView mv = new ModelAndView("confirmDetails");
		UserDetailsMall userDetailsMallEdit = userDetailsMallDAO.getRowById(id);
		mv.addObject("userDetailsMallEdit", userDetailsMallEdit);
		return mv;
	}
	
	/*@RequestMapping("/DeleteUsr1")
	 public ModelAndView DeleteUser(@RequestParam String id) {
	  String userDetailsMallDelete= userDetailsMallDAO.deleteRow(id);
	  return new ModelAndView("redirect:AddUser");
	 }
	
	
	@RequestMapping("/EditUsr1")
	public ModelAndView EditUser(@RequestParam String id,@ModelAttribute("userDetailsMall") UserDetailsMall userDetailsMall){
		ModelAndView mv = new ModelAndView("memberDetails");
		List<UserDetailsMall> userDetailsMallList = userDetailsMallDAO.getList();
		mv.addObject("userDetailsMallList", userDetailsMallList);
		UserDetailsMall userDetailsMallEdit = userDetailsMallDAO.getRowById(id);
		mv.addObject("userDetailsMallEdit", userDetailsMallEdit);
		return mv;
	}
	
	
	@RequestMapping("/UpdateUsers1")
	 public ModelAndView updateUser(@ModelAttribute("userDetailsMall") UserDetailsMall userDetailsMall, BindingResult result) {
	  ModelAndView mv = new ModelAndView("memberDetails");	
	 
	  List<UserDetailsMall> userDetailsMallList = (List<UserDetailsMall>) userDetailsMallDAO.getList();
	  mv.addObject("userDetailsMallList",userDetailsMallList);
	  userDetailsMallDAO.updateRow(userDetailsMall);
	  return new ModelAndView("redirect:confirmDetails");
	 }*/

}
