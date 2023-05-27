package com.revature.p0.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Product {
    private String name;
    private String description;
    private double price;
    private int onHand;
    private int category;

    public Product(String name, String description, double price, int onHand) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.onHand = onHand;
    }

}
