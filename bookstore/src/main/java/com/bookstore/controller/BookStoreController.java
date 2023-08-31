package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.bookstore.model.OrderBook;
import com.bookstore.model.orderbook.Bid;
import com.bookstore.model.tradehistory.Root;
import com.bookstore.service.BookStore;
import com.bookstore.util.APISec;
import com.bookstore.util.TimeStampUtil;

import reactor.core.publisher.Mono;


@RestController
public class BookStoreController {
	
	
	@Autowired
	private WebClient.Builder webClient;
	
	@Autowired
	private BookStore bookStore;
	
	//1. Get order book: Use this API as a reference for request and response payload
	//https://api.valr.com/BTCZAR/orderbook
	//test URL on POSTMAN
	//http://localhost:8080/orderbook
	@GetMapping("/orderbook") 
	public  ResponseEntity<com.bookstore.model.orderbook.Root> getOrderBook() {
		
		com.bookstore.model.orderbook.Root orderBook = bookStore.getOrderBook();
		System.out.println(orderBook.getAsks().size());
		System.out.println(orderBook.getBids().size());
		
		return new ResponseEntity<com.bookstore.model.orderbook.Root> (orderBook,HttpStatus.OK);
	}
	
	
	
	//2. Submitlimit order: Use this API as a reference for request and response payload
	//https://api.valr.com/v1/orders/limit. This can be a very simple data structure and does not
	//need to cater for all the advanced usages. Feel free to ask if you have any questions here.
	//(see https://docs.valr.com for the API reference if needed)
	
	/*
	 * @PostMapping("/orderSubmit")
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) //using Mono for single employee public
	 * Mono<Root> create(@RequestBody Root e) {
	 * 
	 * 
	 * //return employeeService.create(e); }
	 */
	
	 @PostMapping("/orderSubmit")
	 @ResponseStatus(HttpStatus.CREATED) 
	 public ResponseEntity<String> postOrderBook() {
		
		String response  = bookStore.getOrderbookResponse();
			
			return new ResponseEntity<String>(response,HttpStatus.OK);
		 
	 }
	 
	
	
	//3. Recent Trades : Similar to https://api.valr.com/BTCZAR/tradehistory
	
	@GetMapping("/tradehistory")
	public ResponseEntity<List<Root>> getTradeHistory() {
		
		
		
		List<Root> traderList = bookStore.getTradeHistory();
		
				System.out.println(traderList.size());
		return new ResponseEntity<List<Root>> (traderList,HttpStatus.OK);
		
		
	}
	

}
