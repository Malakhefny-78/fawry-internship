package fawry;

import java.util.*;

class ShippingService {
    public static void shipping(List<CartItem> items) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (CartItem item : items) {
            Product p = item.getProduct();
            if (p instanceof Shippable) {
                double weight = ((Shippable)p).getWeight() * item.getQuantity();
                System.out.printf("%dx %-12s %.0fg\n", item.getQuantity(), p.getName(), weight);
                totalWeight += weight;
            }
        }
        System.out.printf("Total package weight %.1fkg\n\n", totalWeight / 1000);
    }
}