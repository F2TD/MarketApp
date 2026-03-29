package com;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Cart {
    ArrayList<Product> items = new ArrayList<>();

 // Варіант 1: додавання вагового товару
    void addProduct(String name, double price, double quantity) {
        items.add(new Product(name, price, quantity, "кг"));
    }

    // Варіант 2: додавання поштучного товару (int кількість)
    void addProduct(String name, double price, int quantity) {
        items.add(new Product(name, price, (double)quantity, "шт."));
    }

    void printReceipt() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String formattedDate = now.format(formatter);
        double grandTotal = 0;
        
        System.out.println("\n----- MarketApp -----");
        System.out.println("\n----- ВАШ ЧЕК -----");
        
        for (Product p : items) {
        	double total = p.getTotalPrice();
            grandTotal += total;
            if (p.unit.equals("шт.")) {
                System.out.printf("%s: %.0f %s x %.2f = %.2f грн.\n", p.name, p.quantity, p.unit, p.price, total);
            } else {
                System.out.printf("%s: %.2f %s x %.2f = %.2f грн.\n", p.name, p.quantity, p.unit, p.price, total);
            }
        }
        
        System.out.println("-------------------");
        // Фінальне округлення суми РАЗОМ
        System.out.printf("РАЗОМ: %.2f грн.\n", grandTotal);
        System.out.println("-------------------");
        
        System.out.println("Дата: " + formattedDate);
        System.out.println("\nДо зустрічі!\nСлава Україні!");
    }
}