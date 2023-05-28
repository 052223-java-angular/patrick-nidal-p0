package com.revature.p0.screens;

import com.revature.p0.models.CartItems;
import com.revature.p0.models.Product;
import com.revature.p0.models.Session;
import com.revature.p0.models.User;
import com.revature.p0.services.CartItemService;
import com.revature.p0.services.ProductService;
import com.revature.p0.services.RouterService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;
@AllArgsConstructor

public class CartScreen implements IScreen {
    private final RouterService router;
    private final CartItemService cartService;
    private Session session;

    @Override
    public void start(Scanner scan) {
        System.out.println("Your Cart Items ");

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
                System.out.println("Welcome to MainMenu.");
                System.out.println("\n[1] Add Products");
                System.out.println("[2] Remove Products");
                System.out.println("[3] Proceed to checkout");


                switch(scan.nextLine()) {
                    case "1":
                        System.out.println("Redirecting to products.");
                        router.navigate("/product", scan);
                        break exit;
                    case "2":
                        System.out.println("which products to remove");
                        //print cart, select product, remove quantity
                        List<CartItems> sessionCart2 = cartService.getAllCartItems(session.getCartId());
                        int counter = 1;
                        for(CartItems items : sessionCart2) {
                            System.out.println("press " + counter + " for " + items.getProductId());
                            counter++;
                        }
                        CartItems choice = selectOption(scan, sessionCart2);
                        showRemainingInCart(scan, choice.getQuantity(), choice.getPrice(), choice.getId());
                        break;
                    case "3":
                        System.out.println("Redirecting to menu for checkout");
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

        System.out.println("select a product to remove: ");
        int userChoice = scan.nextInt();
        CartItems productChoice = list.get(userChoice);
        System.out.println(productChoice.getProductId());

        return productChoice;
    }

    private int showRemainingInCart(Scanner scan, int quantity, double price, String id) {

        while (true) {
            System.out.println("How many to remove?  Currently " + quantity + " in cart.");
            int quantityRemove = scan.nextInt();
            if (quantityRemove <= quantity && quantityRemove >= 0) {
                int quantityChoice = quantity-quantityRemove;
                double newPrice = price-((price/quantity)*quantityChoice);
                cartService.cartQuantityRemoval(quantityChoice, newPrice, id);
                System.out.println("Removal success.  New quantity is " + quantityChoice + " and price is: " + newPrice);
                return quantityChoice;
            }
            System.out.println("Invalid Amount");
        }

    }

    public void clearScreen() {
        //ANSI escape code - controls cursor position
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
