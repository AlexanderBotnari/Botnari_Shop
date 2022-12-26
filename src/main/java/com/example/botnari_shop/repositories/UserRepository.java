package com.example.botnari_shop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.botnari_shop.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	public Optional<User> findByPhone(String phone);
}
