package com.example.botnari_shop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.botnari_shop.services.RoleService;

@Controller
public class AuthController {

	@Autowired
	RoleService roleService;
	
	@GetMapping("/login")
    public String login() {
		List<String> roleNames = roleService.findRoleNames("ADMIN");
		if(roleNames.size() > 0 ) {
			return "index";			
		}else {
			return "initialize_admin";
		}
    }
	
	@GetMapping("/logout")
    public String getLogout() {
        return "logout";
    }

}
