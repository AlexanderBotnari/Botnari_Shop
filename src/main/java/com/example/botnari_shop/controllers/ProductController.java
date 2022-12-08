package com.example.botnari_shop.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.botnari_shop.entities.Product;
import com.example.botnari_shop.entities.finance.Price;
import com.example.botnari_shop.enums.Category;
import com.example.botnari_shop.enums.Currency;
import com.example.botnari_shop.services.ProductService;
@Controller
public class ProductController extends BaseController<Product>{
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value = "/produse")
	public String indexProductsPage(Model model) {
   		 List<Product> products = productService.getProducts();
		 model.addAttribute("products",products);
		return "produse";
	}
	
	@GetMapping("/product/image/{id}")
	public void showProductImage(@PathVariable Integer id,
	                             HttpServletResponse response
	                             ) throws IOException, SQLException {
		response.setContentType("image/*");

		Product product = productService.getProductById(id);
		byte[] image  = product.getImage();
		InputStream is = new ByteArrayInputStream(image);
		IOUtils.copy(is, response.getOutputStream());
	}

	
	@GetMapping("/")
    public String indexHome(Model model) {
		model.addAttribute("product",new Product());
		model.addAttribute("price",new Price());
        return "home";
    }
	
	@PostMapping("/")
	public String addProduct(
								@RequestParam("image") MultipartFile image,
								@RequestParam("category") Category category,
								@RequestParam("code") String code,
								@RequestParam("ammount") Double ammount,
								@RequestParam("currency") Currency currency,
								@RequestParam("description") String description,
								Model model 
			                ) throws IOException {
		
		try {
				Product p = new Product(image.getBytes(),category,code,new Price(ammount,currency),description);
				productService.saveProduct(p);
				model.addAttribute("product",p);
				return "succes_page";
				
		}catch(Exception e) {
			System.err.println("Error >>> "+e);
			return "error_page";
		}
	}
}