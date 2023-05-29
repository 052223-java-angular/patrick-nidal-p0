package com.revature.p0.screens;

import com.revature.p0.models.User;
import com.revature.p0.services.RouterService;
import com.revature.p0.models.Session;
import com.revature.p0.services.UserService;
import java.util.Scanner;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginScreen implements IScreen {
    private RouterService router;
    private final UserService userService;
    private Session session;

    public void start(Scanner scan) {
        String username = "";
        String password = "";

        exit: {
            while(true) {
                clearScreen();

                System.out.println("Welcome to the login screen");

                username = getUsername(scan);
                if(username.equals("x")) {
                    break exit;
                }

                password = getPassword(scan);
                if(password.equals("x")) {
                    break exit;
                }
                //add ROLE later
                User isValidUser = userService.login(username, password);
                if(isValidUser == null) {
                    System.out.println("Not a valid username");
                    continue;
                }

                //set session ids and proceed to menu
                session.setSession(isValidUser);
                session.setCartId(userService.getCartId(userService.getAccountId(isValidUser.getUsername())));
                router.navigate("/menu", scan);

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

        while(true) {
            System.out.print("\nEnter a password (x to cancel): ");
            password = scan.nextLine();

            if(password.equalsIgnoreCase("x")) {
                return "x";
            }

            break;
        }

        return password;
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
