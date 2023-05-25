package com.mycompany.app.screens;

import com.mycompany.app.services.RouterService;
import com.mycompany.app.services.UserService;
import com.mycompany.app.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class RegisterScreen {
    private final RouterService router;
    private final UserService userService;

    public void start(Scanner scan) {
        String input = "";
        String username = "";
        String password = "";

        exit: {
            while(true) {
                clearScreen();
                System.out.println("Welcome to the register screen!");

                username = getUsername(scan);

                if(username.equals("x")) {
                    break exit;
                }

                password = getPassword(scan);

                if(password.equals("x")) {
                    break exit;
                }

                clearScreen();
                System.out.println("Please confirm your credentials:");
                System.out.println("\nUsername: " + username);
                System.out.println("\nEnter (y/n): ");

                switch(scan.nextLine()) {
                    case "y":
                        User createdUser = userService.register(username, password);
                        router.navigate("/menu", scan);
                        break exit;
                }

                break exit;


            }
        }

    }

    public String getUsername(Scanner scan) {
        String username = "";

        while(true) {
            System.out.print("\nEnter a username (x to cancel): ");
            username = scan.nextLine();

            if(username.equalsIgnoreCase("x")) {
                return "x";
            }

            break;
        }

        return username;

    }

    public String getPassword(Scanner scan) {
        String password = "";
        String confirmPassword = "";

        while(true) {
            System.out.print("\nEnter a password (x to cancel): ");
            password = scan.nextLine();

            break;
        }

        return password;
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
