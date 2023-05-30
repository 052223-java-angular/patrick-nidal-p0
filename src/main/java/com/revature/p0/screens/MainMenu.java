package com.revature.p0.screens;

import com.revature.p0.models.Session;
import com.revature.p0.services.RouterService;
import java.util.Scanner;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@AllArgsConstructor
public class MainMenu implements IScreen {
    private static final Logger logger = LogManager.getLogger(MainMenu.class);
    private final RouterService router;
    private Session session;

    @Override
    public void start(Scanner scan) {
        String input = "";

        logger.info("Start of main menu.");

        exit: {
            while(true) {
                clearScreen();
                System.out.println("Welcome to main menu: "+ session.getUsername());
                System.out.println("\n[1] Products");
                System.out.println("[2] Cart");
                System.out.println("[3] Orders");
                System.out.println("[4] Reviews");
                System.out.println("[x] Exit");

                System.out.print("\nEnter:");

                input = scan.nextLine();

                switch(input.toLowerCase()) {
                    case "1":
                        router.navigate("/product", scan);
                        break;
                    case "2":
                        router.navigate("/cart", scan);
                        break;
                    case "3":
                        router.navigate("/order", scan);
                        break;
                    case "4":
                        router.navigate("/review", scan);
                        break;
                    case "x":
                        System.out.println("\nSigning out.");
                        break exit;
                    default:
                        clearScreen();
                        System.out.println("Invalid option!");
                        System.out.println("\nPress ENTER to continue..");
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
