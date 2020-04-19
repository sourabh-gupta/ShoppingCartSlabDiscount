package com.sourabh.learning.cartdiscount;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CheckoutService {
    List<Offer> offers ;
  
    public double checkout(CheckoutRequest request){
        final double totalDiscount = offers.stream().mapToDouble(offer -> offer.discountOffered(request)).sum();
        return request.getTotalAmount()- totalDiscount;
    }

}
