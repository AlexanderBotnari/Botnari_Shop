package com.example.botnari_shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.botnari_shop.entities.Client;
import com.example.botnari_shop.entities.Item;
import com.example.botnari_shop.repositories.ClientRepository;
import com.example.botnari_shop.repositories.ItemRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepo;
	
	@Autowired
	ItemRepository itemRepo;
	
	public List<Client> getClientsList(){
		List<Client> clients = clientRepo.findAll();
		return clients;
	}
	
	@Transactional
	public void setItemForClient(Item item, Client client) {
		List<Item> list = client.getItems();
		list.add(item);
		client.setItems(list);
		item.setClient(client);
		itemRepo.save(item);
	}
	
	public Client getClientById(Integer id) {
		var ref = new Object() {
		Client client = null;
		};
		clientRepo.findById(id).ifPresent(value -> ref.client = value);
		return ref.client;
	}
	public Client getClientByFirstNameAndLastName(String firstName, String lastName) {
		var ref = new Object() {
			Client client = null;
			};
			clientRepo.findByFirstNameAndLastName(firstName,lastName).ifPresent(value -> ref.client = value);
			return ref.client;
	}
	public Client getClientByEmail(String email) {
		var ref = new Object() {
			Client client = null;
			};
			clientRepo.findByEmail(email).ifPresent(value -> ref.client = value);
			return ref.client;
	}

	public Client getClientByPhone(String phone) {
		var ref = new Object() {
			Client client = null;
			};
			clientRepo.findByPhone(phone).ifPresent(value -> ref.client = value);
			return ref.client;
	}
	
	public void saveClient(Client client) {
		clientRepo.save(client);
	}

	@Transactional
	public void deleteClient(Client client) {
		clientRepo.delete(client);
	}
	
}
