package com.consumerApp.model;

import lombok.Data;

@Data
public class CurrencyResponse {

	private int currencyId;
	private String currencyFrom;
	private String currencyTo;
	private Double currencyValue;
}
