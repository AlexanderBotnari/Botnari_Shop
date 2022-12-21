package com.example.botnari_shop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.botnari_shop.entities.Item;
import com.example.botnari_shop.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepo;
	
	public List<Item> getItems(){
		return itemRepo.findAll();
	}
	
	public Optional<Item> findById(Integer id) {
		return itemRepo.findById(id);
	}

	public void saveItem(Item item) {
		itemRepo.save(item);
	}
	
	public void deleteItem(Item item) {
		itemRepo.delete(item);
	}
}
