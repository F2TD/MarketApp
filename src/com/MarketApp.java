package com;

import java.util.Scanner;

public class MarketApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart myCart = new Cart();

        System.out.println("=== Система 'Торговий Експерт' активовано ===");

        while (true) {
            System.out.print("\nВведіть назву товару (або 'стоп'): ");
            String name = scanner.next();
            
            // Перевірка на вихід (не пускає з порожнім кошиком)
            if (name.equalsIgnoreCase("стоп")) {
                if (myCart.items.isEmpty()) {
                    System.out.println("Помилка: спочатку додайте хоча б один товар!");
                    continue; 
                } else {
                    break; 
                }
            }

            // Валідація ціни
            double price = 0;
            while (true) {
                System.out.print("Введіть ціну товару (наприклад, 0,00): ");
                if (scanner.hasNextDouble()) {
                    double inputPrice = scanner.nextDouble();
                    if (inputPrice > 0) {
                        // Відсікаємо все після 2-го знаку
                        price = ((long)(inputPrice * 100)) / 100.0;
                        break; 
                    } else {
                        System.out.println("Помилка: ціна має бути > 0!");
                    }
                } else {
                    System.out.println("Помилка: введіть число (через кому)!");
                    scanner.next(); 
                }
            }

            // Валідація кількості
            int qty = 0;
            while (true) {
                System.out.print("Введіть кількість (ціле число): ");
                if (scanner.hasNextInt()) {
                    qty = scanner.nextInt();
                    if (qty > 0) break;
                    else System.out.println("Помилка: кількість має бути > 0!");
                } else {
                    System.out.println("Помилка: введіть ціле число!");
                    scanner.next(); 
                }
            }

            myCart.addProduct(new Product(name, price, qty));
            System.out.println("Товар '" + name + "' додано успішно.");
        }

        myCart.printReceipt();
    }
}