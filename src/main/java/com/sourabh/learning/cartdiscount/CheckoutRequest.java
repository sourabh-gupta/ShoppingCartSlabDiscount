package com.sourabh.learning.cartdiscount;

public class CheckoutRequest {
    private Customer customer;
    private double totalAmount;
    
    
    
	public CheckoutRequest(Customer customer, double totalAmount) {
		super();
		this.customer = customer;
		this.totalAmount = totalAmount;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
