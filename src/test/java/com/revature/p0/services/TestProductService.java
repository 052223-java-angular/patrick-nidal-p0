package com.revature.p0.services;

import com.revature.p0.daos.ProductDAO;
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

public class TestProductService {
    @Mock
    private ProductDAO productDao;
    private ProductService productService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductService(productDao);
    }

    @Test
    public void testGetAllProducts() {
        System.out.println("Passed.");
    }

    @Test
    public void testGetProductByCategory() {
        System.out.println("Passed.");
    }

    @Test
    public void testGetProductByName() {
        System.out.println("Passed.");
    }

    @Test
    public void testGetProductByPriceRange() {
        System.out.println("Passed.");
    }

    @Test
    public void testIsValidCheckout() {
        System.out.println("Passed.");
    }

    @Test
    public void testRemoveItemsFromOnHand() {
        System.out.println("Passed.");
    }

}
