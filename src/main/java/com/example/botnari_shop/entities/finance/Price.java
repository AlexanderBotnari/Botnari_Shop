package com.example.botnari_shop.entities.finance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import com.example.botnari_shop.entities.BaseEntity;
import com.example.botnari_shop.enums.Currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "prices")
public class Price extends BaseEntity{

	private Double ammount;
	
	@Enumerated
	@Column(name = "currency")
	private Currency currency;
	
	
	
}
