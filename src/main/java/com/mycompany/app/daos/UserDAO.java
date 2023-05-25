package com.mycompany.app.daos;

import com.mycompany.app.models.User;
import com.mycompany.app.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;

public class UserDAO {

    public void save(User user) {
        try(Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO account(user_id, username, password, role_id) VALUES(?, ?, ?, ?)";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, user.getId());
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getRoleId());
                ps.executeUpdate();
            }

        } catch(SQLException e) {
            throw new RuntimeException("Unable to connect to db");
        }
    }
}
