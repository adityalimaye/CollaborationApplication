package com.niit.shoppingmallfe.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingmall.dao.CategoryMallDAO;
import com.niit.shoppingmall.dao.ProductMallDAO;
import com.niit.shoppingmall.model.CategoryMall;
import com.niit.shoppingmall.model.ProductMall;

@Controller
public class CategoryController {

		@Autowired
		CategoryMallDAO categoryMallDAO;
		
		@Autowired
		CategoryMall categoryMall;
		
		@Autowired 
		ProductMallDAO productMallDAO;
		
		@Autowired
		ProductMall productMall;
		
		public CategoryMallDAO getCategoryMallDAO() {
			return categoryMallDAO;
		}

		public void setCategoryMallDAO(CategoryMallDAO categoryMallDAO) {
			this.categoryMallDAO = categoryMallDAO;
		}

		private String saveDirectory = "E:/Images/";
		
		@RequestMapping("/AddCategory")
		public ModelAndView AddCategory() {

			System.out.println("Adding Category");
			
			ModelAndView mv = new ModelAndView("AddCategory");
			mv.addObject("categoryMall", new CategoryMall());
			
			List<CategoryMall> categoryMallList = categoryMallDAO.getList();
			mv.addObject("categoryMallList",categoryMallList);
			mv.addObject("AddCategory", true);
			return mv;
		}
		
		
		
		@RequestMapping("/savecategory")
		public ModelAndView SaveCategory(@ModelAttribute("categoryMall") CategoryMall categoryMall, BindingResult result,HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileUpload) throws Exception{

			
			ModelAndView mv = new ModelAndView("AddCategory");
			mv.addObject("categoryMall", true);
			categoryMallDAO.save(categoryMall);
			System.out.println("Save Category Successfull");
			List<CategoryMall> categoryMallList = categoryMallDAO.getList();
			mv.addObject("categoryMallList",categoryMallList);
			
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
	   return new ModelAndView("redirect:AddCategory");
		}
		
		@RequestMapping("/DeleteCat")
		 public ModelAndView DeleteCategory(@RequestParam int id) {
		  int categoryMallDelete= categoryMallDAO.deleteRow(id);
		  return new ModelAndView("redirect:AddCategory");
		 }
		
		
		@RequestMapping("/EditCat")
		public ModelAndView EditCategory(@RequestParam int id,@ModelAttribute("categoryMall") CategoryMall categoryMall){
			ModelAndView mv = new ModelAndView("AddCategory");
			List<CategoryMall> categoryMallList = categoryMallDAO.getList();
			mv.addObject("categoryMallList",categoryMallList);
			CategoryMall categoryMallEdit = categoryMallDAO.getRowById(id);
			mv.addObject("categoryMallEdit",categoryMallEdit);
			return mv;
		}
		
		@RequestMapping("/UpdateCategory")
		 public ModelAndView updateCategory(@ModelAttribute("categoryMall") CategoryMall categoryMall, BindingResult result) {
		  ModelAndView mv = new ModelAndView("AddCategory");	
		 
		  List<CategoryMall> categoryMallList = (List<CategoryMall>) categoryMallDAO.getList();
		  mv.addObject("categoryMallList",categoryMallList);
		  categoryMallDAO.updateRow(categoryMall);
		  return new ModelAndView("redirect:AddCategory");
		 }
		
		
}
