package com.example.botnari_shop.entities.finance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.botnari_shop.entities.BaseEntity;
import com.example.botnari_shop.utils.CurrencyProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Entity(name = "prices")
public class Price extends BaseEntity{
 
	private static CurrencyProvider currencyProvider = new CurrencyProvider();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double amount;
	@ManyToOne
	private Currency currency;
	
	public Price(Double amount) {
        this.amount = amount;
        this.currency = Currency.baseCurrency;
        
    }
	
	public Price(Integer id, Double amount) {
		this.id = id;
		this.amount = amount;
	}
	
	public Price(String currency, Double amount) {
        this.currency = currencyProvider.getCurrency(currency);
        this.amount = amount;
    }
   
    public Price toCurrency(String code) {
    	Currency c = currencyProvider.getCurrency(code);

        if (currency.getCode().equals("MDL"))
            return new Price(c.getCode(), amount *  c.getRate());
        else
            return new Price(c.getCode(),amount  * c.getRate());
    }

	@Override
	public String toString() {
		return "Price [" + id + ", " + amount + ", " + currency + "]";
	}

    
}
