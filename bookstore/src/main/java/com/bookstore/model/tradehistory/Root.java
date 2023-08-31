package com.bookstore.model.tradehistory;

import java.util.Date;

public class Root{
    public String price;
    public String quantity;
    public String currencyPair;
    public Date tradedAt;
    public String takerSide;
    public Object sequenceId;
    public String id;
    public String quoteVolume;
    
    public Root() {
    	
    }
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	public Date getTradedAt() {
		return tradedAt;
	}
	public void setTradedAt(Date tradedAt) {
		this.tradedAt = tradedAt;
	}
	public String getTakerSide() {
		return takerSide;
	}
	public void setTakerSide(String takerSide) {
		this.takerSide = takerSide;
	}
	public Object getSequenceId() {
		return sequenceId;
	}
	public void setSequenceId(Object sequenceId) {
		this.sequenceId = sequenceId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuoteVolume() {
		return quoteVolume;
	}
	public void setQuoteVolume(String quoteVolume) {
		this.quoteVolume = quoteVolume;
	}
    
    
    
}