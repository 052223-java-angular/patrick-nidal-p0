package com.revature.p0.services;

import com.revature.p0.daos.ReviewDAO;
import com.revature.p0.models.Review;

import java.util.List;

public class ReviewService {
    private final ReviewDAO reviewDAO;

    public ReviewService(ReviewDAO reviewDAO){
        this.reviewDAO = reviewDAO;
    }

    public boolean addReview(Review review) {
        return reviewDAO.addReview(review);
    }

    public List<Review> getAllReviews() {
        return reviewDAO.getAllReviews();
    }

    public List<Review> getReviewByProductId(String id) {
        return reviewDAO.getReviewsByProductId(id);
    }
}
