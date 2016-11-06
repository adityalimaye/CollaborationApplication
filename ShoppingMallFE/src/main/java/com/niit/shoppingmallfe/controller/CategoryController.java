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

import com.niit.shoppingmall.dao.CategoryMallDAO;
import com.niit.shoppingmall.dao.ProductMallDAO;

import com.niit.shoppingmall.model.CategoryMall;
import com.niit.shoppingmall.model.ProductMall;

import com.niit.shoppingmallfe.util.FileUtil;

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
		
		@Autowired
		FileUtil fileUtil;
		
		public CategoryMallDAO getCategoryMallDAO() {
			return categoryMallDAO;
		}

		public void setCategoryMallDAO(CategoryMallDAO categoryMallDAO) {
			this.categoryMallDAO = categoryMallDAO;
		}
		
		public CategoryMall getCategoryMall() {
			return categoryMall;
		}

		public void setCategoryMall(CategoryMall categoryMall) {
			this.categoryMall = categoryMall;
		}

		public ProductMallDAO getProductMallDAO() {
			return productMallDAO;
		}

		public void setProductMallDAO(ProductMallDAO productMallDAO) {
			this.productMallDAO = productMallDAO;
		}

		public ProductMall getProductMall() {
			return productMall;
		}

		public void setProductMall(ProductMall productMall) {
			this.productMall = productMall;
		}

		private String uploadFolderPath;
		
		public String getUploadFolderPath() {
			return uploadFolderPath;
		}

		public void setUploadFolderPath(String uploadFolderPath) {
			this.uploadFolderPath = uploadFolderPath;
		}

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
		public ModelAndView SaveCategory(@ModelAttribute("categoryMall") CategoryMall categoryMall,@RequestParam("fileData") MultipartFile fileData, HttpServletRequest request,HttpServletResponse response, BindingResult result) throws Exception{

			ModelAndView mv = new ModelAndView("AddCategory");
			
			uploadFolderPath = fileUtil.upload(fileData);
			categoryMall.setImagepath(uploadFolderPath);
			
			mv.addObject("categoryMall", true);
			categoryMallDAO.save(categoryMall);
			System.out.println("Save Category Successfull");
			List<CategoryMall> categoryMallList = categoryMallDAO.getList();
			mv.addObject("categoryMallList",categoryMallList);
			
			return new ModelAndView("redirect:AddCategory");
		}
		
		@RequestMapping("/DeleteCat")
		 public ModelAndView DeleteCategory(@RequestParam int id) {
		 @SuppressWarnings("unused")
		int categoryMallDelete = categoryMallDAO.deleteRow(id);
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