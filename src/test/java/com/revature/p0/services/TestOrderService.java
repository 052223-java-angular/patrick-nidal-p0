package com.revature.p0.services;

import com.revature.p0.models.Order;
import com.revature.p0.services.OrderService;
import com.revature.p0.daos.CartItemsDAO;
import com.revature.p0.daos.OrderDAO;
import com.revature.p0.daos.OrderItemsDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class TestOrderService {
    @Mock
    private OrderDAO orderDao;
    @Mock
    private CartItemsDAO cartItemsDao;
    @Mock
    private OrderItemsDAO orderItemsDao;
    private OrderService orderService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(orderDao, cartItemsDao, orderItemsDao);
    }


    //String createOrder(double total_sum, String session_Id)
    @Test
    public void testCreateOrder () {
        double total_sum = 45.45;
        String session_Id = "randomnumbers";
        String actual = orderService.createOrder(total_sum, session_Id);
        //may need to mock a user session id to make work

        //make a order object
        String expected = "whatever the return value is supposed to be";
        Assert.assertEquals(actual, expected);
    }

    //List<Order> findAllByAccountId(String account_id) {
    //        return orderDao.finalAllByAccountId(account_id);
    //    }

    //OK, this is a bad thing to be doing. Don't mock a list; instead, mock the individual objects inside the list
    //https://stackoverflow.com/questions/18483176/mockito-mocking-an-arraylist-that-will-be-looped-in-a-for-loop
    @Test void testFindAllByAccountId() {
        String account_id = "user123";
        List<Order> actual = orderService.findAllByAccountId("account_id");
        List<Order> expected = ??;
    }

}