package com.mycompany.app.services;

import com.mycompany.app.screens.HomeScreen;
import com.mycompany.app.screens.MainMenu;
import com.mycompany.app.screens.RegisterScreen;
import com.mycompany.app.daos.UserDAO;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class RouterService {

    public void navigate(String path, Scanner scan) {
        switch(path) {

            case "/home":
                new HomeScreen(this).start(scan);
                break;
            case "/login":
                System.out.println("login");
                break;
            case "/menu":
                System.out.println("menu");
            case "/register":
                new RegisterScreen(this, getUserService()).start(scan);
                break;
            case "/review":
                System.out.println("review");
                break;
            default:
                break;
        }
    }

    //helpers for navigations

    private UserService getUserService() {
        return new UserService(new UserDAO());
    }

}
