package com.example.botnari_shop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.example.botnari_shop.entities.Client;
import com.example.botnari_shop.entities.Item;
import com.example.botnari_shop.enums.ClientStatus;
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
//		Client clientFromDb = getClientById((Integer)client.getId());
		List<Item> list = client.getItems();
		System.err.println("Lista inainte");
		list.forEach(System.err::print);
		list.add(item);
		System.err.println("Lista dupa");
		list.forEach(System.err::print);
		client.setItems(list);
		System.err.println();
		System.err.println("Client "+client.getId());
		item.setClient(client);
		System.err.println(item.getItemName());
		itemRepo.save(item);
		
//		clientRepo.update(client.getFirstName(),client.getLastName(),client.getEmail(),client.getId());
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
	public Client getClientByStatus(ClientStatus status) {
		var ref = new Object() {
			Client client = null;
			};
			clientRepo.findByStatus(status).ifPresent(value -> ref.client = value);
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
}
