package com.sourabh.learning.cartdiscount;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class SlabBasedOffer implements Offer {
    private Map<Customer, List<Slab>> customerBasedSlabs;

	@Override
    public double discountOffered(CheckoutRequest request) {
        final List<Slab> slabs = customerBasedSlabs.get(request.getCustomer());
        Collections.sort(slabs);
        double reminder = request.getTotalAmount();
        double discount = 0;
        for (Slab slab: slabs) {
        	long slabAmount = 0;
        	if(slab.getEnd() == 0) {
        		slabAmount = (long) reminder;
        	}else {
        	    slabAmount = slab.getEnd() - slab.getStart();
        	}
            
            if(reminder > 0 ){
                double actualDiscountable ;
                if(reminder >= slabAmount){
                    actualDiscountable = slabAmount;
                } else {
                    actualDiscountable = reminder;
                }
                discount += actualDiscountable * slab.getDiscount();
                reminder -= slabAmount;
            }

        }
        return discount;
    }

	@AllArgsConstructor
    @Data
    public static class Slab implements Comparable<Slab> {
       
		private long start;
        private long end;
        private float discount;

		@Override
        public int compareTo(Slab o) {
            return Long.compare(this.start, o.start);
        }
    }

}
