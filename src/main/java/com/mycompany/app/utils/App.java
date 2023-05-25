package com.mycompany.app.utils;

import com.mycompany.app.screens.*;
import com.mycompany.app.services.RouterService;
import java.util.Scanner;

public class App {
  public static void main(String args[]) {

    System.out.println("Welcome to eCommerce App!");
    Scanner scanner = new Scanner(System.in);
    RouterService router = new RouterService();
    router.navigate("/home", scanner);
    scanner.close();

  }
}
