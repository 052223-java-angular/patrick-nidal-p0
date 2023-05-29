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
public class OrderItems {
    private String id;
    private int quantity;
    private String orderId;
    private String productId;

    public OrderItems(int quantity, String orderId, String productId) {
        this.id = UUID.randomUUID().toString();
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
    }
}
