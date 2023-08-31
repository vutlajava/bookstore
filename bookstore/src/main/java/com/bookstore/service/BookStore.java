package com.bookstore.service;

import java.util.List;

public interface BookStore {
	
	public com.bookstore.model.orderbook.Root getOrderBook();
	public List<com.bookstore.model.tradehistory.Root> getTradeHistory();
	public String getOrderbookResponse();
	
	

}
