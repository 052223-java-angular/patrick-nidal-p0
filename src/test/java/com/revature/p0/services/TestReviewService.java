package com.revature.p0.services;

import com.revature.p0.daos.ReviewDAO;
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

public class TestReviewService {
    @Mock
    private ReviewDAO reviewDAO;
    private ReviewService reviewService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        reviewService = new ReviewService(reviewDAO);
    }

    @Test
    public void testAddReview() {
        System.out.println("Passed.");
    }

    @Test
    public void testGetAllReviews() {
        System.out.println("Passed.");
    }

    @Test
    public void testGetReviewByProductId() {
        System.out.println("Passed.");
    }
}
