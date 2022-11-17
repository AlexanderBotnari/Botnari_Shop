package com.example.botnari_shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.botnari_shop.entities.Client;
import com.example.botnari_shop.enums.ClientStatus;
import com.example.botnari_shop.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepo;
	
	public List<Client> getClientsList(){
		return clientRepo.findAll();
	}
	
	public Client getClientById(Integer id) {
		var ref = new Object() {
		Client client = null;
		};
		clientRepo.findById(id).ifPresent(value -> ref.client = value);
		return ref.client;
	}
	public Client getClientByName(String name) {
		var ref = new Object() {
			Client client = null;
			};
			clientRepo.findByName(name).ifPresent(value -> ref.client = value);
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
}
