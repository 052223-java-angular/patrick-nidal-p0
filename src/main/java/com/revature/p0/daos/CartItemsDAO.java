package com.revature.p0.daos;

import com.revature.p0.models.CartItems;
import com.revature.p0.models.Order;
import com.revature.p0.models.Product;
import com.revature.p0.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartItemsDAO implements CrudDAO<CartItems> {

    @Override
    public void save(CartItems cartItems) {

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public CartItems findById(String id) {
        return null;
    }

    @Override
    public List<CartItems> findAll() {
        return null;
    }



    public boolean createCartItems(CartItems cartItems) {
        boolean success = false;
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO cart_items (id, quantity, price, product_id, cart_id) VALUES (?, ?, ?, ?, ?)";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cartItems.getId());
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

    public List<CartItems> findAllByCartId(String cartId) {
        List<CartItems> cartItems = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM cart_items WHERE cart_id = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cartId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    CartItems cart = new CartItems(rs.getInt("quantity") , rs.getDouble("price"),
                            rs.getString("product_id"), rs.getString("getCartId"));
                    cartItems.add(cart);
                }
            }

        } catch(SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch(IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }

        return cartItems;

    }

    public boolean cartQuantityRemoval(int quantityChoice, double price, String cartId) {
        boolean removalSuccess = false;
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "UPDATE cart_items SET quantity = ? AND price = ? WHERE id = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, quantityChoice);
                ps.setDouble(2, price);
                ps.setString(3, cartId);

                removalSuccess = ps.executeUpdate() == 1;
            }
        } catch(SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch(IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }
        return removalSuccess;
    }
}
