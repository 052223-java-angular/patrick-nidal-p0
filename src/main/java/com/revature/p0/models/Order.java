package com.revature.p0.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    private String id;
    private double total_cost;
    private String account_id;

    public Order(double total_cost, String account_id) {
        this.id = UUID.randomUUID().toString();
        this.total_cost = total_cost;
        this.account_id = account_id;
    }

}
