package com.revature.p0;

import com.revature.p0.services.RouterService;
import com.revature.p0.models.Session;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

  private static final Logger logger = LogManager.getLogger(App.class);
  public static void main(String args[]) throws SQLException, IOException, ClassNotFoundException {
    logger.info("-------------START APPLICATION-------------");

    System.out.println("Welcome to eCommerce App!");
    Scanner scanner = new Scanner(System.in);
    RouterService router = new RouterService(new Session());
    router.navigate("/home", scanner);

    logger.info("-------------END APPLICATION-------------");

    scanner.close();
  }
}
