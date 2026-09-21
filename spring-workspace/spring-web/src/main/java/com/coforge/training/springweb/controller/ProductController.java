package com.coforge.training.springweb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coforge.training.springweb.dao.ProductDAO;
import com.coforge.training.springweb.model.Product;


/**
* Author :sushank2
* Date :24-Jul-2026
* Time :2:37:36 pm
* Project Name :spring-web
*/

@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO dao;
	
	@GetMapping("/products")
	public String products(Model model) {
		List<Product> list=dao.getAllProducts();
		model.addAttribute("productsList",list);
		return "products";   //returns products obj + view products
	}
	

}

