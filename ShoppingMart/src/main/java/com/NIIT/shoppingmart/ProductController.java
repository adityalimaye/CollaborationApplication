/*package com.NIIT.shoppingmart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.NIIT.shoppingpheonix.dao.ProductDAO;
import com.NIIT.shoppingpheonix.model.Product;

@Controller
public class ProductController {
	
	@Autowired(required=true)
	ProductDAO productDAO;
	
	@RequestMapping("/saveproduct")
	public ModelAndView SaveProduct(@ModelAttribute("product") Product product, BindingResult result) {

		
		System.out.println("Save Product Successfull");
		ModelAndView mv = new ModelAndView("AddProduct");
		mv.addObject("product", true);
		productDAO.save(product);
		return new ModelAndView("MensAvenue");
		
	}

}
*/