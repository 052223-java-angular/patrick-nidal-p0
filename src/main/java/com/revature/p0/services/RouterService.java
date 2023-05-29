package com.revature.p0.services;

import com.revature.p0.daos.*;
import com.revature.p0.screens.*;
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
                new ProductScreen(this, getProductService(), session, getCartService(), getCategoryService()).start(scan);
                break;
            case "/cart":
                new CartScreen(this, getCartService(), session, getProductService()).start(scan);
                break;
            case "/order":
                new OrderScreen(this, getOrderService(), session).start(scan);
                break;
            case "/review":
                new ReviewScreen(this, getReviewService(), session).start(scan);
                break;
            case "/checkout":
                new CheckoutScreen(this, getOrderService(), session, getCartService(), getProductService()).start(scan);
                break;
            default:
                break;
        }
    }


    //----helpers for navigation----

    private UserService getUserService() {
        return new UserService(new UserDAO(), new CartDAO());
    }

    private ProductService getProductService() {
        return new ProductService(new ProductDAO());
    }
    private CartItemService getCartService() {
        return new CartItemService(new CartItemsDAO());
    }
    private CategoryService getCategoryService() {return new CategoryService(new CategoryDAO());}
    private OrderService getOrderService() {return new OrderService(new OrderDAO(), new CartItemsDAO());}
    private ReviewService getReviewService() {return new ReviewService(new ReviewDAO());}


}
