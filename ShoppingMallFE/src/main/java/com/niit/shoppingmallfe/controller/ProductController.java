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
import com.niit.shoppingmall.dao.SupplierMallDAO;
import com.niit.shoppingmall.model.CategoryMall;
import com.niit.shoppingmall.model.ProductMall;
import com.niit.shoppingmall.model.SupplierMall;
import com.niit.shoppingmallfe.util.FileUtil;

@Controller
public class ProductController {
	
	@Autowired 
	ProductMallDAO productMallDAO;
	@Autowired
	ProductMall productMall;
	
	@Autowired
	CategoryMallDAO categoryMallDAO;
	@Autowired
	CategoryMall categoryMall;
	
	@Autowired
	SupplierMallDAO supplierMallDAO;
	@Autowired 
	SupplierMall supplierMall;
	
	@Autowired
	FileUtil fileUtil;
	
	public ProductMallDAO getProductMallDAO() {
		return productMallDAO;
	}

	public void setProductMallDAO(ProductMallDAO productMallDAO) {
		this.productMallDAO = productMallDAO;
	}
	
	public CategoryMallDAO getCategoryMallDAO() {
		return categoryMallDAO;
	}

	public void setCategoryMallDAO(CategoryMallDAO categoryMallDAO) {
		this.categoryMallDAO = categoryMallDAO;
	}

	public SupplierMallDAO getSupplierMallDAO() {
		return supplierMallDAO;
	}

	public void setSupplierMallDAO(SupplierMallDAO supplierMallDAO) {
		this.supplierMallDAO = supplierMallDAO;
	}
	
	public ProductMall getProductMall() {
		return productMall;
	}

	public void setProductMall(ProductMall productMall) {
		this.productMall = productMall;
	}

	public CategoryMall getCategoryMall() {
		return categoryMall;
	}

	public void setCategoryMall(CategoryMall categoryMall) {
		this.categoryMall = categoryMall;
	}

	public SupplierMall getSupplierMall() {
		return supplierMall;
	}

	public void setSupplierMall(SupplierMall supplierMall) {
		this.supplierMall = supplierMall;
	}
	
	private String uploadFolderPath;
	
	public String getUploadFolderPath() {
		return uploadFolderPath;
	}

	public void setUploadFolderPath(String uploadFolderPath) {
		this.uploadFolderPath = uploadFolderPath;
	}

	
	@RequestMapping("/AddProduct")
	public ModelAndView AddProduct() {

		System.out.println("Adding Product");
		
		ModelAndView mv = new ModelAndView("AddProduct");
		mv.addObject("productMall", new ProductMall());
		
		List<ProductMall> productMallList = productMallDAO.getList();
		List<CategoryMall> categoryMallList = categoryMallDAO.getList();
		List<SupplierMall> supplierMallList = supplierMallDAO.getList();
		mv.addObject("supplierMallList",supplierMallList);
		mv.addObject("categoryMallList",categoryMallList);
		mv.addObject("productMallList",productMallList);
		mv.addObject("AddProduct", true);
		return mv;
	}	
	
	
	
	@RequestMapping(value="/saveproduct")
	public ModelAndView SaveProduct(@ModelAttribute("productMall") ProductMall productMall, @RequestParam("fileData") MultipartFile fileData, HttpServletRequest request ,HttpServletResponse response ,BindingResult result)throws Exception {
		ModelAndView mv = new ModelAndView("AddProduct");
		
		uploadFolderPath = fileUtil.upload(fileData);
		
		productMall.setImagepath(uploadFolderPath);
		
		mv.addObject("productMall", true);
		productMallDAO.save(productMall);
		System.out.println("Save Product Successfull");
		List<ProductMall> productMallList = productMallDAO.getList();
		List<CategoryMall> categoryMallList = categoryMallDAO.getList();
		List<SupplierMall> supplierMallList = supplierMallDAO.getList();
		mv.addObject("supplierMallList",supplierMallList);
		mv.addObject("categoryMallList",categoryMallList);
		mv.addObject("productMallList",productMallList);
			
		return new ModelAndView("redirect:AddProduct");
	}
	
	
	@RequestMapping("/Delete")
	 public ModelAndView DeleteProduct(@RequestParam int id) {
	  @SuppressWarnings("unused")
	int productMallDelete= productMallDAO.deleteRow(id);
	  return new ModelAndView("redirect:AddProduct");
	 }
	
	
	@RequestMapping("/Edit")
	public ModelAndView EditProduct(@RequestParam int id,@ModelAttribute("productMall") ProductMall productMall){
		ModelAndView mv = new ModelAndView("AddProduct");
		List<ProductMall> productMallList = productMallDAO.getList();
		List<CategoryMall> categoryMallList = categoryMallDAO.getList();
		List<SupplierMall> supplierMallList = supplierMallDAO.getList();
		mv.addObject("supplierMallList",supplierMallList);
		mv.addObject("categoryMallList",categoryMallList);
		mv.addObject("productMallList",productMallList);
		ProductMall productMallEdit = productMallDAO.getRowById(id);
		mv.addObject("productMallEdit",productMallEdit);
		return mv;
	}
	
	@RequestMapping("/UpdateProduct")
	 public ModelAndView updateProduct(@ModelAttribute("productMall") ProductMall productMall, BindingResult result) {
	  ModelAndView mv = new ModelAndView("AddProduct");	
	 
	  List<ProductMall> productMallList = (List<ProductMall>) productMallDAO.getList();
	  List<CategoryMall> categoryMallList =(List<CategoryMall>) categoryMallDAO.getList();
	  List<SupplierMall> supplierMallList =(List<SupplierMall>) supplierMallDAO.getList();
	  mv.addObject("supplierMallList",supplierMallList);
	  mv.addObject("categoryMallList",categoryMallList);
	  mv.addObject("productMallList",productMallList);
	  productMallDAO.updateRow(productMall);
	  return new ModelAndView("redirect:AddProduct");
	 }

}
