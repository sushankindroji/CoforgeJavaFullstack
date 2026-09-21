package com.coforge.training.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.coforge.training.springweb.model.Reservation;

/**
* Author :sushank2
* Date :24-Jul-2026
* Time :12:14:14 pm
* Project Name :spring-web
*/
@Controller
public class ReservationController {
	
	@GetMapping("/reserve1")
	public String bookingsForm(Model theModel) {
		Reservation res = new Reservation();
		theModel.addAttribute("reserve1",res);
		return "reservation";
	}
	
	@PostMapping("/submitForm")
	public String submitForm(@ModelAttribute("reserve1") Reservation res)
	{
		return "confirmationform";
	}

}
