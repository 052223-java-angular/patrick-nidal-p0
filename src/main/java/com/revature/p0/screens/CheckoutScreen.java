package com.revature.p0.screens;

import com.revature.p0.models.CartItems;
import com.revature.p0.models.Order;
import com.revature.p0.models.Session;
import com.revature.p0.models.User;
import com.revature.p0.services.CartItemService;
import com.revature.p0.services.OrderService;
import com.revature.p0.services.ProductService;
import com.revature.p0.services.RouterService;

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

        System.out.println("Welcome to payment processing.");

        System.out.println("Confirm cart items: ");

        List<CartItems> sessionCart = cartItemService.getAllCartItems(session.getCartId());
        for(CartItems items : sessionCart) {
            System.out.println("cart item: " + items.getProductId());
            System.out.println("item quantity: " + items.getQuantity());
            System.out.println("item price" + items.getPrice());
        }

        double total_sum = orderService.returnTotal(session.getCartId());

        System.out.println("Total for your order is: " + total_sum);

        System.out.println("\nEnter (y/n) to confirm purchase: ");

        exit: {
            while(true) {
                clearScreen();

                System.out.println("\nEnter (y/n): ");

                switch(scan.nextLine()) {
                    case "y":
                        //process payment helper function
                        double balance = secureCheckout(total_sum, scan);
                        orderService.createOrder(total_sum, session.getId());

                        //remove on_hand items that were purchased from products table
                        removeFromOnHand(sessionCart, cartItemService, productService);

                        System.out.println("your balance is. " + balance);

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
            double userAmount = scan.nextDouble();
            if(userAmount >= sum) {
                return userAmount-sum;
            }
        }
    }

    public void removeFromOnHand(List<CartItems> sessionCart, CartItemService cartItemService, ProductService productService) {
        productService.removeItemsFromOnHand(sessionCart);
        cartItemService.removeItemsFromCart(sessionCart);
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
