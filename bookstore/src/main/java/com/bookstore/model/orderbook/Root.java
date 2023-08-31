package com.bookstore.model.orderbook;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root{
    @JsonProperty("Asks") 
    public ArrayList<Ask> asks;
    @JsonProperty("Bids") 
    public ArrayList<Bid> bids;
    @JsonProperty("LastChange") 
    public Date lastChange;
    @JsonProperty("SequenceNumber") 
    public int sequenceNumber;
	public ArrayList<Ask> getAsks() {
		return asks;
	}
	public void setAsks(ArrayList<Ask> asks) {
		this.asks = asks;
	}
	public ArrayList<Bid> getBids() {
		return bids;
	}
	public void setBids(ArrayList<Bid> bids) {
		this.bids = bids;
	}
	public Date getLastChange() {
		return lastChange;
	}
	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
    
    
}