package com.example.botnari_shop.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.botnari_shop.entities.finance.Price;
import com.example.botnari_shop.enums.ItemStatus;

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
	private ItemStatus status;
	@ManyToOne()
	@JoinColumn(name = "client_id")
	private Client client;
	
	public Item( String itemCode, String itemName, Price itemPrice, ItemStatus status) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.status = status;
	}
	
	
}
