package com.example.botnari_shop.entities;


import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.botnari_shop.entities.finance.Price;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "items")
public class Item extends BaseEntity{

	private String itemCode;
	private String itemName;
	@OneToOne(cascade = CascadeType.ALL)
	private Price itemPrice;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client client;
	
	public Item( String itemCode, String itemName, Price itemPrice) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	
}
