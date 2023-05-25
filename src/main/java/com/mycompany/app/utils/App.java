package com.mycompany.app.utils;

import com.mycompany.app.services.RouterService;
import com.mycompany.app.models.Session;
import java.util.Scanner;

public class App {
  public static void main(String args[]) {
    System.out.println("Welcome to eCommerce App!");
    Scanner scanner = new Scanner(System.in);
    RouterService router = new RouterService(new Session());
    router.navigate("/home", scanner);
    scanner.close();

  }
}
