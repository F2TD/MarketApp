package com;

class Product {
    String name;
    double price;
    double quantity;
    String unit;

    Product(String name, double price, double quantity, String unit) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
    }

    // Метод для розрахунку вартості з ігноруванням 3-ї цифри
    double getTotalPrice() {
        return ((long)(price * quantity * 100)) / 100.0;
    }
}