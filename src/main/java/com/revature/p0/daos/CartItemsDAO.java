package com.revature.p0.daos;

import com.revature.p0.models.CartItems;
import com.revature.p0.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CartItemsDAO implements CrudDAO {

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    public boolean createCartItems(CartItems cartItems) {
        boolean success = false;
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO cart_items (id, quantity, price, product_id, cart_id) VALUES (?, ?, ?, ?, ?)";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cartItems.getCartId());
                ps.setInt(2, cartItems.getQuantity());
                ps.setDouble(3, cartItems.getPrice());
                ps.setString(4, cartItems.getProductId());
                ps.setString(5, cartItems.getCartId());

                success = ps.executeUpdate() == 1;
            }

        } catch(SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch(IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }
        return success;
    }
}
