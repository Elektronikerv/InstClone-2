package com.inst.controller;

import com.inst.entity.User;
import com.inst.service.UserService;
import org.apache.commons.codec.binary.Base64;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.security.Principal;
import java.sql.Blob;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(Principal principal, ModelMap model) {
		model.addAttribute("message", "Hello world!");

		User user = (User) userService.loadUserByUsername(principal.getName());

		model.put("user", user);
		return "userPage";
	}


	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration() {
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@RequestParam("email") String email,
							   @RequestParam("gender") String gender,
							   @RequestParam("password") String password,
							   @RequestParam("avatar") MultipartFile image) throws IOException {
		User user = new User();

		user.setEmail(email);
		user.setPassword(password);
		user.setGender(gender);
		user.setAvatar(image);

		userService.create(user);

		return "redirect:/";
	}
}