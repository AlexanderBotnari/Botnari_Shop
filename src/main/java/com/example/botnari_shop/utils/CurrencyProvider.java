package com.example.botnari_shop.utils;

import java.util.HashMap;
import java.util.Map;

import com.example.botnari_shop.entities.finance.Currency;

public class CurrencyProvider {

	@SuppressWarnings("serial")
	private Map<String, Currency> currencies = new HashMap<>() {{
        put("MDL", Currency.baseCurrency);
        put("USD", new Currency("USD", 19.00));
        put("EUR", new Currency("EUR", 19.20));
	}};

    public Currency getCurrency(String code) {
        return currencies.get(code);
    }

    private static class SingletonHolder {
        private static final CurrencyProvider INSTANCE = new CurrencyProvider();
    }

    public static CurrencyProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
