package com.example.botnari_shop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.botnari_shop.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer>{

	public Optional<Client> findByFirstNameAndLastName(String firstName, String lastName);
	public Optional<Client> findByEmail(String email);
	public Optional<Client> findByPhone(String phone);

}
