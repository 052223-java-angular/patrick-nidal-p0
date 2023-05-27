package com.revature.p0.services;

import com.revature.p0.daos.ProductDAO;
import com.revature.p0.screens.*;
import com.revature.p0.daos.UserDAO;
import com.revature.p0.models.Session;
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
                new LoginScreen(this, getUserService(), session).start(scan);
                break;
            case "/menu":
                new MainMenu(this, session).start(scan);
                break;
            case "/product":
                new ProductScreen(this, getProductService(), session);
                break;
            case "/order":
                //to orders
                //make objects for all screens and pass in session
            case "/cart":
                //to cart
            case "/review":
                //to reviews
            default:
                break;
        }
    }


    //helpers for navigations

    private UserService getUserService() {
        return new UserService(new UserDAO());
    }

    private ProductService getProductService() {
        return new ProductService(new ProductDAO());
    }

}
