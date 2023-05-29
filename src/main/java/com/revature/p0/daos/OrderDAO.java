package com.revature.p0.daos;

import com.revature.p0.models.Order;
import com.revature.p0.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {


    public String create(Order order) {
        String orderId = order.getId();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO orders (id, total_cost, account_id) VALUES (?, ?, ?)";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, order.getId());
                ps.setDouble(2, order.getTotal_cost());
                ps.setString(3, order.getAccount_id());
                ps.executeUpdate();
            }

        } catch(SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch(IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }
        return orderId;

    }

    public List<Order> finalAllByAccountId(String account_id) {
        List<Order> orders = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM orders WHERE account_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, account_id);
            }

        } catch(SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch(IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }
        return orders;
    }

}
