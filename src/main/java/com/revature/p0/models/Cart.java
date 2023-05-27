package com.revature.p0.models;


import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cart {
    String id;
    String accountId;

    public Cart(String id, String accountId) {
        this.id = id;
        this.accountId = accountId;
    }



}
