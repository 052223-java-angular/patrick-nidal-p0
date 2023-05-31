package com.revature.p0.screens;

import com.revature.p0.models.CartItems;
import com.revature.p0.models.Order;
import com.revature.p0.models.Session;
import com.revature.p0.models.User;
import com.revature.p0.services.CartItemService;
import com.revature.p0.services.OrderService;
import com.revature.p0.services.ProductService;
import com.revature.p0.services.RouterService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CheckoutScreen {

    private final RouterService router;
    private final OrderService orderService;
    private Session session;
    private final CartItemService cartItemService;
    private final ProductService productService;

    public CheckoutScreen(RouterService router, OrderService orderService, Session session, CartItemService cartItemService, ProductService productService) {
        this.router = router;
        this.orderService = orderService;
        this.session = session;
        this.cartItemService = cartItemService;
        this.productService = productService;
    }

    public void start(Scanner scan) {

        System.out.println("\nWelcome to payment processing.");

        System.out.println("\nConfirm cart items: ");

        List<CartItems> sessionCart = cartItemService.getAllCartItems(session.getCartId());
        for(CartItems items : sessionCart) {
            System.out.println("Product: " + items.getProductId());
            System.out.println("Quantity: " + items.getQuantity());
            System.out.println("Price $" + items.getPrice());
        }

        double total_sum = orderService.returnTotal(session.getCartId());

        System.out.println("\nTotal for your order is: $" + total_sum);

        System.out.println("\nConfirm Purchase ?");



        exit: {
            while(true) {
                clearScreen();
                System.out.print("\nEnter (y/n): ");

                switch(scan.nextLine()) {
                    case "y":
                        //process payment helper function
                        double balance = secureCheckout(total_sum, scan);
                        //create order and return orderId
                        String orderId = orderService.createOrder(total_sum, session.getId()).getId();
                        //store order items for order history
                        orderService.createOrderItems(sessionCart, orderId);
                        //remove on_hand items that were purchased from products table and account cart
                        removeFromOnHand(session.getCartId(), sessionCart, cartItemService, productService);
                        System.out.println("Checkout processed.");
                        System.out.println("Your balance is. " + balance);
                        scan.nextLine();
                        router.navigate("/order", scan);
                        break exit;
                    case "n":
                        clearScreen();
                        router.navigate("/cart", scan);
                        break;
                    default:
                        clearScreen();
                        System.out.println("Invalid option");
                        break;
                }

                break exit;

            }
        }

    }

    private double secureCheckout(double sum, Scanner scan) {

        while(true) {
            System.out.println("Enter the payment amount in format($xx.xx)");

            try {
                double userAmount = scan.nextDouble();
                if (userAmount >= sum) {
                    return userAmount-sum;
                } else {
                    System.out.println("Not enough.");
                    scan.nextLine();
                }

            } catch (InputMismatchException e) {
                scan.nextLine();
            }
        }
    }

    public void removeFromOnHand(String sessionCartId, List<CartItems> sessionCart, CartItemService cartItemService, ProductService productService) {
        productService.removeItemsFromOnHand(sessionCart);
        cartItemService.removeItemsFromCart(sessionCartId);
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
