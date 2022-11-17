package com.example.botnari_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.botnari_shop.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}