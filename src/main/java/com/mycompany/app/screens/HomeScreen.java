package com.mycompany.app.screens;

import com.mycompany.app.services.RouterService;
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
                System.out.println("Welcome to ecommerce site");
                System.out.println("\n[1] Login screen");
                System.out.println("[2] register screen");
                System.out.println("[x] Exit");

                System.out.print("\nEnter:");

                input = scan.nextLine();

                switch(input.toLowerCase()) {
                    case "1":
                        System.out.println("for log in");
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
