package com.example.botnari_shop.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.botnari_shop.entities.Client;
import com.example.botnari_shop.entities.Item;
import com.example.botnari_shop.entities.Product;
import com.example.botnari_shop.entities.finance.Price;
import com.example.botnari_shop.enums.Category;
import com.example.botnari_shop.enums.Currency;
import com.example.botnari_shop.enums.ItemStatus;
import com.example.botnari_shop.services.ClientService;
import com.example.botnari_shop.services.ItemService;
import com.example.botnari_shop.services.ProductService;

@Controller
public class ClientController extends BaseController<Client>{

	@Autowired
	ClientService clientService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/clienti")
	public String indexClientsPage(Model model) {
	     List<Client> clients = clientService.getClientsList();
	     for (Client client : clients) {
			for (Item item : client.getItems()) {
				if(item.getStatus() == ItemStatus.ACHITAT) {
					model.addAttribute("response", "achitat");
				}else {
					model.addAttribute("response", "neachitat");
				}
			}
		}
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
	public String addClient(@ModelAttribute Client client,
							Model model 
			                ) throws IOException {
		try {
				clientService.saveClient(client);
				model.addAttribute("client",client);
				return "succes_page";
				
		}catch(Exception e) {
			System.err.println("Error >>> "+e);
			return "error_page";
		}
	}
	
	@PostMapping("/clienti/add-item")
	public String addItemToClient(@RequestParam("clientId") Integer id,
								  @RequestParam("firstName") String firstName,
								  @RequestParam("lastName") String lastName,
								  @RequestParam("email") String email,
								  @RequestParam("phone") String phone,
								  @RequestParam("itemCode") String itemCode,
								  @RequestParam("itemName") String itemName,
								  @RequestParam("itemAmmount") Double itemAmmount,
								  @RequestParam("itemCurrency") Currency itemCurrency,
								  @RequestParam("status") ItemStatus status,
								  Model model 
			                ) throws IOException {
		try {
			Client c = new Client(firstName,lastName,email,phone);
			c.setId(id);
			    Item item = new Item(itemCode,itemName,new Price(itemAmmount,itemCurrency),status);
				clientService.setItemForClient(item,c);
				model.addAttribute("item",item);
				return "succes_page";
				
		}catch(Exception e) {
			System.err.println("Error >>> "+e);
			return "error_page";
		}
	}
	
}
