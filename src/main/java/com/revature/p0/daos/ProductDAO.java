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

        List<Product> products = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM products";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Product product = new Product(rs.getString("name") , rs.getString("description"),
                            rs.getDouble("price"), rs.getInt("on_hand") );
                    products.add(product);
                }
            }

        } catch(SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch(IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }

        return products;
    }





    public List<Product> findProductByCategory(String category) {
        List<Product> products = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM products WHERE category = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, category);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Product product = new Product(rs.getString("name"),
                            rs.getString("description"), rs.getDouble("price"),
                            rs.getInt("on_hand") );
                    products.add(product);
                }
            }

        } catch(SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch(IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }

        return products;
    }

    public List<Product> findProductByName(String name) {
        List<Product> products = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM products WHERE name = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, name);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Product product = new Product(rs.getString("name"), rs.getString("description"),
                            rs.getDouble("price"), rs.getInt("on_hand") );
                    products.add(product);
                }
            }

        } catch(SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch(IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }

        return products;
    }

    public List<Product> findProductByPriceRange(double priceLower, double priceUpper) {
        List<Product> products = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM products WHERE price BETWEEN ? AND ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setDouble(1, priceLower);
                ps.setDouble(2, priceUpper);

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Product product = new Product(rs.getString("name"), rs.getString("description"),
                            rs.getDouble("price"), rs.getInt("on_hand") );
                    products.add(product);
                }
            }

        } catch(SQLException e) {
            throw new RuntimeException("Unable to connect to db", e);
        } catch(IOException e) {
            throw new RuntimeException("Cannot find application.properties", e);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException("Unable to load JDBC driver", e);
        }

        return products;
    }

}
