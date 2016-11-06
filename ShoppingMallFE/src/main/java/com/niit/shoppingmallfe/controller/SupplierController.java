package com.niit.shoppingmallfe.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingmall.dao.ProductMallDAO;
import com.niit.shoppingmall.dao.SupplierMallDAO;
import com.niit.shoppingmall.model.ProductMall;
import com.niit.shoppingmall.model.SupplierMall;

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
	
	public SupplierMallDAO getSupplierMallDAO() {
		return supplierMallDAO;
	}

	public void setSupplierMallDAO(SupplierMallDAO supplierMallDAO) {
		this.supplierMallDAO = supplierMallDAO;
	}

	private String saveDirectory = "E:/Images/";
	
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
	public ModelAndView SaveSupplier(@ModelAttribute("supplierMall") SupplierMall supplierMall, BindingResult result, HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {

		
		ModelAndView mv = new ModelAndView("AddSupplier");
		mv.addObject("supplierMall", true);
		supplierMallDAO.save(supplierMall);
		System.out.println("Save Supplier Successfull");
		List<SupplierMall> supplierMallList = supplierMallDAO.getList();
		mv.addObject("supplierMallList",supplierMallList);
		
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
		return new ModelAndView("redirect:AddSupplier");
	}
	
	@RequestMapping("/DeleteSup")
	public ModelAndView DeleteSupplier(@RequestParam int id) {
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
