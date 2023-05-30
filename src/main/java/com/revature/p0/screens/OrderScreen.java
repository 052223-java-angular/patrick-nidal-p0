package com.revature.p0.screens;

import com.revature.p0.models.Order;
import com.revature.p0.services.OrderService;
import com.revature.p0.services.RouterService;
import com.revature.p0.models.Session;
import com.revature.p0.models.OrderItems;

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

        System.out.println("Unprocessed order");
        double total_sum = orderService.returnTotal(session.getCartId());
        System.out.println("Total of the above order is: " + total_sum);

        System.out.println("Orders history.");

        List<Order> allOrders = orderService.findAllByAccountId(session.getId());
        int counter = 1;

        for(Order oneOrder : allOrders) {
            System.out.println(oneOrder.getTotal_cost());
            List<OrderItems> orderItems = orderService.findAllByOrderId(oneOrder.getId());
            System.out.println(oneOrder.getAccount_id());
            for(OrderItems items : orderItems) {
                System.out.println(counter + ". Items for this order include: " + items.getQuantity() + "x " + items.getProductId());

            }
            System.out.println("total cost of order:" + oneOrder.getTotal_cost());
            counter++;
        }

    }

}
