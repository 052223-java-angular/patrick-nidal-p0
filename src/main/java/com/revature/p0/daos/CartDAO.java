package com.revature.p0.daos;

import com.revature.p0.models.Cart;
import com.revature.p0.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartDAO {

    public boolean createCart(Cart cart) {
        boolean isCreated = false;
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO cart (id, account_id) VALUES (?, ?)";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cart.getId());
                ps.setString(2, cart.getAccountId());

                isCreated = ps.executeUpdate() == 1;
            }

        } catch(SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch(IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }
        return isCreated;
    }

    public String getCartId(String accountId) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM cart WHERE account_id = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, accountId);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    return rs.getString("id");
                }
            }

        } catch(SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch(IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }
        return null;
    }


}
