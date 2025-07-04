package fawry;

import java.time.LocalDate;

public class Finally {
	public static void main(String[] args) {
        Product cheese1 = new Cheese("Cheddar", 500, 10, 200, LocalDate.of(2025, 7, 5));
        Product biscuits1 = new Biscuits("Oreo", 150, 5, 700, LocalDate.of(2025, 7, 10));
        Product tv1 = new TV("LG TV", 100000, 3, 8000);
        Product scratchCard1 = new ScratchCard("Vodafone", 50, 10);
        Customer customer1 = new Customer("Malak", 1000000);
    
        Cart cart = new Cart();

        cart.add(cheese1, 2);
        cart.add(biscuits1,4 );
        cart.add(scratchCard1, 3);
        cart.add(tv1, 1);
        CheckoutService.checkout(customer1, cart);
        
        
       // Cart cart2 = new Cart(); 
       // Product tv2 = new TV("Sony TV", 100000, 3, 8000);
        //Product scratchCard2 = new ScratchCard("WE", 50, 10);
        //Product biscuits2 = new Biscuits("Biskrem", 150, , 700, LocalDate.of(2025, 4, 10));
        //Product cheese2 = new Cheese("Gouda", 500, 10, 200, LocalDate.of(2024, 5, 5));
        //Customer customer2 = new Customer("Malaak", 50);
      //  cart.add(cheese2, 2);
        //cart.add(biscuits2,4 );
      //  cart.add(scratchCard2, 3);
       // cart.add(tv2, 1);        
      //  CheckoutService.checkout(customer2, cart2);
    }
}

