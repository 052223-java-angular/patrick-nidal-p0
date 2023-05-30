package com.revature.p0.services;

import com.revature.p0.daos.CartItemsDAO;
import com.revature.p0.daos.OrderDAO;
import com.revature.p0.daos.OrderItemsDAO;
import com.revature.p0.models.*;

import java.util.List;

public class OrderService {
    private final OrderDAO orderDao;
    private final CartItemsDAO cartItemsDao;
    private final OrderItemsDAO orderItemsDao;

    public OrderService(OrderDAO orderDao, CartItemsDAO cartItemsDao, OrderItemsDAO orderItemsDao) {
        this.orderDao = orderDao;
        this.cartItemsDao = cartItemsDao;
        this.orderItemsDao = orderItemsDao;
    }

    public double returnTotal(String cartId) {
        List<CartItems> cartItemPrices = cartItemsDao.findAllByCartId(cartId);
        double total_sum = 0;
        for(CartItems item : cartItemPrices) {
            total_sum += item.getPrice();
        }
        return total_sum;
    }

    public Order createOrder(double total_sum, String session_Id) {
        Order newOrder = new Order(total_sum, session_Id);
        return orderDao.create(newOrder);
    }

    public List<Order> findAllByAccountId(String account_id) {
        return orderDao.finalAllByAccountId(account_id);
    }

    public void createOrderItems(List<CartItems> sessionCart, String orderId) {
        for(CartItems item : sessionCart) {
            OrderItems orderItems = new OrderItems(item.getQuantity(), orderId, item.getProductId());
            orderItemsDao.createOrderItems(orderItems);
        }
    }

    public List<OrderItems> findAllByOrderId(String orderId){
        return orderItemsDao.findAllByOrderId(orderId);
    }
}
