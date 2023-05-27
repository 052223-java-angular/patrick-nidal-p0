package com.revature.p0.daos;

import com.revature.p0.models.Product;
import com.revature.p0.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements CrudDAO {

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
    public List<Product> findAll() {
        return null;
    }



    public List<Product> findProductByCategory(String categoryId) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            List<Product> products = new ArrayList<>();
            String sql = "SELECT * FROM products WHERE category_id = ?";


            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, categoryId);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Product product = new Product(rs.getString(2), );
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
