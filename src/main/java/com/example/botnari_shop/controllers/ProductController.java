package com.example.botnari_shop.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/product/download")
	public void downloadImage(@Param(value="id") Integer id, HttpServletResponse response) throws IOException {
	    Product product = productService.getProductById(id);
	    response.setContentType("image/png, image/jpeg, image/webp");
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename=" + product.getProductName() + ".png";
	    
	    response.setHeader(headerKey, headerValue);
	    ServletOutputStream out = response.getOutputStream();
	    
	    out.write(product.getImage());
	    out.close();
	}
	
	@PostMapping("/produse")
	public String addProductPage(
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
	
	@RequestMapping("/produse/edit-product")
	public String editProduct(@RequestParam("id") Integer id,
							  @RequestParam("image") MultipartFile image,
							  @RequestParam("productName") String productName,
							  @RequestParam("category") Category category,
							  @RequestParam("code") String code,
							  @RequestParam("ammount") Double ammount,
							  @RequestParam("currency") Currency currency,
							  @RequestParam("description") String description
							) throws IOException{
		Product product = productService.getProductById(id);
		product.setImage(image.getBytes());product.setProductName(productName);
		product.setCategory(category);product.setCode(code);
		product.setPrice(new Price(ammount,currency));
		product.setDescription(description);
		productService.saveProduct(product);
		
		return "succes_page";
	}
	@RequestMapping("/produse/edit-product-image")
	public String editProductImage(@RequestParam("id") Integer id,
							  	   @RequestParam("image") MultipartFile image
							  		) throws IOException{
		Product product = productService.getProductById(id);
		product.setImage(image.getBytes());
		productService.saveProduct(product);
		
		return "succes_page";
	}

	@RequestMapping("/produse/delete-product")
	public String removeProduct(@RequestParam("id") Integer id) {
		Product product = productService.getProductById(id);
		productService.deleteProduct(product);
		
		return "succes_page";
	}
}