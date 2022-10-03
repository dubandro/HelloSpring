package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Repository repository;

    @Autowired
    private void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void printProductList() {
        System.out.println("Available for order:\nid title price");
        for (Product product : repository.productList()) {
            System.out.println(product.getId() + "   " + product.getTitle() + "   " + product.getPrice());
        }
    }
}
