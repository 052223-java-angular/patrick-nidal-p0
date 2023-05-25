package com.mycompany.app.daos;

import com.mycompany.app.models.User;
import com.mycompany.app.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;

public class UserDAO implements CrudDAO {

    public void save(User user) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO account (user_id, username, password) VALUES (?, ?, ?)";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, user.getId());
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getPassword());
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
