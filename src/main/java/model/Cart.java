package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart {

    private List<Product> products = new ArrayList<Product>();

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void addProduct(Product product, int quantity){
        if(quantity <= 0){
            throw new RuntimeException("Quantity should be greater than zero");
        }
        for (int i = 1; i <= quantity; i++) {
            products.add(product);
        }
    }

    public int getNumberOfProducts() {
        return products.size();
    }

    public long getTotalPrice() {
        long price = 0;
        for (Product p : products) {
            price = price + p.getPrice();
        }
        return price;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
