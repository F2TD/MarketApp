// Додаток MarketApp для формування чеку покупок

// https://github.com/F2TD/MarketApp

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
            // Вибір типу продукту
            System.out.print("Оберіть одиницю вимірювання продукту (1 - шт, 2 - кг): ");
            String type = scanner.next();

           // Вводимо кількість продукту
            double qty;
            if (type.equals("1")) {
                qty = validateInt(scanner, "Введіть кількість (шт., ціле число): ");
            } else {
                qty = validateDouble(scanner, "Введіть вагу (кг, наприклад 1,5): ");
            }

            // Введення ціни продукту
            double price = validateDouble(scanner, "Введіть ціну за одиницю: ");

            // Додавання продукту до кошика
            if (type.equals("1")) {
                // Виклик методу для int (для штук)
                myCart.addProduct(name, price, (int)qty);
            } else {
                // Виклик методу для double (ваговий товар)
                myCart.addProduct(name, price, qty);
            }
            System.out.println("Товар '" + name + "' додано.");
        }

        if (!myCart.items.isEmpty()) myCart.printReceipt();
    }
    
        // Валідація дробового числа
        public static double validateDouble(Scanner scanner, String msg) {
            while (true) {
                System.out.print(msg);
                if (scanner.hasNextDouble()) {
                    double d = scanner.nextDouble();
                    if (d > 0) return d;
                } else scanner.next();
                System.out.println("Помилка: введіть коректне число (н)");
            }
        }

        // Валідація цілого числа
        public static int validateInt(Scanner scanner, String msg) {
            while (true) {
                System.out.print(msg);
                if (scanner.hasNextInt()) {
                    int i = scanner.nextInt();
                    if (i > 0) return i;
                } else scanner.next();
                System.out.println("Помилка: введіть ціле число!");
            }
        }
    }