package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // 1. Корзина
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Яблоко", 100));
        basket.addProduct(new SimpleProduct("Банан", 150));
        basket.addProduct(new DiscountedProduct("Ноутбук", 1000, 20));
        basket.addProduct(new FixPriceProduct("Мышка"));
        basket.print();

        System.out.println();

        // 2. Движок поиска
        SearchEngine searchEngine = new SearchEngine(10);

        // 3. Товары в поисковый движок
        searchEngine.add(new SimpleProduct("Яблоко", 100));
        searchEngine.add(new SimpleProduct("Банан", 150));
        searchEngine.add(new DiscountedProduct("Ноутбук", 1000, 20));
        searchEngine.add(new FixPriceProduct("Мышка"));

        // 4. Статьи в поисковый движок
        searchEngine.add(new Article("Как выбрать ноутбук",
                "Ноутбук — важная покупка. Рассказываем, на что смотреть при выборе."));
        searchEngine.add(new Article("Польза яблок",
                "Яблоко — источник витаминов. Один плод в день творит чудеса."));

        // 5. Демонстрация поиска
        System.out.println("Поиск: 'ноутбук'");
        System.out.println(Arrays.toString(searchEngine.search("ноут")));

        System.out.println("\nПоиск: 'яблоко'");
        System.out.println(Arrays.toString(searchEngine.search("яблоко")));

        System.out.println("\nПоиск: 'банан'");
        System.out.println(Arrays.toString(searchEngine.search("банан")));

        System.out.println("\nПоиск: 'чайник' (ничего не найдётся)");
        System.out.println(Arrays.toString(searchEngine.search("чайник")));
    }
}
