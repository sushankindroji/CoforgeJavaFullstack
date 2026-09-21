package com.coforge.training.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.coforge.training.springweb.model.User;

/**
 * Author :sushank2
 * Date :24-Jul-2026
 * Time :11:37:11 am
 * Project Name :spring-web
 */

@Controller
public class RegistrationController {

    // Load Registration Form
    // Model is a container to pass object from controller to view
    @GetMapping("/register1")
    public String showRegisterForm(Model theModel) {
        theModel.addAttribute("user", new User());
        return "register"; // //return view-model register.jsp
    }

    // Submit registration form
    @PostMapping("/saveUser")
    public String submitForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user); // // Pass user to success page
        return "success"; // // returns user object+success.jsp
    }
}