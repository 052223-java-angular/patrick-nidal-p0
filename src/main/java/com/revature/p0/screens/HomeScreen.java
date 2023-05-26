package com.revature.p0.screens;

import com.revature.p0.services.RouterService;
import lombok.AllArgsConstructor;
import java.util.Scanner;

@AllArgsConstructor
public class HomeScreen implements IScreen {
    private final RouterService router;

    @Override
    public void start(Scanner scan) {
        String input = "";

        exit: {
            while(true) {
                clearScreen();
                System.out.println("Welcome to eCommerce site - Home.");
                System.out.println("\n[1] Login");
                System.out.println("[2] Register");
                System.out.println("[x] Exit");

                System.out.print("\nEnter:");

                input = scan.nextLine();

                switch(input.toLowerCase()) {
                    case "1":
                        router.navigate("/login", scan);
                        break;
                    case "2":
                        router.navigate("/register", scan);
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
