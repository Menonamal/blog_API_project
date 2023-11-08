package com.flight_reservation_app.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.entity.User;
import com.flight_reservation_app.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping("/showRegPage")
	public String showRegPage() {
		return "login/showReg";
	}
	
	@RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";
	}
	
	
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("reg")User reg) {
		
		userRepository.save(reg);
		
		return "login/login";
		
	}
	
		@RequestMapping("/verifyLogin")
		public String verifyLogin (@RequestParam ("emailID")String emailID,@RequestParam ("password")String password, ModelMap modelMap) {
		User user = userRepository.findByEmail(emailID);
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		if(user!= null) {
			if(user.getEmail().equals(emailID) && user.getPassword().equals(password)) {
			return "login/findFlights";	
			}
			else {
				modelMap.addAttribute("error", "INVALID USERNAME/PASSWORD");
				return "login/login";
			}
		
		}
		
		else {
			modelMap.addAttribute("error","INVALID USERNAME/PASSWORD");
			return "login/login";
		}
		
		}
}
