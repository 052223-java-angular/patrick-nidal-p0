package com.revature.p0.screens;

import com.revature.p0.services.RouterService;
import com.revature.p0.services.UserService;
import com.revature.p0.models.User;
import com.revature.p0.models.Session;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class RegisterScreen {
    private final RouterService router;
    private final UserService userService;
    private Session session;

    public void start(Scanner scan) {
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
                System.out.println("Password: " + password);
                System.out.println("\nEnter (y/n): ");

                switch(scan.nextLine()) {
                    case "y":
                        User createdUser = userService.register(username, password);
                        session.setSession(createdUser);
                        router.navigate("/menu", scan);
                        break exit;
                    case "n":
                        clearScreen();
                        System.out.println("Restarting..");
                        System.out.println("\nPress enter to continue..");
                        scan.nextLine();
                        break;
                    default:
                        clearScreen();
                        System.out.println("Invalid options");
                        System.out.println("Press enter to continue..");
                        scan.nextLine();
                        break;
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
