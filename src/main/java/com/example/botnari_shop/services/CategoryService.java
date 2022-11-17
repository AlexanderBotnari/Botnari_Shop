package com.example.botnari_shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.botnari_shop.entities.Category;
import com.example.botnari_shop.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Category> getCategories(){
		return categoryRepo.findAll();
	}
}
