package com.mycompany.app.services;

import com.mycompany.app.screens.HomeScreen;
import com.mycompany.app.screens.MainMenu;
import com.mycompany.app.screens.RegisterScreen;
import com.mycompany.app.daos.UserDAO;
import com.mycompany.app.models.Session;
import com.mycompany.app.screens.LoginScreen;
import lombok.AllArgsConstructor;
import java.util.Scanner;

@AllArgsConstructor
public class RouterService {
    private Session session;

    public void navigate(String path, Scanner scan) {
        switch(path) {

            case "/home":
                new HomeScreen(this).start(scan);
                break;
            case "/register":
                new RegisterScreen(this, getUserService(), session).start(scan);
                break;
            case "/login":
                new LoginScreen(this).start(scan);
                break;
            case "/menu":
                System.out.println("menu");
            default:
                break;
        }
    }

    //helpers for navigations

    private UserService getUserService() {
        return new UserService(new UserDAO());
    }

}
