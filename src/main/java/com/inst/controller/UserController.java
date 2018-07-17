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
		user = userService.findById(user.getId());
		model.addAttribute("currentUser", user);
		model.addAttribute("user", user);
		return "userPage";
	}

	@RequestMapping("/search")
	public String getUsersList(@AuthenticationPrincipal User user,
							   @RequestParam("searchUserLogin") String login, Model model) {
		List<User> users = userService.searchUsersByLogin(login);
		model.addAttribute("users", users);
		model.addAttribute("currentUser", user);
		return "usersList";
	}

	@RequestMapping("/user/{id}")
	public String getUser(@PathVariable("id") int id,
						  @AuthenticationPrincipal User currentUser,
						  Model model) {

		User user = userService.findById(id);

		if(userService.contains(currentUser.getFollowing(), user))
			model.addAttribute("type", "unfollow");
		else
			model.addAttribute("type", "follow");

		model.addAttribute("currentUser", currentUser);
		model.addAttribute("user", user);
		return "userPage";
	}

	@RequestMapping("/user/{type}/{id}")
	public String follow(@PathVariable("id") int id,
						 @PathVariable("type") String type,
						 @AuthenticationPrincipal User currentUser,
						 Model model) {
		User user = userService.findById(id);

		if (type.equals("follow")) {
			userService.subscribe(currentUser, user);
			model.addAttribute("type", "unfollow");
		}
		else if(type.equals("unfollow")) {
			userService.unsubscribe(currentUser, user);
			model.addAttribute("type", "follow");
		}

		currentUser = userService.findById(currentUser.getId());
		user = userService.findById(user.getId());

		model.addAttribute("currentUser", currentUser);
		model.addAttribute("user", user);

		return "userPage";
	}

	@RequestMapping("/user/list/{id}/{type}")
	public String getList(@AuthenticationPrincipal User currentUser,
						  @PathVariable("id") int id,
						  @PathVariable("type") String type,
						  Model model) {
		User user =  userService.findById(id);

		if (type.equals("followers"))
			model.addAttribute("users", user.getFollowers());
		else if(type.equals("following"))
			model.addAttribute("users", user.getFollowing());

		model.addAttribute("currentUser", currentUser);
		return "usersList";
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.GET)
	public String getUpdatePage(@AuthenticationPrincipal User user, Model model) {
		model.addAttribute("currentUser", user);
		return "userEditPage";
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public String updateUser(@AuthenticationPrincipal User user,
							 @RequestParam("login") String login,
							 @RequestParam("firstName") String firstName,
							 @RequestParam("lastName") String lastName,
							 @RequestParam("avatar") MultipartFile image) throws IOException {
		user.setLogin(login);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		if (!image.isEmpty())
			user.setAvatar(image);

		userService.update(user);
		return "redirect:/";
	}

	@RequestMapping("/user/changePassword")
	public String getChangePasswordPage(@AuthenticationPrincipal User user, Model model) {
		model.addAttribute("currentUser", user);
		return "changePassword";
	}

	@RequestMapping(value = "/user/changePassword", method = RequestMethod.POST)
	public String changePassword(@AuthenticationPrincipal User user,
								 @RequestParam("newPassword") String password) {
		user.setPassword(password);
		userService.updatePassword(user);
		return "redirect:/";
	}
}