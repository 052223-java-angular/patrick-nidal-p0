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
    private String account_id;
    private String product_id;

}
