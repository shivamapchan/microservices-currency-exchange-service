package com.app.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservices.bean.CurrencyExchange;
import com.app.microservices.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeService currencyExService;
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange= currencyExService.findCurrencyExchange(from, to);
		if(currencyExchange==null) {
			throw new RuntimeException("Unable to find data for "+from + " and to "+to);
		}
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}

}
