package com.revature.p0.daos;

import com.revature.p0.models.Review;
import com.revature.p0.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    //Add a review method
    public boolean addReview(Review review) {
        boolean creationSuccess = false;
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO reviews (id, stars, comment, account_id, product_id) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, review.getId());
                ps.setInt(2, review.getStars());
                ps.setString(3, review.getComment());
                ps.setString(4, review.getAccountId());
                ps.setString(5, review.getProductId());

                creationSuccess = ps.executeUpdate() == 1;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }
        return creationSuccess;
    }

    //Get all reviews method
    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM reviews";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Review review = new Review(rs.getInt("stars"), rs.getString("comment"),
                            rs.getString("product_id"));
                    reviews.add(review);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }
        return reviews;
    }

    //get reviews by product id
    public List<Review> getReviewsByProductId(String productId) {
        List<Review> reviews = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM reviews WHERE product_id = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, productId);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Review review = new Review(rs.getInt("stars"), rs.getString("comment"),
                            rs.getString("product_id"));
                    reviews.add(review);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }
        return reviews;
    }

}

