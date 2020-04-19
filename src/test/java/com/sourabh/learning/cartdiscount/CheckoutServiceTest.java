package com.sourabh.learning.cartdiscount;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Should Pass all checkout tests")
class CheckoutServiceTest {

    @Test
    void checkoutRegular(){
    	System.out.println("start test 1");
        SlabBasedOffer.Slab slab1 = new SlabBasedOffer.Slab(0,5000, 0);
        SlabBasedOffer.Slab slab2 = new SlabBasedOffer.Slab(5001,10000, 0.1F);
        SlabBasedOffer.Slab slab3 = new SlabBasedOffer.Slab(10001,15000, 0.2F);
        final List<SlabBasedOffer.Slab> slabsRegular = Arrays.asList(slab1, slab2, slab3);
       
        CheckoutRequest checkoutRequest = new CheckoutRequest(Customer.REGULAR, 25000.0);
        final HashMap<Customer, List<SlabBasedOffer.Slab>> customerBasedSlabs = new HashMap<>();
        customerBasedSlabs.put(Customer.REGULAR, slabsRegular);


        final List<Offer> offers = Arrays.asList(new SlabBasedOffer(customerBasedSlabs));
        final CheckoutService checkoutService = new CheckoutService(offers);

        final double checkout = checkoutService.checkout(checkoutRequest);
        System.out.println(checkout);
        assertEquals(23500, checkout, 1.0);
    }
 
    @Test
    void checkoutRegularNew(){
    	System.out.println("start test 2");
        SlabBasedOffer.Slab slab1 = new SlabBasedOffer.Slab(0,5000, 0);
        SlabBasedOffer.Slab slab2 = new SlabBasedOffer.Slab(5001,10000, 0.1F);
        SlabBasedOffer.Slab slab3 = new SlabBasedOffer.Slab(10001,0, 0.2F);
        final List<SlabBasedOffer.Slab> slabsRegular = Arrays.asList(slab1, slab2, slab3);
        
        CheckoutRequest checkoutRequest = new CheckoutRequest(Customer.REGULAR, 25000.0);
        final HashMap<Customer, List<SlabBasedOffer.Slab>> customerBasedSlabs = new HashMap<>();
        customerBasedSlabs.put(Customer.REGULAR, slabsRegular);


        final List<Offer> offers = Arrays.asList(new SlabBasedOffer(customerBasedSlabs));
        final CheckoutService checkoutService = new CheckoutService(offers);

        final double checkout = checkoutService.checkout(checkoutRequest);
        System.out.println(checkout);
        assertEquals(21500, checkout, 1.0);
    }
    
    @Test
    void checkoutPremium(){
    	System.out.println("start test 3");
        SlabBasedOffer.Slab slab1 = new SlabBasedOffer.Slab(0,4000, 0.1F);
        SlabBasedOffer.Slab slab2 = new SlabBasedOffer.Slab(4001,8000, 0.15F);
        SlabBasedOffer.Slab slab3 = new SlabBasedOffer.Slab(8001,12000, 0.2F);
        SlabBasedOffer.Slab slab4 = new SlabBasedOffer.Slab(12001,0, 0.3F);
        final List<SlabBasedOffer.Slab> slabsRegular = Arrays.asList(slab1, slab2, slab3,slab4);
       
        CheckoutRequest checkoutRequest = new CheckoutRequest(Customer.PREMIUM, 24000.0);
        final HashMap<Customer, List<SlabBasedOffer.Slab>> customerBasedSlabs = new HashMap<>();
        customerBasedSlabs.put(Customer.PREMIUM, slabsRegular);


        final List<Offer> offers = Arrays.asList(new SlabBasedOffer(customerBasedSlabs));
        final CheckoutService checkoutService = new CheckoutService(offers);

        final double checkout = checkoutService.checkout(checkoutRequest);
        System.out.println(checkout);
        assertEquals(18600, checkout, 1.0);
    }
 
    

}