package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyExchange {
	private Long id;
	private String from;
	private String to;
	private int port;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculated;
	
	protected CurrencyExchange() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculated() {
		return totalCalculated;
	}

	public void setTotalCalculated(BigDecimal totalCalculated) {
		this.totalCalculated = totalCalculated;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public CurrencyExchange(Long id, String from, String to, int port, BigDecimal conversionMultiple,
			BigDecimal quantity, BigDecimal totalCalculated) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.port = port;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculated = totalCalculated;
	}

	
	
	
}
