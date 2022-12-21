package com.example.botnari_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.botnari_shop.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
