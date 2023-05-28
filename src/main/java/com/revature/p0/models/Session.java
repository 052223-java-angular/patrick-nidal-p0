package com.revature.p0.models;

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
public class Session {

    private String id;
    private String username;
    private String cartId;

    public void setSession(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public void setSession(User user, Cart cartId) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.cartId = cartId.getId();
    }






}
