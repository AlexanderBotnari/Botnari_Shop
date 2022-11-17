package com.example.botnari_shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.botnari_shop.entities.Product;
import com.example.botnari_shop.responses.JSONResponse;
import com.example.botnari_shop.responses.ResponseStatus;
import com.example.botnari_shop.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController<Product> {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/index/code/{code}")
	public JSONResponse indexByCode(@PathVariable String code) {
		return new JSONResponse(ResponseStatus.SUCCES, productService.getProductByCode(code));
	}
	
	@GetMapping("/index/description/{description}")
	public JSONResponse indexByDescription(@PathVariable String description) {
		return new JSONResponse(ResponseStatus.SUCCES, productService.getProductByCode(description));
	}
}
