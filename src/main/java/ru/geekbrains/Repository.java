package ru.geekbrains;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class Repository {

    private List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>(Arrays.asList(
                new Product(1, "Bread", 50L),
                new Product(2, "Milk", 80L),
                new Product(3, "Orange", 100L)
        ));
    }

    public Product findById(int id) {
        // почему equals горит красным?
//        return productList.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
        return productList.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElseThrow();
    }

    public List<Product> productList() {
        return productList;
    }
}
