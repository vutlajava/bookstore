package com.bookstore.model.orderbook;

import java.math.BigDecimal;

public class Ask {
	
	private String side;
	private BigDecimal quantity;
	private BigDecimal price;
	private String currencyPair;
	private Integer orderCount;
	
	public Ask() {
		
	}
	
	public Ask(String side, BigDecimal quantity, BigDecimal price, String currencyPair, Integer orderCount) {
		super();
		this.side = side;
		this.quantity = quantity;
		this.price = price;
		this.currencyPair = currencyPair;
		this.orderCount = orderCount;
	}



	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public Integer getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	
	

}
