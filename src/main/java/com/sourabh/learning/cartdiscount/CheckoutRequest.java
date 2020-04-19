package com.sourabh.learning.cartdiscount;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CheckoutRequest {
    private Customer customer;
    private double totalAmount;
    
}
