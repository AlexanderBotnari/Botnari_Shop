package com.example.botnari_shop.entities.finance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.botnari_shop.entities.BaseEntity;

import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
public class Currency extends BaseEntity{
	
	public static Currency baseCurrency = new Currency (
	        "MDL",
	         0.05         
	    );
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String code;       
    private Double rate;
    
	public Currency(String code, Double rate) {
		this.code = code;
		this.rate = rate;
		
	}
	
	public static Currency getBaseCurrency() {
		return baseCurrency;
	}

	public static void setBaseCurrency(Currency baseCurrency) {
		Currency.baseCurrency = baseCurrency;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Currency [" + id + ", " + code + ", " + rate + "]";
	}

}
