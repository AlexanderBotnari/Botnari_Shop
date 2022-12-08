package com.example.botnari_shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.botnari_shop.entities.Product;
import com.example.botnari_shop.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	public List<Product> getProducts(){
		return productRepo.findAll();
	}
	
	public Product getProductById(Integer id) {
		var ref = new Object() {
			Product product = null;
		};
		productRepo.findById(id).ifPresent(value -> ref.product = value);
		return ref.product;
	}
	
	public Product getProductByCode(String code) {
		var ref = new Object() {
			Product product = null;
		};
		productRepo.findByCode(code).ifPresent(value -> ref.product = value);
		return ref.product;
	}
	
//	public Product getProductByPrice(Price price) {
//		var ref = new Object() {
//			Product product = null;
//		};
//		productRepo.findByPrice(price).ifPresent(value -> ref.product = value);
//		return ref.product;
//	}
//	
//	public Product getProductByCategory(Category category) {
//		var ref = new Object() {
//			Product product = null;
//		};
//		productRepo.findByCategory(category).ifPresent(value -> ref.product = value);
//		return ref.product;
//	}
	
	public Product getProductByDescription(String description) {
		var ref = new Object() {
			Product product = null;
		};
		productRepo.findByDescription(description).ifPresent(value -> ref.product = value);
		return ref.product;
	}
	
	public void deleteProductByCode(String code) {
		productRepo.deleteProductByCode(code);
	}
	
	public void saveProduct(Product product) {
		productRepo.save(product);
	}
	
	public void updateProduct(Integer id, Product product) {
		product.setId(id);
		productRepo.save(product);
	}
	
}
