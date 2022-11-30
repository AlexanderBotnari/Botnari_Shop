package com.example.botnari_shop.entities.finance;

import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.example.botnari_shop.entities.BaseEntity;
import com.example.botnari_shop.enums.Currency;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "prices")
public class Price{//extends BaseEntity

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double ammount;
	@CollectionTable
	private Currency currency;
	
}
