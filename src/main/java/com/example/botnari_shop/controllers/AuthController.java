package com.example.botnari_shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthController {

	@GetMapping("/login")
    public String login() {
        return "index";
    }
	
	@GetMapping("/")
    public String getHome() {
        return "home";
    }
	
	@GetMapping("/logout")
    public String getLogout() {
        return "logout";
    }

}
