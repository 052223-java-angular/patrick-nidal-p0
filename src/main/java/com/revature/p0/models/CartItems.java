package com.revature.p0.models;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class CartItems {
    private String id;
    private int quantity;
    private double price;
    private String productId;
    private String cartId;

    public CartItems(int quantity, double price, String productId, String cartId) {
        this.id = UUID.randomUUID().toString();
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
        this.cartId = cartId;
    }

    public CartItems(int quantity, double price, String productId) {
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
        this.cartId = cartId;
    }






}
