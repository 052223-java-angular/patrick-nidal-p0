package com.revature.p0.screens;

import com.revature.p0.services.OrderService;
import com.revature.p0.services.RouterService;
import com.revature.p0.models.Session;
import java.util.Scanner;

public class OrderScreen {
    private final RouterService router;
    private final OrderService orderService;
    private Session session;

    public OrderScreen(RouterService router, OrderService orderService, Session session) {
        this.router = router;
        this.orderService = orderService;
        this.session = session;
    }

    public void start(Scanner scan) {


    }

}
