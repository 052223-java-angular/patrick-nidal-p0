package com.revature.p0.models;

import lombok.*;

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

    public CartItems(int quantity, double price, String productId) {
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
    }
}
