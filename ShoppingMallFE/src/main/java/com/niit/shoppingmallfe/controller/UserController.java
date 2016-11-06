package com.niit.shoppingmallfe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingmall.dao.UserDetailsMallDAO;
import com.niit.shoppingmall.model.UserDetailsMall;

import com.niit.shoppingmallfe.util.FileUtil;

@Controller
public class UserController {
	
	@Autowired
	UserDetailsMallDAO userDetailsMallDAO;
	@Autowired
	UserDetailsMall userDetailsMall;
	
	@Autowired
	FileUtil fileUtil;
	
	public UserDetailsMallDAO getUserDetailsMallDAO() {
		return userDetailsMallDAO;
	}

	public void setUserDetailsMallDAO(UserDetailsMallDAO userDetailsMallDAO) {
		this.userDetailsMallDAO = userDetailsMallDAO;
	}
	
	public UserDetailsMall getUserDetailsMall() {
		return userDetailsMall;
	}

	public void setUserDetailsMall(UserDetailsMall userDetailsMall) {
		this.userDetailsMall = userDetailsMall;
	}



	private String uploadFolderPath;
	
	public String getUploadFolderPath() {
		return uploadFolderPath;
	}

	public void setUploadFolderPath(String uploadFolderPath) {
		this.uploadFolderPath = uploadFolderPath;
	}

	@RequestMapping("/AddUser")
	public ModelAndView AddUser() {

		System.out.println("Adding User");
		
		ModelAndView mv = new ModelAndView("AddUser");
		mv.addObject("userDetailsMall", new UserDetailsMall());
		
		List<UserDetailsMall> userDetailsMallList = userDetailsMallDAO.getList();
		mv.addObject("userDetailsMallList",userDetailsMallList);
		mv.addObject("AddUser", true);
		return mv;
	}	
	
	@RequestMapping("/saveuser")
	public ModelAndView SaveUser(@ModelAttribute("userDetailsMall") UserDetailsMall userDetailsMall,@RequestParam("fileData") MultipartFile fileData,HttpServletRequest request, HttpServletResponse response,BindingResult result)throws Exception {

		
		ModelAndView mv = new ModelAndView("AddUser");
		
		uploadFolderPath = fileUtil.upload(fileData);
		userDetailsMall.setImagepath(uploadFolderPath);
		
		mv.addObject("userDetailsMall", true);
		userDetailsMallDAO.save(userDetailsMall);
		System.out.println("Save User Successfull");
		List<UserDetailsMall> userDetailsMallList = userDetailsMallDAO.getList();
		mv.addObject("userDetailsMallList",userDetailsMallList);
		
		return new ModelAndView("redirect:AddUser");
	}
	
	@RequestMapping("/DeleteUsr")
	public ModelAndView DeleteUser(@RequestParam String id) {
		@SuppressWarnings("unused")
		String userDetailsMallDelete= userDetailsMallDAO.deleteRow(id);
		return new ModelAndView("redirect:AddUser");
	 }
	
	
	@RequestMapping("/EditUsr")
	public ModelAndView EditUser(@RequestParam String id,@ModelAttribute("userDetailsMall") UserDetailsMall userDetailsMall){
		ModelAndView mv = new ModelAndView("AddUser");
		List<UserDetailsMall> userDetailsMallList = userDetailsMallDAO.getList();
		mv.addObject("userDetailsMallList", userDetailsMallList);
		UserDetailsMall userDetailsMallEdit = userDetailsMallDAO.getRowById(id);
		mv.addObject("userDetailsMallEdit", userDetailsMallEdit);
		return mv;
	}
	
	
	@RequestMapping("/UpdateUsers")
	 public ModelAndView updateUser(@ModelAttribute("userDetailsMall") UserDetailsMall userDetailsMall, BindingResult result) {
	  ModelAndView mv = new ModelAndView("AddUser");	
	 
	  List<UserDetailsMall> userDetailsMallList = (List<UserDetailsMall>) userDetailsMallDAO.getList();
	  mv.addObject("userDetailsMallList",userDetailsMallList);
	  userDetailsMallDAO.updateRow(userDetailsMall);
	  return new ModelAndView("redirect:AddUser");
	 }

}
