package com.miage.ttb.ttb.domain;

import lombok.Data;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class Bakery {
    private UUID uuid;
    private String name;
    private Address address;
    private double rating;
    private Coordinates coordinates;
    private Set<Product> products;

    public boolean addProduct(Product product) {
        return products.add(product);
    }

    public void deleteProduct(Product product) {
        products = products.stream()
                .filter(item -> !item.equals(product))
                .collect(Collectors.toSet());
    }
}
