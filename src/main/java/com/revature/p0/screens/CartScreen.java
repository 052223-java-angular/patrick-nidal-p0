package com.revature.p0.screens;

import com.revature.p0.models.CartItems;
import com.revature.p0.models.Product;
import com.revature.p0.models.Session;
import com.revature.p0.models.User;
import com.revature.p0.services.CartItemService;
import com.revature.p0.services.ProductService;
import com.revature.p0.services.RouterService;
import lombok.AllArgsConstructor;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
@AllArgsConstructor

public class CartScreen implements IScreen {
    private final RouterService router;
    private final CartItemService cartService;
    private Session session;
    private final ProductService productService;

    @Override
    public void start(Scanner scan) {
        System.out.println("\nYour Cart Items ");

        List<CartItems> sessionCart = cartService.getAllCartItems(session.getCartId());
        for(CartItems items : sessionCart) {
            System.out.println("cart item: " + items.getProductId());
            System.out.println("item quantity: " + items.getQuantity());
            System.out.println("item price" + items.getPrice());
        }

        System.out.println("Would you like to add or remove items to your cart? Or proceed to checkout?");

        exit: {
            while (true) {
                clearScreen();
                System.out.println("Welcome to the Cart.");
                System.out.println("\n[1] Add Products");
                System.out.println("[2] Remove Products");
                System.out.println("[3] Proceed to checkout");


                switch(scan.nextLine()) {
                    case "1":
                        System.out.println("Redirecting to products.");
                        router.navigate("/product", scan);
                        break exit;
                    case "2":
                        System.out.println("Select products to remove.");
                        List<CartItems> sessionCart2 = cartService.getAllCartItems(session.getCartId());
                        int counter = 1;
                        for(CartItems items : sessionCart2) {
                            System.out.println("press " + counter + " for " + items.getProductId());
                            counter++;
                        }
                        CartItems choice = selectOption(scan, sessionCart2);
                        showRemainingInCart(scan, choice.getQuantity(), choice.getPrice(), choice.getId());
                        scan.nextLine();
                        break;
                    case "3":
                        //helper method to check if items in cart less than on_hand
                        if(!isValidCheckout(productService, sessionCart)) {
                            System.out.println("Invalid checkout.  Please remove items from cart.");
                            break exit;
                        }
                        System.out.println("Redirecting to menu for checkout");
                        router.navigate("/checkout", scan);
                        break exit;
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

    private CartItems selectOption(Scanner scan, List<CartItems> list) {

        int userChoice = selectNumber(scan);
        CartItems productChoice = list.get(userChoice - 1);
        System.out.println(productChoice.getProductId());

        return productChoice;
    }

    private int selectNumber(Scanner scan) {
        while(true) {
            System.out.println("Select a product to remove: ");
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice.");
                scan.nextLine();
            }
        }
    }

    private int showRemainingInCart(Scanner scan, int quantity, double price, String id) {

        while (true) {
            //helper function is just below
            int quantityRemove = quantityRemove(scan, quantity);

            if (quantityRemove <= quantity && quantityRemove >= 0) {
                int quantityChoice = quantity-quantityRemove;
                double newPrice = (price/quantity)*quantityChoice;
                cartService.cartQuantityRemoval(quantityChoice, newPrice, id);
                System.out.println("Removal success.  New quantity is " + quantityChoice + " and price is: " + newPrice);
                return quantityChoice;
            }
            System.out.println("Invalid Amount");
            scan.nextLine();
        }

    }

    private int quantityRemove(Scanner scan, int quantity) {
        while(true) {
            System.out.println("How many to remove?  Currently " + quantity + " in cart.");
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Select an integer.");
                scan.nextLine();
            }
        }
    }

    private boolean isValidCheckout(ProductService productService, List<CartItems> sessionCart) {
        return productService.isValidCheckout(sessionCart);
    }

    public void clearScreen() {
        //ANSI escape code - controls cursor position
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
