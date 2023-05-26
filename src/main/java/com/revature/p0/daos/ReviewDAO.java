package com.revature.p0.daos;

import com.revature.p0.models.Review;
import com.revature.p0.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;

public class ReviewDAO implements CrudDAO<Review> {
    @Override
    public void save(Review review) {

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Review findById(String id) {
        return null;
    }

    @Override
    public List<Review> findAll() {
        return null;
    }
}
