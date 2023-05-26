package com.revature.p0.daos;

import com.revature.p0.models.User;
import com.revature.p0.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;

public class UserDAO implements CrudDAO<User> {

    public void save(User user) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO accounts (id, username, password, role_id) VALUES (?, ?, ?, ?)";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, user.getId());
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getRoleId());
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

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
