package com.revature.p0.services;

import com.revature.p0.models.Session;
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

public class TestRouterService {
    @Mock
    private Session session;
    private RouterService router;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        router = new RouterService(session);
    }

    @Test
    public void testNavigate() {
        System.out.println("Passed.");
    }
}
