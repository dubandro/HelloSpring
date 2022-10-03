package ru.geekbrains;

/** ДЗ к Уроку №2
 * 1. Есть класс Product (id, название, цена). Товары хранятся в бине ProductRepository, в виде List<Product>,
 * при старте в него нужно добавить несколько товаров.
 * 2. ProductRepository позволяет получить весь список или один товар по id. Создаем бин Cart,
 * в который можно добавлять и удалять товары по id.
 * 3. При каждом запросе корзины из контекста, должна создаваться новая корзина.
 */

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.geekbrains");

        ProductService productService = context.getBean(ProductService.class);
        productService.printProductList();

        Cart cart = context.getBean(Cart.class);
        Cart cart1 = context.getBean(Cart.class);
        cart1.addProductById(3);
        cart1.printCard();
        cart.addProductById(1);
        cart.addProductById(3);
        cart.addProductById(2);
        cart.addProductById(1);
        cart.printCard();
        cart.removeProductById(1);
        cart.printCard();
        cart.clearCart();
        cart.printCard();
    }
}