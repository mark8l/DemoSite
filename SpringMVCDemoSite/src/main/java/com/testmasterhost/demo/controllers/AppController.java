package com.testmasterhost.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.testmasterhost.demo.entities.UserEntity;
import com.testmasterhost.demo.repositories.UserRepository;


@Controller
public class AppController {
	
	@Autowired
	private UserRepository userRepo;
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("userEntity", new UserEntity());
		return "signup_form";
	}
	@PostMapping("/process_register")
	public String processRegistration(UserEntity userEntity) {

		userRepo.save(userEntity);
		return "registration_success";
	}
	@GetMapping("/list_users")
	public String viewUsersList(Model model) {
		List<UserEntity> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
}
