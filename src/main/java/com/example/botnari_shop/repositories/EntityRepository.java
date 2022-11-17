package com.example.botnari_shop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.botnari_shop.entities.BaseEntity;

@Repository
public interface EntityRepository<T extends BaseEntity> extends JpaRepository<T, Integer>{

	public List<T> findAllByType(String type);
	
}
