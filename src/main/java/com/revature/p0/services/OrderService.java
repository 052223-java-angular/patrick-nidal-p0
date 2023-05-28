package com.revature.p0.services;

import com.revature.p0.daos.OrderDAO;

public class OrderService {
    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    //query cart_items for all cart_item(id) to get total price for order using user session id
    //return list of cart_items, each has a total price, iterate through the list and calculate total price
    //for order




}
