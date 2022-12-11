package com.example.botnari_shop.services;

import java.util.List;

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
	
//	public List<Item> getItemsByClientId(Integer id){
//		var ref = new Object() {
//			List<Item> item = null;
//			};
//			itemRepo.findById(id).ifPresent(value -> ref.item = value);
//			return ref.item;
//	}
	
	public void saveItem(Item item) {
		itemRepo.save(item);
	}
}
