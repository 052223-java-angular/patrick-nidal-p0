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
public class Review {

    private String id;
    private int stars;
    private String comment;
    private String accountId;
    private String productId;

    public Review(int stars, String comment, String accountId, String productId) {
        this.id = UUID.randomUUID().toString();
        this.stars = stars;
        this.comment = comment;
        this.accountId = accountId;
        this.productId = productId;
    }

    public Review(int stars, String comment, String productId) {
        this.stars = stars;
        this.comment = comment;
        this.productId = productId;
    }

}
