package fawry;

import java.util.*;

class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new RuntimeException("Cart is empty");

        double subtotal = 0, shippingFee = 0;
        List<CartItem> shippables = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int qty = item.getQuantity();

            if (product.isExpired()) throw new RuntimeException(product.getName() + " is expired");
            if (product.getQuantity() < qty) throw new RuntimeException(product.getName() + " out of stock");

            subtotal += product.getPrice() * qty;
            if (product.requiresShipping()) {
                shippables.add(item);
                shippingFee += 15; 
            }
        }

        double total = subtotal + shippingFee;
        if (customer.getBalance() < total) throw new RuntimeException("Insufficient balance");

       
        if (!shippables.isEmpty()) ShippingService.shipping(shippables);

       
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int qty = item.getQuantity();
            System.out.printf("%dx %-12s %.0f\n", qty, product.getName(), (qty * product.getPrice()));
            product.reduceQuantity(qty);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f\n", subtotal);
        System.out.printf("Shipping         %.0f\n", shippingFee);
        System.out.printf("Amount           %.0f\n", total);
        customer.minus(total);
    }
}