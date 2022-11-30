package com.example.botnari_shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.botnari_shop.entities.Product;
import com.example.botnari_shop.entities.finance.Price;
import com.example.botnari_shop.enums.Category;
import com.example.botnari_shop.enums.Currency;
import com.example.botnari_shop.services.ProductService;

@Controller
public class ProductController {//extends BaseController<Product>
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/produse")
	public String indexProductsPage() {
		return "produse";
	}
	
	@GetMapping("/")
    public String indexHome(Model model) {
		model.addAttribute("product",new Product());
		model.addAttribute("price",new Price());
        return "home";
    }
	
	@PostMapping("/")
	public String addProduct(@ModelAttribute Product product,@ModelAttribute Price price,Model model) {
		System.out.println("Post work!");
		String code = product.getCode();
		String description = product.getDescription();
		byte[] image = product.getImage();
		Category category = product.getCategory();
    	Double ammount = price.getAmmount();
		Currency currency = price.getCurrency();
    	
		System.out.println(code+" "+description+" "+image+" "+category+" "+ammount+" "+currency);
		model.addAttribute("product",product);
		return "succes_add_product";
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
