package com.mycompany.app.utils;

import java.util.Properties;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.InputStream;
import java.io.IOException;

public class ConnectionFactory {

    //need to use connection factory code
    //used this code to keep connection simple
    //entire class can be removed, just need to update DAO code

    private static Connection conn;
    static String url = "jdbc:postgresql://localhost:5432/";
    static String user = "postgres";
    static String pass = "newyorkheart";

    public static Connection getConnection() {
        if(conn == null) {
            establishNewConnection();
        }
        return conn;
    }

    private static void establishNewConnection() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch(SQLException eSQL) {
            System.out.println("Error establishing connection: \n" + eSQL.getMessage());
        }
    }

}
