package com.sourabh.learning.cartdiscount;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SlabBasedOffer implements Offer {
    private Map<Customer, List<Slab>> customerBasedSlabs;

    public Map<Customer, List<Slab>> getCustomerBasedSlabs() {
		return customerBasedSlabs;
	}

	public void setCustomerBasedSlabs(Map<Customer, List<Slab>> customerBasedSlabs) {
		this.customerBasedSlabs = customerBasedSlabs;
	}

	public SlabBasedOffer(Map<Customer, List<Slab>> customerBasedSlabs) {
		super();
		this.customerBasedSlabs = customerBasedSlabs;
	}

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

    public static class Slab implements Comparable<Slab> {
       


		public long getStart() {
			return start;
		}


		public void setStart(long start) {
			this.start = start;
		}


		public long getEnd() {
			return end;
		}


		public void setEnd(long end) {
			this.end = end;
		}


		public float getDiscount() {
			return discount;
		}


		public void setDiscount(float discount) {
			this.discount = discount;
		}


		private long start;
        private long end;
        private float discount;

        

        public Slab(long start, long end, float discount) {
			super();
			this.start = start;
			this.end = end;
			this.discount = discount;
		}


		@Override
        public int compareTo(Slab o) {
            return Long.compare(this.start, o.start);
        }
    }

}
