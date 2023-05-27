package com.revature.p0;

import com.revature.p0.services.RouterService;
import com.revature.p0.models.Session;
import com.revature.p0.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
  public static void main(String args[]) throws SQLException, IOException, ClassNotFoundException {
    System.out.println("Welcome to eCommerce App!");
    Scanner scanner = new Scanner(System.in);
    RouterService router = new RouterService(new Session());
    router.navigate("/home", scanner);
    scanner.close();
  }
}
