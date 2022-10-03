package ru.geekbrains;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Scope("prototype")
public class Cart {

    private final Repository repository;
    private List<Product> productCart;

    public Cart(Repository repository) {
        this.repository = repository;
    }

    @PostConstruct
    private void initCart() {
        this.productCart = new ArrayList<>();
    }

    public void addProductById(int id) {
        productCart.add(repository.findById(id));
    }

    public void removeProductById(int id) {
        productCart.removeIf(p -> Objects.equals(p.getId(), id));
    }

    public void clearCart() {
        productCart.clear();
    }

    public void printCard() {
        System.out.print("Your cart (" + this + "):");
        if (productCart.isEmpty()) {
            System.out.println(" Empty");
        }
        else {
            System.out.println("\nid title price");
            for (Product product : productCart) {
                System.out.println(product.getId() + "   " + product.getTitle() + "   " + product.getPrice());
            }
        }
    }
}
