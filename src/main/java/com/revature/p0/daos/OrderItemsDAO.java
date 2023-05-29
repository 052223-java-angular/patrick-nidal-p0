package com.revature.p0.daos;

import com.revature.p0.utils.ConnectionFactory;
import com.revature.p0.models.OrderItems;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemsDAO {

    public void createOrderItems(OrderItems orderItems) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO cart_items (id, quantity, order_id, product_id) VALUES (?, ?, ?, ?)";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, orderItems.getId());
                ps.setInt(2, orderItems.getQuantity());
                ps.setString(3, orderItems.getOrderId());
                ps.setString(4, orderItems.getProductId());

                ps.executeUpdate();
            }

        } catch(SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch(IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }
    }

}
