package com.example.botnari_shop.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.botnari_shop.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

	public Optional<List<String>> findByRoleName(String roleName);
}
