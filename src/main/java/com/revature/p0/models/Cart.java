package com.revature.p0.models;


import lombok.*;

import java.util.UUID;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cart {
    String id;
    String accountId;



    public Cart(String accountId) {
        this.id = UUID.randomUUID().toString();
        this.accountId = accountId;
    }





}
