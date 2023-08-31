package com.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookstore.service.BookStore;

@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookStore bookStore;
	

	@Test
	void contextLoads() {
	}
	
	@Test
	void checkSellRecords() {
		
		assertEquals(41,bookStore.getOrderBook().getAsks().size() );
		
	}
	
	@Test
	void checkBidRecords() {
		
		assertEquals(41,bookStore.getOrderBook().getBids().size() );
	}
	
	
	@Test
	void transactionHistory() {
		
		assertEquals(100,bookStore.getTradeHistory().size());
	}
	

}
