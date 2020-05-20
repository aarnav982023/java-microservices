package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyExchangeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyExchange currencyExchange(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		HashMap<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyExchange> responseEntity = new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyExchange.class,uriVariables);
		CurrencyExchange response = responseEntity.getBody();
		return new CurrencyExchange(response.getId(), from, to, response.getPort(),response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()));
	}
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyExchange currencyExchangeFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		CurrencyExchange response = proxy.retrieveExchangeValue(from, to);
		logger.info("{}",response);
		return new CurrencyExchange(response.getId(), from, to, response.getPort(),response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()));
	}
}
