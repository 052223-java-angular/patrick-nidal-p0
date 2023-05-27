package com.revature.p0.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Product {
    private String id;
    private String description;
    private double price;
    private int onHand;
    private int categoryId;

    public Product(String description, double price, int onHand) {
        this.description = description;
        this.price = price;
        this.onHand = onHand;
    }

}
