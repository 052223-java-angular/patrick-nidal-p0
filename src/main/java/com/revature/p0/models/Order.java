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
public class Order {

    private String id;
    private double total_cost;
    private String account_id;

    public Order(double total_cost, String account_id) {
        this.id = UUID.randomUUID().toString();
        this.total_cost = total_cost;
        this.account_id = account_id;
    }
    public Order(double total_cost) {

        this.total_cost = total_cost;

    }


}
