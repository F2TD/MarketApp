package com;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Cart {
    ArrayList<Product> items = new ArrayList<>();

    void addProduct(Product p) {
        items.add(p);
    }

    double calculateTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getTotalPrice();
        }
        return total;
    }

    void printReceipt() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String formattedDate = now.format(formatter);
        
        System.out.println("\n----- MarketApp -----");
        System.out.println("\n----- ВАШ ЧЕК -----");
        
        for (Product p : items) {
            // Використовуємо аргументи через кому для правильного округлення
            System.out.printf("%s: %d x %.2f = %.2f грн.\n", 
                              p.name, p.quantity, p.price, p.getTotalPrice());
        }
        
        System.out.println("-------------------");
        // Фінальне округлення суми РАЗОМ
        System.out.printf("РАЗОМ: %.2f грн.\n", calculateTotal());
        System.out.println("-------------------");
        
        System.out.println("Дата: " + formattedDate);
        System.out.println("\nДо зустрічі!\nСлава Україні!");
    }
}