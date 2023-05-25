package com.mycompany.app.models;

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

    public void setSession(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

}
