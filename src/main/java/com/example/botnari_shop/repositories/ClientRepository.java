package com.example.botnari_shop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.botnari_shop.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer>{

	public Optional<Client> findByFirstNameAndLastName(String firstName, String lastName);
	public Optional<Client> findByEmail(String email);
//	public Optional<Client> findByStatus(ClientStatus status);
	public Optional<Client> findByPhone(String phone);
//	
//	@Modifying
//	@Query("update clients c set c.firstName = :firstName, c.lastName = :lastName, c.email = :email where c.id = :id")
//	void update(@Param("firstName") String firstName,@Param("lastName") String lastName,
//			@Param("email") String email,@Param("id") Integer id);
}
