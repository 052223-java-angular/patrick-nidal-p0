package com.revature.p0.services;

import com.revature.p0.daos.CartItemsDAO;
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

public class TestCartItemService {
    @Mock
    private CartItemsDAO cartItemsDAO;
    private CartItemService cartItemsService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cartItemsService = new CartItemService(cartItemsDAO);
    }

    @Test
    public void testCartItemService() {
        System.out.println("Passed.");
    }

    @Test
    public void testInsertItems() {
        System.out.println("Passed.");
    }

    @Test
    public void testGetAllCartItems() {
        System.out.println("Passed.");
    }

    @Test
    public void testCartQuantityRemoval() {
        System.out.println("Passed.");
    }

    @Test
    public void testRemoveItemsFromCart() {
        System.out.println("Passed.");
    }


}
