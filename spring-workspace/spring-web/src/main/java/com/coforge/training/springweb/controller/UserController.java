package com.coforge.training.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


/**
* Author :sushank2
* Date :24-Jul-2026
* Time :10:13:41 am
* Project Name :spring-web
*/

@Controller
public class UserController {

	//ModelMap is a container to hold data with key/values representation
	
	@GetMapping("/user")
	public String userinfo(ModelMap model) {
		model.addAttribute("user","Rod Jhonson");
		model.addAttribute("d",new java.util.Date());
		return "user";
	}
	
	@GetMapping("/spring")
	public String showSecond(ModelMap model) {
		model.addAttribute("app","spring mvc web app");
		model.addAttribute("s1","ajax");
		return "second";
	}

}
