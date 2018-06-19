package com.inst.controller;

import com.inst.entity.Image;
import com.inst.entity.User;
import com.inst.service.ImageService;
import com.inst.service.UserService;
import org.apache.commons.codec.binary.Base64;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.security.Principal;
import java.sql.Blob;
import java.util.List;

@Controller
public class UserController {

	private UserService userService;

	private ImageService imageService;

	@Autowired
	public UserController(UserService userService, ImageService imageService) {
		this.userService = userService;
		this.imageService = imageService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String page(@AuthenticationPrincipal User user, Model model) {
//		User user = (User) userService.loadUserByUsername(principal.getName());
		model.addAttribute("user", user);
		return "userPage";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration() {
		return "registration";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@RequestParam("login") String login,
							   @RequestParam("gender") String gender,
							   @RequestParam("firstName") String firstName,
							   @RequestParam("lastName") String lastName,
							   @RequestParam("password") String password,
							   @RequestParam("avatar") MultipartFile image) throws IOException {
		User user = new User();
		user.setLogin(login);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setGender(gender);
		user.setAvatar(image);

		userService.create(user);

		return "redirect:/";
	}

	@RequestMapping("/addImage")
	public String addImage(@RequestParam("newImage") MultipartFile file, Principal principal) throws IOException {
		User user = (User) userService.loadUserByUsername(principal.getName());

		Image image = new Image();
		image.setContent(file);

		image.setUser(user);
		
		imageService.create(image);

		return "redirect:/";
	}

	@RequestMapping("/search")
	public String getUsersList(@RequestParam("searchUserLogin") String login, Model model) {
		List<User> users = userService.searchUsersByLogin(login);

		model.addAttribute("users", users);
		return "usersList";
	}
}