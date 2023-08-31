package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.bookstore.model.orderbook.Root;
import com.bookstore.util.APISec;
import com.bookstore.util.TimeStampUtil;

import reactor.core.publisher.Mono;

@Service
public class BookStoreService implements BookStore{
	
	
	private String orderBook_URI ="https://api.valr.com/BTCZAR/orderbook";
	
	private String transHistory_URI ="https://api.valr.com/BTCZAR/tradehistory";
	
	
	@Autowired
	private WebClient.Builder webClient;
	
	
	@Override
	public com.bookstore.model.orderbook.Root getOrderBook() {
		// TODO Auto-generated method stub
		
		com.bookstore.model.orderbook.Root orderBook =  webClient.build().get().uri(orderBook_URI)
			      .retrieve().bodyToMono(com.bookstore.model.orderbook.Root.class).block();
		
		return orderBook;
	}


	@Override
	public List< com.bookstore.model.tradehistory.Root> getTradeHistory() {
		// TODO Auto-generated method stub
		Mono<List<com.bookstore.model.tradehistory.Root>> response = webClient.build().get()
				.uri(transHistory_URI).retrieve().bodyToMono(new ParameterizedTypeReference<List<com.bookstore.model.tradehistory.Root>>() {});
				List<com.bookstore.model.tradehistory.Root> tradersList = response.block();
		return tradersList;
	}


	@Override
	public String getOrderbookResponse() {
		// TODO Auto-generated method stub
		
		MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();

	    bodyValues.add("X-VALR-API-KEY", "4961b74efac86b25cce8fbe4c9811c4c7a787b7a5996660afcc2e287ad864300");
		bodyValues.add("X-VALR-SIGNATURE", APISec.getSecurityKey());
		bodyValues.add("X-VALR-TIMESTAMP", ""+TimeStampUtil.getTimeStamp());
		
		//System.out.println(APISec.getSecurityKey());
		//System.out.println(TimeStampUtil.getTimeStamp());
		

		String response = webClient.build().post().uri("https://api.valr.com/")
							.contentType(MediaType.APPLICATION_FORM_URLENCODED)
							.accept(MediaType.APPLICATION_JSON)
							.body(BodyInserters.fromFormData(bodyValues))
							.retrieve()
							.bodyToMono(String.class)
							.block();
				return response;
	}

}
