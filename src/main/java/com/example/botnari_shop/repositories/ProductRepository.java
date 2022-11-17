package com.example.botnari_shop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.botnari_shop.entities.Category;
import com.example.botnari_shop.entities.Product;
import com.example.botnari_shop.entities.finance.Price;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

	public Optional<Product> findByCode(String code);
	public Optional<Product> findByPrice(Price price);
	public Optional<Product> findByCategory(Category category);
	public Optional<Product> findByDescription(String description);
	public void deleteProductByCode(String code);
}
