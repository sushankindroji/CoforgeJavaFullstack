package com.railway.controller;

import com.railway.entity.Passenger;
import com.railway.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private PassengerService passengerService;

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "addPassenger";
	}

	@PostMapping("/save")
	public String savePassenger(@ModelAttribute("passenger") Passenger passenger, Model model) {
		try {
			// Basic validation
			if (passenger.getAge() <= 5) {
				model.addAttribute("error", "Age must be greater than 5");
				return "addPassenger";
			}
			if (passenger.getMobile() == null || passenger.getMobile().length() != 10) {
				model.addAttribute("error", "Mobile must be 10 digits");
				return "addPassenger";
			}
			if (passenger.getAadhaarNumber() == null || passenger.getAadhaarNumber().length() != 12) {
				model.addAttribute("error", "Aadhaar must be 12 digits");
				return "addPassenger";
			}
			if (passenger.getTicketFare() <= 0) {
				model.addAttribute("error", "Fare must be greater than 0");
				return "addPassenger";
			}
			if (passenger.getSourceStation().equalsIgnoreCase(passenger.getDestinationStation())) {
				model.addAttribute("error", "Source and Destination cannot be same");
				return "addPassenger";
			}

			passengerService.savePassenger(passenger);
			return "redirect:/passenger/list";

		} catch (Exception e) {
			e.printStackTrace();   // This will show the real error in Console
			model.addAttribute("error", "Error saving passenger: " + e.getMessage());
			return "addPassenger";
		}
	}

	@GetMapping("/list")
	public String listPassengers(Model model) {
		model.addAttribute("passengers", passengerService.getAllPassengers());
		return "passengerList";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") int id, Model model) {
		Passenger passenger = passengerService.getPassengerById(id);
		model.addAttribute("passenger", passenger);
		return "editPassenger";
	}

	@PostMapping("/update")
	public String updatePassenger(@ModelAttribute("passenger") Passenger passenger) {
		passengerService.updatePassenger(passenger);
		return "redirect:/passenger/list";
	}

	@GetMapping("/delete/{id}")
	public String deletePassenger(@PathVariable("id") int id) {
		passengerService.deletePassenger(id);
		return "redirect:/passenger/list";
	}

	@GetMapping("/search")
	public String showSearchForm() {
	    return "searchPassenger";
	}

	@PostMapping("/search")
	public String searchPassenger(@RequestParam(value = "passengerId", required = false) Integer id, 
	                              Model model) {

	    if (id == null) {
	        model.addAttribute("error", "Please enter a Passenger ID");
	        return "searchPassenger";
	    }

	    Passenger passenger = passengerService.getPassengerById(id);

	    if (passenger == null) {
	        model.addAttribute("error", "No passenger found with ID: " + id);
	    } else {
	        model.addAttribute("passenger", passenger);
	    }

	    return "searchPassenger";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true));
	}
}