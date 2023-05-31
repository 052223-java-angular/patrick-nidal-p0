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

        System.out.println("\nUnprocessed order");
        double total_sum = orderService.returnTotal(session.getCartId());
        System.out.println("Total of any unprocessed orders are: $" + total_sum);

        System.out.println("\nOrders history.\n");

        List<Order> allOrders = orderService.findAllByAccountId(session.getId());
        int counter = 1;

        for(Order oneOrder : allOrders) {
            List<OrderItems> orderItems = orderService.findAllByOrderId(oneOrder.getId());
            for(OrderItems items : orderItems) {
                System.out.println(counter + ". Items for this order include: " + items.getQuantity() + "x " + items.getProductId());

            }
            System.out.println("Total cost of order: $" + oneOrder.getTotal_cost());

            counter++;
        }

    }

}
