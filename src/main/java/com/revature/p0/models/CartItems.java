package com.revature.p0.models;

import java.util.UUID;
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

}
