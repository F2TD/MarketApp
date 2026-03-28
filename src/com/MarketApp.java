// Додаток MarketApp для формування чеку покупок

package com;

import java.util.Scanner;

public class MarketApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart myCart = new Cart();
        String name;

        System.out.println("=== Вітаємо в додатку MarketApp ===");
        
        while (true) {
            System.out.print("\nВведіть назву товару або 'стоп' (без лапок) для завершення: ");
            name = scanner.next(); 

            if (name.equalsIgnoreCase("стоп")) {
                if (myCart.items.isEmpty()) {
                    System.out.println("\n[Інфо]: Нічого не обрано. Чек не сформовано.");
                    return;
                } else {
                    break;
                }
            }

            // Валідація ціни
            double price = 0;
            while (true) {
                System.out.print("Введіть ціну товару в форматі 0,00: ");
                if (scanner.hasNextDouble()) {
                    double inputPrice = scanner.nextDouble();
                    if (inputPrice > 0) {
                        // Відсікаємо все, що після 2-го знаку
                        price = ((long)(inputPrice * 100)) / 100.0;
                        break; 
                    } else {
                        System.out.println("Помилка: ціна має бути більшою за нуль!");
                    }
                } else {
                    System.out.println("Помилка: введіть число через кому!");
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
                    else System.out.println("Помилка: кількість має бути більшою за нуль!");
                } else {
                    System.out.println("Помилка: введіть ціле число!");
                    scanner.next(); 
                }
            }

            myCart.addProduct(new Product(name, price, qty));
            System.out.println("Продукт '" + name + "' додано успішно.");
        }

        myCart.printReceipt();
    }
}