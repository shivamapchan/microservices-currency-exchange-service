package com.app.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.microservices.bean.CurrencyExchange;
import com.app.microservices.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	public CurrencyExchange findCurrencyExchange(String from, String to) {
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		return currencyExchange;
	}

}
