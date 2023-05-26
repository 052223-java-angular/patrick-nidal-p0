package com.revature.p0.daos;

import com.revature.p0.models.Order;
import com.revature.p0.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;

public class OrderDAO implements CrudDAO<Order> {


    @Override
    public void save(Order order) {

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Order findById(String id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
