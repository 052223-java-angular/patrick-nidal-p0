package com.revature.p0.models;

import java.util.UUID;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


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
