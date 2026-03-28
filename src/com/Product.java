package com;

class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Метод для розрахунку вартості з ігноруванням 3-ї цифри
    double getTotalPrice() {
        return ((long)(price * quantity * 100)) / 100.0;
    }
}