package com.sourabh.learning.cartdiscount;

import java.util.List;

public class CheckoutService {
    List<Offer> offers ;
    
    

    public CheckoutService(List<Offer> offers) {
		super();
		this.offers = offers;
	}



	public List<Offer> getOffers() {
		return offers;
	}



	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}



	public double checkout(CheckoutRequest request){
        final double totalDiscount = offers.stream().mapToDouble(offer -> offer.discountOffered(request)).sum();
        return request.getTotalAmount()- totalDiscount;
    }

}
