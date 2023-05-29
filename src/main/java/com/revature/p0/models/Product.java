package com.revature.p0.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    private String category;

    public Product(String id, String description, double price, int onHand) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.onHand = onHand;
    }

}
