package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private static final int CAPACITY = 5;
    private final Product[] products = new Product[CAPACITY];
    private int count;

    public void addProduct(Product product) {
        if (count >= CAPACITY) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products[count] = product;
        count++;
    }

    public void print() {
        int total = 0;
        int specialCount = 0;

        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                total += product.getPrice();
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }
}
