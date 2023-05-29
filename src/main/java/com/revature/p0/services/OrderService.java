package com.revature.p0.services;

import com.revature.p0.daos.CartItemsDAO;
import com.revature.p0.daos.OrderDAO;
import com.revature.p0.models.CartItems;
import com.revature.p0.models.Order;
import com.revature.p0.models.Product;
import com.revature.p0.models.Session;

import java.util.List;

public class OrderService {
    private final OrderDAO orderDao;
    private final CartItemsDAO cartItemsDao;

    public OrderService(OrderDAO orderDao, CartItemsDAO cartItemsDao) {
        this.orderDao = orderDao;
        this.cartItemsDao = cartItemsDao;
    }

    //query cart_items for all cart_item(id) to get total price for order using user session id
    //return list of cart_items, each has a total price, iterate through the list and calculate total price
    //for order

    public double returnTotal(String cartId) {
        List<CartItems> cartItemPrices = cartItemsDao.findAllByCartId(cartId);
        double total_sum = 0;
        for(CartItems item : cartItemPrices) {
            total_sum += item.getPrice();
        }
        return total_sum;
    }

    public void createOrder(double total_sum, String session_Id) {
        Order newOrder = new Order(total_sum, session_Id);
        orderDao.save(newOrder);
    }

    public List<Order> finalAllByAccountId(String account_id) {
        return orderDao.finalAllByAccountId(account_id);
    }
}
