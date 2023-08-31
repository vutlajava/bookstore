package com.bookstore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bookstore.model.orderbook.Ask;
import com.bookstore.model.orderbook.Bid;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderBook {
	
	@JsonProperty("Asks") 
    public ArrayList<Ask> asks;
    @JsonProperty("Bids") 
    public ArrayList<Bid> bids;
    @JsonProperty("LastChange") 
    public Date lastChange;
    @JsonProperty("SequenceNumber") 
    public int sequenceNumber;
	
	
	
	
	

}
