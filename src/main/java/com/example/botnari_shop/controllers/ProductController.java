package com.example.botnari_shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.botnari_shop.entities.Product;
import com.example.botnari_shop.services.ProductService;

@Controller
public class ProductController extends BaseController<Product> {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/produse")
	public String indexProductsPage() {
		return "produse";
	}
	
	@GetMapping("/add_product")
	public String indexAddProduct(Model model) {
		model.addAttribute("product",new Product());
		return "add_product";
	}
	
	@PostMapping("/add_product")
	public String addProduct(Product product,Model model) {
		model.addAttribute("product",product);
		return "produse";
	}
	
//	@GetMapping("/index/code/{code}")
//	public JSONResponse indexByCode(@PathVariable String code) {
//		return new JSONResponse(ResponseStatus.SUCCES, productService.getProductByCode(code));
//	}
//	
//	@GetMapping("/index/description/{description}")
//	public JSONResponse indexByDescription(@PathVariable String description) {
//		return new JSONResponse(ResponseStatus.SUCCES, productService.getProductByCode(description));
//	}
}
