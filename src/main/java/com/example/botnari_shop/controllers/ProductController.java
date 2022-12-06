package com.example.botnari_shop.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.botnari_shop.entities.Product;
import com.example.botnari_shop.entities.finance.Price;
import com.example.botnari_shop.enums.Category;
import com.example.botnari_shop.enums.Currency;
import com.example.botnari_shop.services.ProductService;
import com.example.botnari_shop.utils.ImageUtil;

@Controller
public class ProductController extends BaseController<Product>{
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/produse")
	public String indexProductsPage(Model model) {
		Map<Integer, String> productBase64Images = new HashMap<>();
		List<Product> products = productService.getProducts();
		
		for(Product product: products){               
            productBase64Images.put(product.getId(), Base64.getEncoder().encodeToString(product.getImage()));
        }
		 model.addAttribute("images", productBase64Images);
		 model.addAttribute("products",products);
		return "produse";
	}
	
	@GetMapping(value = "/produse/image/{id}", produces = MediaType.IMAGE_PNG_VALUE)
	public void showProductImage(@PathVariable Integer id,
	                               HttpServletResponse response) throws IOException {
	response.setContentType("image/png"); // Or whatever format you wanna use
    
	Product product = productService.getProductById(id);
	Base64.getEncoder().encodeToString(product.getImage());
	}

	
	@GetMapping("/")
    public String indexHome(Model model) {
		model.addAttribute("product",new Product());
		model.addAttribute("price",new Price());
        return "home";
    }
	
	@PostMapping("/")
	public String addProduct(@ModelAttribute Product product,@ModelAttribute Price price,Model model) {
		byte[] image = product.getImage();
		Category category = product.getCategory();
		String code = product.getCode();
    	Double ammount = price.getAmmount();
		Currency currency = price.getCurrency();
		String description = product.getDescription();
		
		try {
			
//				Product p = new Product(image,category,code,description);
				Product p = new Product(image,category,code,new Price(ammount,currency),description);
				productService.saveProduct(p);
				model.addAttribute("product",product);
				return "succes_page";
				
		}catch(Exception e) {
			System.err.println("Error >>> "+e);
			return "error_page";
		}
	}
	
//	@GetMapping("/index/description/{description}")
//	public JSONResponse indexByDescription(@PathVariable String description) {
//		return new JSONResponse(ResponseStatus.SUCCES, productService.getProductByCode(description));
//	}
}
