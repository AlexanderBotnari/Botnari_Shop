package com.example.botnari_shop.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.botnari_shop.entities.Product;
import com.example.botnari_shop.entities.finance.Price;
import com.example.botnari_shop.enums.Category;
import com.example.botnari_shop.enums.Currency;
import com.example.botnari_shop.services.ProductService;

@Controller
public class HomeController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/")
    public String indexHome(Model model) {
		model.addAttribute("product",new Product());
		model.addAttribute("price",new Price());
        return "home";
    }
	
	@PostMapping("/")
	public String addProductHomePage(
								@RequestParam("image") MultipartFile image,
								@RequestParam("productName") String productName,
								@RequestParam("category") Category category,
								@RequestParam("code") String code,
								@RequestParam("ammount") Double ammount,
								@RequestParam("currency") Currency currency,
								@RequestParam("description") String description,
								Model model 
			                ) throws IOException {
		
		try {
				Product p = new Product(image.getBytes(),productName,category,code,new Price(ammount,currency),description);
				productService.saveProduct(p);
				model.addAttribute("product",p);
				return "succes_page";
				
		}catch(Exception e) {
			System.err.println("Error >>> "+e);
			return "error_page";
		}
	}
}
