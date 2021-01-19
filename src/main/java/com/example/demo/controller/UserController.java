package com.example.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Users;
import com.example.demo.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService us;
	
	@RequestMapping("/")
	public String addOrUpdate(ModelMap model) {
		Users u = new Users();
		model.addAttribute("USER", u);
		model.addAttribute("ACTION","saveOrUpdate" );
		return "register-user";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrupdate(ModelMap model, @ModelAttribute("USER") Users user) {
		us.save(user);	
		return "register-user";
	}
	
	
	
	@RequestMapping("/list")
	public String showList(ModelMap model) {
		us.findAll();
		model.addAttribute("USERS", us.findAll());
		return "view-user";
	}
	
	@RequestMapping("/edit/{username}")
	public String edit(ModelMap model, @PathVariable(name="username") String username) {
		Optional<Users> u = us.findById(username);
		if (u.isPresent()) {
			model.addAttribute("USER", u.get());
		}else {
			model.addAttribute("USER",  new Users());
		}
		model.addAttribute("ACTION","/saveOrUpdate" );
		return "register-user";
		
	}
	
	@RequestMapping("/delete/{username}")
	public String delete(ModelMap model,@PathVariable(name="username") String username) {
		us.deleteById(username);
		model.addAttribute("USERS", us.findAll());
		return "view-user";
				}
}
