package com.consumerApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import com.consumerApp.model.CurrencyResponse;

@Controller
@ResponseBody

public class CurrencyController {

	@Autowired
	private WebClient webClient;
	
	
	
	@GetMapping("/getCurrencyExchangeValue/{from}/{to}")
	public String getCurrenyExchangeValue(@PathVariable String from,@PathVariable String to) {
		CurrencyResponse  c= webClient.get().uri("/getCurrencyConverterExchange/{from}/{id}",from,to)
		.retrieve().bodyToMono(CurrencyResponse.class).block();
		return c.toString();
	}
	
	@GetMapping("/getCurrencyExchangeValueUsingRequestParam")
	public String getCurrenyExchangeValueUsingRequestParam(@RequestParam String from, @RequestParam String to) {
	    CurrencyResponse c = webClient.get()
	        .uri("/getCurrencyConverterExchangeUsingRequestParam?from={from}&to={to}", from, to)  // Corrected URI
	        .retrieve()
	        .bodyToMono(CurrencyResponse.class)
	        .block();
	    return c.toString();
	}
}
