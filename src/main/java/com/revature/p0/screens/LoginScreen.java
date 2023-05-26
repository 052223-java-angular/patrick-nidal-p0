package com.revature.p0.screens;

import com.revature.p0.models.User;
import com.revature.p0.services.RouterService;
import com.revature.p0.models.Session;
import java.util.Scanner;

import com.revature.p0.services.UserService;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class LoginScreen implements IScreen {
    private RouterService router;
    private final UserService userService;


    public void start(Scanner scan) {
        String username = "";
        String password = "";

        exit: {
            while(true) {
                clearScreen();
                //if have session as instance variable can add username to print statement
                System.out.println("Welcome to the login screen");

                username = getUsername(scan);

                if(username.equals("x")) {
                    break exit;
                }

                password = getPassword(scan);

                if(password.equals("x")) {
                    break exit;
                }
                break;

            }
        }

        //add ROLE later
        //maybe make optional class and determine if a user exists
        User validUser = userService.login(username, password);

        //set role for router service
        //begin new session and send back to router?
        Session beginSession = new Session("returnStringId", validUser.getUsername());

        router.navigate("/menu", scan);
        //router.navigate("/menu", scan, beginSession);

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
