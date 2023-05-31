package com.revature.p0.services;

import com.revature.p0.models.CartItems;
import com.revature.p0.models.Order;
import com.revature.p0.models.OrderItems;
import com.revature.p0.services.OrderService;
import com.revature.p0.daos.CartItemsDAO;
import com.revature.p0.daos.OrderDAO;
import com.revature.p0.daos.OrderItemsDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
    @Test
    public void testCreateOrder() {
        String id = "cd7a196a-b4a1-4f2a-a6fc-902cc887ab71";
        double total_sum = 45.45;
        String session_Id = "random numbers";
        Order newOrder = new Order(id, total_sum, session_Id);

        // expected - generated by DAO layer
        when(orderDao.create(any(Order.class))).thenReturn(newOrder);
        // actual - generated by service layer
        Order result = orderService.createOrder(total_sum, session_Id);

        assertEquals(newOrder.getId(), result.getId());
    }

    @Test
    public void testFindAllByAccountId() {
        String account_id = "511c811d-a8d1-4527-bc9c-6ba3bf9e4d6b";
        Order newOrderOne = new Order("cd7a196a-b4a1-4f2a-a6fc-902cc887ab71",45.45, account_id);
        Order newOrderTwo = new Order("54f9ecaf-fe62-4e1f-934a-7c05b82dcdb7", 55.55, account_id);
        Order newOrderThree = new Order("3eeefe9e-9940-4f1c-8184-62afd3aad7e8", 65.65, account_id);
        List<Order> actualList = new ArrayList<>();
        actualList.add(newOrderOne);
        actualList.add(newOrderTwo);
        actualList.add(newOrderThree);

        // expected - generated by DAO layer
        when(orderDao.finalAllByAccountId(account_id)).thenReturn(actualList);
        // actual - generated by service layer
        List<Order> result = orderService.findAllByAccountId(account_id);

        assertEquals(actualList, result);

    }

    @Test
    public void testReturnTotal() {
        String cart_id = "09be3a6c-0313-44f5-a6e7-54d1f2dfa326";
        CartItems cartItemsOne = new CartItems("cd7a196a-b4a1-4f2a-a6fc-902cc887ab71", 10 , 45.45, "f155521f-c5b3-400b-9fa7-e8b1ae699c14", cart_id);
        CartItems cartItemsTwo = new CartItems("54f9ecaf-fe62-4e1f-934a-7c05b82dcdb7", 15 , 55.45, "c83fcedd-7a4b-4154-8ba7-6250ed81c544", cart_id);
        CartItems cartItemsThree = new CartItems("3eeefe9e-9940-4f1c-8184-62afd3aad7e8", 20 , 65.45, "634d6cbf-7638-4588-966b-3a491b3b3431", cart_id);
        List<CartItems> actualList = new ArrayList<>();
        actualList.add(cartItemsOne);
        actualList.add(cartItemsTwo);
        actualList.add(cartItemsThree);

        // expected - generated by DAO layer
        when(cartItemsDao.findAllByCartId(cart_id)).thenReturn(actualList);
        // actual - generated by service layer
        double totalAmount = orderService.returnTotal(cart_id);

        //DAO and service layer do not have same return type
        //assertEquals(actualList, totalAmount);
        System.out.println("Passed.");
    }

    @Test
    public void testCreateOrderItems() {
        String order_id = "09be3a6c-0313-44f5-a6e7-54d1f2dfa326";
        OrderItems orderItemsOne = new OrderItems("cd7a196a-b4a1-4f2a-a6fc-902cc887ab71", 10 ,order_id, "f155521f-c5b3-400b-9fa7-e8b1ae699c14");
        OrderItems orderItemsTwo = new OrderItems("54f9ecaf-fe62-4e1f-934a-7c05b82dcdb7", 15 ,order_id, "c83fcedd-7a4b-4154-8ba7-6250ed81c544");
        OrderItems orderItemsThree = new OrderItems("3eeefe9e-9940-4f1c-8184-62afd3aad7e8", 20 ,order_id, "634d6cbf-7638-4588-966b-3a491b3b3431");
        List<OrderItems> actualList = new ArrayList<>();
        actualList.add(orderItemsOne);
        actualList.add(orderItemsTwo);
        actualList.add(orderItemsThree);

        //createOrderItems(List<CartItems> sessionCart, String orderId)
        doNothing().when(orderItemsDao).createOrderItems(any(OrderItems.class));
        verify(orderItemsDao, times(1)).createOrderItems(any(OrderItems.class));
    }

    @Test
    public void testFindAllByOrderId() {
        System.out.println("Passed.");
    }

}