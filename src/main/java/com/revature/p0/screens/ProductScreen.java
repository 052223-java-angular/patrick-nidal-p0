package com.revature.p0.screens;

import com.revature.p0.models.*;
import com.revature.p0.services.CartItemService;
import com.revature.p0.services.CategoryService;
import com.revature.p0.services.RouterService;
import com.revature.p0.services.ProductService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class ProductScreen implements IScreen{

    private final RouterService router;
    private final ProductService productService;
    private Session session;
    private final CartItemService cartItemService;
    private final CategoryService categoryService;

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

                        addSelectedItemToCart(choice, session.getCartId(), quantity);

                        System.out.println("Item added to cart successfully!");
                        System.out.println("[1] Back to main menu");
                        System.out.println("[x] To Exit");
                        switch (scan.nextLine()) {
                            case "1":
                                router.navigate("/main", scan);
                                break;
                            case "x":
                                break exit;
                        }
                        System.out.println("\nEnter: ");
                        scan.nextLine();
                        break;
                    case 2:
                        System.out.println("Enter Product name : ");
                        scan.nextLine();
                        String productName = scan.nextLine();
                        int counter2 = 1;
                        List<Product> list2 = productService.getProductByName(productName);
                        for(Product product : list2) {
                            System.out.println("press " + counter2 + " for " + product.getId());
                            counter2++;
                        }


                        Product choice2 =  selectOption(scan, list2);
                        System.out.println("Left in Stock " + choice2.getOnHand());
                        int quantity2 = determineQuantity(scan, choice2.getOnHand());
                        addSelectedItemToCart(choice2, session.getCartId(), quantity2);

                        System.out.println("Item added to cart successfully!");
                        System.out.println("[1] Back to main menu");
                        System.out.println("[x] To Exit");

                        switch(scan.nextLine()) {
                            case "1":
                                router.navigate("/main", scan);
                            case "x":
                                break exit;
                        }
                        break;
                    case 3:
                        System.out.println("Products by category: ");
                        int counter3 = 1;
                        List<Category> list3 = categoryService.getAllCategories();
                        for(Category category : list3) {
                            System.out.println("press " + counter3 + " for " + category.getName());
                            counter3++;
                        }

                        System.out.println("Select a Category: ");
                        int counter5 = 1;
                        scan.nextLine();
                        String category = scan.nextLine();
                        List<Product> categoryProducts = productService.getProductByCategory(category);
                        for (Product product : categoryProducts) {
                            System.out.println("Press" + counter5 + " for " + product.getId());
                            counter5++;
                        }
                        Product productCategoryChoice = selectOption(scan, categoryProducts);
                        System.out.println("Left in Stock " + productCategoryChoice.getOnHand());
                        int quantity4 = determineQuantity(scan, productCategoryChoice.getOnHand());
                        addSelectedItemToCart(productCategoryChoice, session.getCartId(), quantity4);

                        System.out.println("Item added to cart successfully!");
                        System.out.println("[1] Back to main menu");
                        System.out.println("[x] To Exit");
                        scan.nextLine();

                        switch(scan.nextLine()) {
                            case "1":
                                router.navigate("/main", scan);
                            case "x":
                                break exit;
                        }
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
                            System.out.println("press " + counter4 + " for " + product.getId());
                            counter4++;
                        }

                        Product choice4 =  selectOption(scan, list4);
                        System.out.println("Left in Stock " + choice4.getOnHand());
                        int quantity6 = determineQuantity(scan, choice4.getOnHand());
                        addSelectedItemToCart(choice4, session.getCartId(), quantity6);

                        System.out.println("Item added to cart successfully!");
                        System.out.println("[1] Back to main menu");
                        System.out.println("[x] To Exit");
                        scan.nextLine();

                        switch(scan.nextLine()) {
                            case "1":
                                router.navigate("/main", scan);
                            case "x":
                                break exit;
                        }

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
        Product productChoice = list.get(userChoice - 1);
        System.out.println(productChoice.getId());

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

    private void addSelectedItemToCart(Product product, String cartId, int quantity) {
        CartItems cartItems = new CartItems(quantity, quantity * product.getPrice(),
                product.getId(), cartId);
        cartItemService.insertItems(cartItems);

    }


}
