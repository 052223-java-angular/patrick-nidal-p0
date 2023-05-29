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
                System.out.println("Welcome to the register screen.");

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

                        //set session ids and bypass log in screen if successful registration
                        session.setSession(createdUser);
                        session.setCartId(userService.createCart(createdUser.getId()));
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

            //check usernames for validity and uniqueness
            if(!userService.validUsername(username)) {
                System.out.println("\nUsername needs to be between 4-20 characters.");
                System.out.print("Press ENTER to try another username.");
                scan.nextLine();
                continue;
            }

            if(!userService.uniqueUsername(username)) {
                System.out.println("\nUsername is not unique.");
                System.out.print("Press ENTER to try another username.");
                scan.nextLine();
                continue;
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

            //check passwords for validity and ask for confirmation
            if(!userService.validPassword(password)) {
                System.out.println("Username needs to be between 4-20 characters.");
                System.out.print("Press ENTER to try another username.");
                scan.nextLine();
                continue;
            }

            System.out.println("Please confirm password (x to cancel): ");
            confirmPassword = scan.nextLine();
            if(confirmPassword.equalsIgnoreCase("x")) {
                return "x";
            }
            if(!userService.matchPasswordCheck(password, confirmPassword)) {
                System.out.println("Chosen passwords do not match");
                System.out.print("Press ENTER to try another username.");
                scan.nextLine();
                continue;
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
