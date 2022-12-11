package com.example.botnari_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.botnari_shop.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	@Modifying
	@Query("update items i set i.itemCode = :itemCode, i.itemName = :itemName where i.id = :id")
	void update(@Param("itemCode") String itemCode,@Param("itemName") String itemName, @Param("id") Integer id);
}
