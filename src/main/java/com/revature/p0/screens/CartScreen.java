package com.revature.p0.screens;

import com.revature.p0.models.CartItems;
import com.revature.p0.models.Session;
import com.revature.p0.services.CartItemService;
import com.revature.p0.services.RouterService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;
@AllArgsConstructor

public class CartScreen implements IScreen {
    private final RouterService routerService;
    private final CartItemService cartService;
    private Session session;

    @Override
    public void start(Scanner scan) {
        System.out.println("Cart Items ");


    }
}
