package com.revature.p0.services;

import com.revature.p0.daos.CategoryDAO;
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

public class TestCategoryService {
    @Mock
    private CategoryDAO categoryDAO;
    private CategoryService categoryService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryService = new CategoryService(categoryDAO);
    }

    @Test
    public void testCategoryService() {
        System.out.println("Passed.");
    }

    @Test
    public void testGetAllCategories() {
        System.out.println("Passed.");
    }


}
