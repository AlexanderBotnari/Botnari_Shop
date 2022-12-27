package com.example.botnari_shop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.botnari_shop.entities.User;
import com.example.botnari_shop.services.UserService;

@Controller
public class UserController extends BaseController<User> {

	@Autowired
	UserService userService;
	
	@RequestMapping("/users")
	public String indexUsers(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users",users);
		return "users";
	}
	
	@RequestMapping("/users/add")
	public String addUser(@RequestParam("userName") String userName,
						  @RequestParam("userFirstName") String userFirstName,
						  @RequestParam("userLastName") String userLastName,
						  @RequestParam("userEmail") String userEmail,
						  @RequestParam("userPhone") String userPhone,
						  @RequestParam("password") String password,
//						  @RequestParam("userRole") String userRole,
						  Model model
						) {
			User user = new User(userName,userFirstName,userLastName,userEmail,userPhone,password);
			userService.saveUser(user);
			model.addAttribute("user",user);
		return "succes_page";
	}

	@RequestMapping("/users/remove")
	public String removeUser(@RequestParam("userId") Integer userId) {
		User user = userService.getUserById(userId).get();
		userService.deleteUser(user);
		return "succes_page";
	}
	
	@RequestMapping("/users/edit")
	public String editUser(@RequestParam("userId") Integer userId,
						   @RequestParam("userFirstName") String userFirstName,
						   @RequestParam("userLastName") String userLastName,
						   @RequestParam("userEmail") String userEmail,
						   @RequestParam("userPhone") String userPhone,
//						   @RequestParam("userRole") Role userRole,
						   Model model
							) {
			User user = userService.getUserById(userId).get();
			user.setUserFirstName(userFirstName);
			user.setUserLastName(userLastName);
			user.setUserEmail(userEmail);
			user.setPhone(userPhone);
//			user.setUserRole(userRole);
			
			userService.saveUser(user);
		return "succes_page";
	}

	@RequestMapping("/users/details")
	public void viewDetails(@RequestParam("userId") Integer userId, Model model) {
		User userDetails = userService.getUserById(userId).get();
		model.addAttribute("userDetails",userDetails);
	}
}
