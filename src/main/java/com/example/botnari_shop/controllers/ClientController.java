package com.example.botnari_shop.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.botnari_shop.entities.Client;
import com.example.botnari_shop.entities.Product;
import com.example.botnari_shop.entities.finance.Price;
import com.example.botnari_shop.enums.Category;
import com.example.botnari_shop.enums.ClientStatus;
import com.example.botnari_shop.enums.Currency;
import com.example.botnari_shop.services.ClientService;
import com.example.botnari_shop.services.ProductService;

@Controller
public class ClientController extends BaseController<Client>{

	@Autowired
	ClientService clientService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/clienti")
	public String indexClientsPage(Model model) {
	     List<Client> clients = clientService.getClientsList();
		 model.addAttribute("clients",clients);
		return "clienti";
	}
	
	@PostMapping("/clienti")
	public String addProductClientsPage(
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
	
	@PostMapping("/clienti/add")
	public String addClient(
								@RequestParam("firstName") String firstName,
								@RequestParam("lastName") String lastName,
								@RequestParam("email") String email,
//								@RequestParam("code") String code,
//								@RequestParam("productName") String productName,
//								@RequestParam("ammount") Double ammount,
//								@RequestParam("currency") Currency currency,
								@RequestParam("status") ClientStatus status,
								@RequestParam("phone") String phone,
								Model model 
			                ) throws IOException {
		
		try {
				Client c = new Client(firstName,lastName,email,status,phone);
				clientService.saveClient(c);
				model.addAttribute("client",c);
				return "clienti";
				
		}catch(Exception e) {
			System.err.println("Error >>> "+e);
			return "error_page";
		}
	}
	
//	@GetMapping("/client/products/{phone}")
//	public String getClientProductsByPhone(@PathVariable("phone") String phone,Model model) {
//		List<Product> products = productService.getProductsByClientPhone(phone);
//		model.addAttribute("products",products);
//		return "clienti";
//	}
}
