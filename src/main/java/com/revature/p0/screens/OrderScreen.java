package com.revature.p0.screens;

import com.revature.p0.models.Order;
import com.revature.p0.services.OrderService;
import com.revature.p0.services.RouterService;
import com.revature.p0.models.Session;

import java.util.List;
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

        System.out.println("Orders unprocessed and history.");


        //should show cart items linking to product
        double total_sum = orderService.returnTotal(session.getCartId());
        System.out.println("current unprocessed order: " + total_sum);

        System.out.println("Order history");

        //return list of order history from order table?
        List<Order> allOrders = orderService.findAllByAccountId(session.getId());
        //use for each loop

        List<OrderItems> ordersToId = orderService.findAllByOrderId();

        //print product name

        //use session id to get orders and match with order items
        //get all orders matching to account/session id
        //then match order items to those orders

        //need to add associated products
        System.out.println("past orders");
        int counter = 0;
        for(Order order : allOrders) {
            System.out.println("order number: " + counter + " : " + order.getTotal_cost());
            counter++;
        }


    }

}
