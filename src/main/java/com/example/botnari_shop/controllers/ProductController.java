package com.example.botnari_shop.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.botnari_shop.entities.Product;
import com.example.botnari_shop.entities.finance.Price;
import com.example.botnari_shop.enums.Category;
import com.example.botnari_shop.enums.Currency;
import com.example.botnari_shop.services.ProductService;
@Controller
public class ProductController extends BaseController<Product>{
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value = "/produse", produces = MediaType.IMAGE_PNG_VALUE)
	public String indexProductsPage(Model model) {
   		 List<Product> products = productService.getProducts();
		 model.addAttribute("products",products);
		return "produse";
	}
	
	@GetMapping("/product/image/{id}")
	public void showProductImage(@PathVariable Integer id,
	                               HttpServletResponse response) throws IOException {
	response.setContentType("image/png"); // Or whatever format you wanna use

	Product product = productService.getProductById(id);

	InputStream is = new ByteArrayInputStream(product.getImage());
	IOUtils.copy(is, response.getOutputStream());
	}

	
	@GetMapping("/")
    public String indexHome(Model model) {
		model.addAttribute("product",new Product());
		model.addAttribute("price",new Price());
        return "home";
    }
	
	@PostMapping("/")
	public String addProduct(@ModelAttribute Product product,
			                 @ModelAttribute Price price,
			                 Model model) throws IOException {
//		String imageName = StringUtils.cleanPath(image.getOriginalFilename());
//		String imageFile = Base64.getEncoder().encodeToString(product.getImage().getBytes());
		
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
				model.addAttribute("image",image);
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
