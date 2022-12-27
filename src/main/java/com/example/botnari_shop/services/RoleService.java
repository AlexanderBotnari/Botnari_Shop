package com.example.botnari_shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.botnari_shop.entities.Role;
import com.example.botnari_shop.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepo;
	
	public List<Role> getRoles(){
		return roleRepo.findAll();
	}
	
	public void saveRole(Role role) {
		roleRepo.save(role);
	}
	
	public void deleteRole(Role role) {
		roleRepo.delete(role);
	}
}
