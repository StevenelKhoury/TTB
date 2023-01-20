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

    //Constructors
    public Bakery() {
        this.uuid = UUID.randomUUID();
    }

    public Bakery(String name, Address address, double rating, Coordinates coordinates) {
        this();
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.coordinates = coordinates;
    }

    public Bakery(String name, Address address, double rating, Coordinates coordinates, Set<Product> products) {
        this(name, address, rating, coordinates);
        this.products = products;
    }



    public boolean addProduct(Product product) {
        return products.add(product);
    }

    public void deleteProduct(Product product) {
        products = products.stream()
                .filter(item -> !item.equals(product))
                .collect(Collectors.toSet());
    }



}
