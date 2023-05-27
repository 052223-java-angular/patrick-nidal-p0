package com.revature.p0.utils;

import java.util.Properties;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.InputStream;
import java.io.IOException;

public class ConnectionFactory {

    private static ConnectionFactory instance;
    private Connection connection;

    private ConnectionFactory() throws IOException, SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Properties props = getProperties();
        connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"),
                props.getProperty("password"));
    }

    public static ConnectionFactory getInstance() throws ClassNotFoundException, IOException, SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    private Properties getProperties() throws IOException {
        Properties props = new Properties();

        try (InputStream iStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (iStream == null) {
                throw new IOException("Unable to find application.properties");
            }
            props.load(iStream);
        }

        return props;
    }
}
