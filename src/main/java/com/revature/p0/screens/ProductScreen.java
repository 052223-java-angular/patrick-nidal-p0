package com.revature.p0.screens;

import com.revature.p0.models.*;
import com.revature.p0.services.CartItemService;
import com.revature.p0.services.CategoryService;
import com.revature.p0.services.RouterService;
import com.revature.p0.services.ProductService;
import lombok.AllArgsConstructor;

import java.util.InputMismatchException;
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

                System.out.println("\nProducts Screen");
                System.out.println("\n[1] Show all products.");
                System.out.println("[2] Search by product name");
                System.out.println("[3] Search products by category.");
                System.out.println("[4] Search products by price range.");
                System.out.println("[x] Exit");

                System.out.println("\nEnter choice: ");

                switch (scan.nextLine()) {
                    case "1":
                        List<Product> list = getAllProducts(productService);
                        Product choice =  selectOption(scan, list);
                        System.out.println("Left in Stock " + choice.getOnHand());
                        if (choice.getOnHand() == 0) {
                            System.out.println("No products left in the stock!");
                            break;
                        }
                        int quantity = determineQuantity(scan, choice.getOnHand());


                        addSelectedItemToCart(choice, session.getCartId(), quantity);

                        System.out.println("Item added to cart successfully!");
                        optionForMainMenu(router, scan);
                        break exit;
                    case "2":
                        List<Product> nameList = getProductByName(productService, scan);
                        Product choice2 =  selectOption(scan, nameList);
                        System.out.println("Left in Stock " + choice2.getOnHand());
                        int quantity2 = determineQuantity(scan, choice2.getOnHand());
                        addSelectedItemToCart(choice2, session.getCartId(), quantity2);

                        System.out.println("Item added to cart successfully!");
                        optionForMainMenu(router, scan);
                        break exit;
                    case "3":
                        provideCategories(categoryService);
                        System.out.println("Select a Category: ");
                        String category = scan.nextLine();
                        int counter5 = 1;
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
                        optionForMainMenu(router, scan);
                        break exit;
                    case "4":
                        System.out.println("Product in price range: ");
                        System.out.println("Enter the low price: ");
                        double low = scan.nextDouble();
                        System.out.println("Enter the high price: ");
                        double high = scan.nextDouble();

                        List<Product> priceRangeList = getProductByPriceRange(productService, low, high);

                        Product choice4 =  selectOption(scan, priceRangeList);
                        System.out.println("Left in Stock " + choice4.getOnHand());
                        int quantity6 = determineQuantity(scan, choice4.getOnHand());
                        addSelectedItemToCart(choice4, session.getCartId(), quantity6);

                        System.out.println("Item added to cart successfully!");
                        optionForMainMenu(router, scan);
                        break exit;
                    case "x":
                        break exit;
                    default:
                        System.out.println("Invalid Option! ");
                        System.out.println("Press ENTER to continue..");
                        scan.nextLine();
                }

            }

    }


    //----Helper Methods----
    private List<Product> getAllProducts(ProductService productService){

        System.out.println("Available products: ");
        int counter = 1;
        List<Product> list = productService.getAllProducts();
        for(Product product : list) {
            System.out.println("Press " + counter + " for " + product.getDescription());
            counter++;
        }

        return list;
    }

    private List<Product> getProductByName(ProductService productService, Scanner scan) {
        System.out.println("Enter Product name : ");
        String productName = scan.nextLine();
        int counter2 = 1;
        List<Product> list2 = productService.getProductByName(productName);
        for(Product product : list2) {
            System.out.println("press " + counter2 + " for " + product.getId());
            counter2++;
        }
        return list2;
    }

    private void provideCategories(CategoryService categoryService) {
        System.out.println("Products by category: ");
        int counter3 = 1;
        List<Category> list3 = categoryService.getAllCategories();
        for(Category category : list3) {
            System.out.println("press " + counter3 + " for " + category.getName());
            counter3++;
        }
    }

    private List<Product> getProductByPriceRange(ProductService productService, double low, double high) {
        int counter4 = 1;
        List<Product> list4 = productService.getProductByPriceRange(low, high);
        for(Product product : list4) {
            System.out.println("press " + counter4 + " for " + product.getId());
            counter4++;
        }
        return list4;
    }


    private Product selectOption(Scanner scan, List<Product> list) {

        int userChoice = selectNumber(scan);
        scan.nextLine();
        Product productChoice = list.get(userChoice - 1);
        System.out.println(productChoice.getId());

        return productChoice;
    }

    private int selectNumber(Scanner scan) {
        while(true) {
            System.out.println("Select a product: ");
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice.");
                scan.nextLine();
            }
        }
    }



    private int determineQuantity(Scanner scan, int onHand) {
        while (true) {
            int amount = selectQuantity(scan, onHand);
            if (amount <= onHand && amount >= 0) {
                System.out.println("You've selected " + amount);
                return amount;
            }
            System.out.println("Invalid Amount");
            //might need a scan.nextLine here
            scan.nextLine();
        }
    }

    private int selectQuantity(Scanner scan, int onHand) {
        while(true) {
            System.out.println("Quantity in stock: " + onHand);
            System.out.println("Enter Quantity: ");
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice.");
                scan.nextLine();
            }
        }
    }

    private void addSelectedItemToCart(Product product, String cartId, int quantity) {
        CartItems cartItems = new CartItems(quantity, quantity * product.getPrice(),
                product.getId(), cartId);
        cartItemService.insertItems(cartItems);
    }

    private void optionForMainMenu(RouterService router, Scanner scan) {
        System.out.println("[1] Back to main menu");
        scan.nextLine();

        switch(scan.nextLine()) {
            case "1":
                router.navigate("/main", scan);
            default:
                break;
        }
    }


}
