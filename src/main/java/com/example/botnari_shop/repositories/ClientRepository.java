package com.example.botnari_shop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.botnari_shop.entities.Client;
import com.example.botnari_shop.enums.ClientStatus;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer>{

	public Optional<Client> findByName(String name);
	public Optional<Client> findByEmail(String email);
	public Optional<Client> findByStatus(ClientStatus status);
	public Optional<Client> findByPhone(String phone);
}
