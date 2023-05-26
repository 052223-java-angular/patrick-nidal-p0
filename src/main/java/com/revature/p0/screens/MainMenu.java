package com.revature.p0.screens;

import com.revature.p0.models.Session;
import java.util.Scanner;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MainMenu implements IScreen {
    //use session for menu navigation
    private Session session;

    public void start(Scanner scan) {
        System.out.println("Welcome to the user menu.  You are logged in.");

        //options for products, orders, reviews

    }

}
