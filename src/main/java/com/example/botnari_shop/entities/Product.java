package com.example.botnari_shop.entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import com.example.botnari_shop.entities.finance.Price;
import com.example.botnari_shop.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "products")
public class Product extends BaseEntity{
	
	@Lob
	private byte[] image;
	@Enumerated
	@Column(name = "category")
	private Category category;
	private String code;
	@OneToOne(cascade = {CascadeType.ALL})
	private Price price;
	private String description;
	
	@Override
	public String toString() {
		return "Produsul " + code;
	}

}
