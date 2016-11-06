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

import com.niit.shoppingmall.dao.ProductMallDAO;
import com.niit.shoppingmall.dao.SupplierMallDAO;

import com.niit.shoppingmall.model.ProductMall;
import com.niit.shoppingmall.model.SupplierMall;

import com.niit.shoppingmallfe.util.FileUtil;

@Controller
public class SupplierController {

	@Autowired
	SupplierMallDAO supplierMallDAO;
	@Autowired
	SupplierMall supplierMall;
	
	@Autowired 
	ProductMallDAO productMallDAO;
	@Autowired
	ProductMall productMall;
	
	@Autowired
	FileUtil fileUtil;

	
	public SupplierMallDAO getSupplierMallDAO() {
		return supplierMallDAO;
	}

	public void setSupplierMallDAO(SupplierMallDAO supplierMallDAO) {
		this.supplierMallDAO = supplierMallDAO;
	}
	
	public SupplierMall getSupplierMall() {
		return supplierMall;
	}

	public void setSupplierMall(SupplierMall supplierMall) {
		this.supplierMall = supplierMall;
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

	@RequestMapping("/AddSupplier")
	public ModelAndView AddSupplier() {

		System.out.println("Adding Supplier");
		
		ModelAndView mv = new ModelAndView("AddSupplier");
		mv.addObject("supplierMall", new SupplierMall());
		
		List<SupplierMall> supplierMallList = supplierMallDAO.getList();
		mv.addObject("supplierMallList",supplierMallList);
		mv.addObject("AddSupplier", true);
		return mv;
	}
	
	
	
	@RequestMapping("/savesupplier")
	public ModelAndView SaveSupplier(@ModelAttribute("supplierMall") SupplierMall supplierMall, @RequestParam("fileData") MultipartFile fileData,HttpServletRequest request,HttpServletResponse response,BindingResult result) throws Exception {

		ModelAndView mv = new ModelAndView("AddSupplier");
		
		uploadFolderPath = fileUtil.upload(fileData);
		supplierMall.setImagepath(uploadFolderPath);
		
		mv.addObject("supplierMall", true);
		supplierMallDAO.save(supplierMall);
		System.out.println("Save Supplier Successfull");
		List<SupplierMall> supplierMallList = supplierMallDAO.getList();
		mv.addObject("supplierMallList",supplierMallList);
		
		return new ModelAndView("redirect:AddSupplier");
	}
	
	@RequestMapping("/DeleteSup")
	public ModelAndView DeleteSupplier(@RequestParam int id) {
		@SuppressWarnings("unused")
		int supplierMallDelete= supplierMallDAO.deleteRow(id);
		return new ModelAndView("redirect:AddSupplier");
	 }
	
	
	@RequestMapping("/EditSup")
	public ModelAndView EditSupplier(@RequestParam int id,@ModelAttribute("supplierMall") SupplierMall supplierMall){
		ModelAndView mv = new ModelAndView("AddSupplier");
		List<SupplierMall> supplierMallList = supplierMallDAO.getList();
		mv.addObject("supplierMallList",supplierMallList);
		SupplierMall supplierMallEdit = supplierMallDAO.getRowById(id);
		mv.addObject("supplierMallEdit",supplierMallEdit);
		return mv;
	}
	
	@RequestMapping("/UpdateTravelAgent")
	 public ModelAndView updateSupplier(@ModelAttribute("supplierMall") SupplierMall supplierMall, BindingResult result) {
	  
		ModelAndView mv = new ModelAndView("AddSupplier");	
	 
	  List<SupplierMall> supplierMallList = (List<SupplierMall>) supplierMallDAO.getList();
	  mv.addObject("supplierMallList",supplierMallList);
	  supplierMallDAO.updateRow(supplierMall);
	  return new ModelAndView("redirect:AddSupplier");
	 }
	
}
