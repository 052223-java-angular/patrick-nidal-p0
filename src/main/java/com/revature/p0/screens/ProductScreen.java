package com.revature.p0.screens;

import com.revature.p0.models.CartItems;
import com.revature.p0.models.Product;
import com.revature.p0.services.CartItemService;
import com.revature.p0.services.RouterService;
import com.revature.p0.services.ProductService;
import com.revature.p0.models.Session;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class ProductScreen implements IScreen{

    private final RouterService router;
    private final ProductService productService;
    private Session session;
    private final CartItemService cartItemService;

    @Override
    public void start(Scanner scan) {


        exit:
            while(true) {

                System.out.println("Products Screen");
                System.out.print("\n[1] Show all products.");
                System.out.print("\n[2] Search by product name");
                System.out.print("\n[3] Search product by category.");
                System.out.print("\n[4] search product by price range.");

                System.out.println("\nEnter: ");

                switch (scan.nextInt()) {
                    case 1:
                        System.out.println("Available products: ");
                        int counter = 1;
                        List<Product> list = productService.getAllProducts();
                        for(Product product : list) {
                            System.out.println("press " + counter + " for " + product.getDescription());
                            counter++;
                        }
                        Product choice =  selectOption(scan, list);
                        System.out.println("Left in Stock " + choice.getOnHand());
                        int quantity = determineQuantity(scan, choice.getOnHand());
                        double price = quantity * choice.getPrice();
                        CartItems cartItems = new CartItems(quantity, quantity * choice.getPrice(),
                                choice.getName(), session.getCartId());
                        cartItemService.insertItems(cartItems);
                        break;
                    case 2:
                        System.out.println("Enter Product name : ");
                        scan.nextLine();
                        String productName = scan.nextLine();
                        int counter2 = 1;
                        List<Product> list2 = productService.getProductByName(productName);
                        for(Product product : list2) {
                            System.out.println("press " + counter2 + " for " + product.getName());
                            counter2++;
                        }

                        selectOption(scan, list2);
                        Product choice2 =  selectOption(scan, list2);
                        System.out.println("Left in Stock " + choice2.getOnHand());
                        determineQuantity(scan, choice2.getOnHand());
                        break;
                    case 3:
                        System.out.println("Products by category: ");
                        int counter3 = 1;
                        scan.nextLine();
                        String category = scan.nextLine();
                        List<Product> list3 = productService.getProductByCategory(category);
                        for(Product product : list3) {
                            System.out.println("press " + counter3 + " for " + product.getDescription());
                            counter3++;
                        }
                        selectOption(scan, list3);
                        Product choice3 =  selectOption(scan, list3);
                        System.out.println("Left in Stock " + choice3.getOnHand());
                        determineQuantity(scan, choice3.getOnHand());
                        break;
                    case 4:
                        System.out.println("Product in price range: ");
                        int counter4 = 1;
                        System.out.println("Enter the low price: ");
                        double low = scan.nextDouble();
                        System.out.println("Enter the high price: ");
                        double high = scan.nextDouble();
                        List<Product> list4 = productService.getProductByPriceRange(low, high);
                        for(Product product : list4) {
                            System.out.println("press " + counter4 + " for " + product.getDescription());
                            counter4++;
                        }
                        selectOption(scan, list4);
                        Product choice4 =  selectOption(scan, list4);
                        System.out.println("Left in Stock " + choice4.getOnHand());
                        determineQuantity(scan, choice4.getOnHand());
                        break;
                    default:
                        System.out.println("Invalid Option! ");
                        System.out.println("Press Enter to continue");
                        scan.nextLine();
                }



                //product service
                //search by name, category, price range

                //switch(scan.nextLine()) {
                    // 1. view all products
                    // 2. search products
                    // invalid choice
                //}

                break;
            }

    }


    //Helper Methods
    private void getAllProducts(Scanner scan){

        System.out.println("Available products: ");
        int counter = 1;
        List<Product> list = productService.getAllProducts();
        for(Product product : list) {
            System.out.println("press " + counter + " for " + product.getDescription());
            counter++;
        }
    }



    private Product selectOption(Scanner scan, List<Product> list) {

        System.out.println("select a product: ");
        int userChoice = scan.nextInt();
        Product productChoice = list.get(userChoice);
        System.out.println(productChoice.getDescription());

        return productChoice;
    }

    private int determineQuantity(Scanner scan, int onHand) {
        while (true) {
            System.out.println("Quantity in stock: " + onHand);
            System.out.println("Enter Quantity: ");
            int amount = scan.nextInt();
            if (amount <= onHand && amount >= 0) {
                return amount;
            }
            System.out.println("Invalid Amount");
        }
    }


}
