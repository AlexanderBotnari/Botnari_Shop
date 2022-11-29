package com.example.botnari_shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.botnari_shop.entities.Client;
import com.example.botnari_shop.responses.JSONResponse;
import com.example.botnari_shop.responses.ResponseStatus;
import com.example.botnari_shop.services.ClientService;

@Controller
public class ClientController extends BaseController<Client>{

	@Autowired
	ClientService clientService;
	
	@GetMapping("/clienti")
	public String indexClientsPage() {
		return "clienti";
	}
	
//	@GetMapping("/index/name/{name}")
//	public JSONResponse indexByName(@PathVariable String name) {
//		return new JSONResponse(ResponseStatus.SUCCES, clientService.getClientByName(name));
//	}
//	
//	@GetMapping("/index/email/{email}")
//	public JSONResponse indexByEmail(@PathVariable String email) {
//		return new JSONResponse(ResponseStatus.SUCCES, clientService.getClientByEmail(email));
//	}
//	@GetMapping("/index/phone/{phone}")
//	public JSONResponse indexByPhone(@PathVariable String phone) {
//		return new JSONResponse(ResponseStatus.SUCCES, clientService.getClientByPhone(phone));
//	}
	
}
