package com.revature.p0.screens;

import com.revature.p0.models.Session;
import com.revature.p0.services.RouterService;
import java.util.Scanner;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MainMenu implements IScreen {
    //use session for menu navigation
    private final RouterService router;
    private Session session;

    @Override
    public void start(Scanner scan) {
        String input = "";

        System.out.println("Welcome to the user menu.  You are logged in." + session.getUsername());

        exit: {
            while(true) {
                clearScreen();
                System.out.println("Welcome to eCommerce site - Home.");
                System.out.println("\n[1] Orders");
                System.out.println("[2] Cart");
                System.out.println("[3] Review");
                System.out.println("[x] Exit");

                System.out.print("\nEnter:");

                input = scan.nextLine();

                switch(input.toLowerCase()) {
                    case "1":
                        router.navigate("/orders", scan);
                        break;
                    case "2":
                        router.navigate("/cart", scan);
                        break;
                    case "3":
                        router.navigate("/review", scan);
                        break;
                    case "4":
                        router.navigate("/product", scan);
                        break;
                    case "x":
                        System.out.println("\nGoodbye!");
                        break exit;
                    default:
                        clearScreen();
                        System.out.println("Invalid option!");
                        System.out.println("\nPress enter to continue...");
                        scan.nextLine();

                }

            }
        }
    }

    public void clearScreen() {
        //ANSI escape code - controls cursor position
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
