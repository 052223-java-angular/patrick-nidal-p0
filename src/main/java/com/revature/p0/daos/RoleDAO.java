package com.revature.p0.daos;

import com.revature.p0.models.Role;
import com.revature.p0.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;

public class RoleDAO implements CrudDAO<Role> {

    @Override
    public void save(Role role) {

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Role findById(String id) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }
}
