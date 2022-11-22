package com.example.botnari_shop.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuthController {

	@GetMapping("/login")
    public String login() {
        return "login";
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView getLogout(@RequestParam Optional<String> error) {
        return new ModelAndView("logout", "error", error);
    }

}
