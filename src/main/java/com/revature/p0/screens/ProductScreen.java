package com.revature.p0.screens;

import com.revature.p0.models.Product;
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

    @Override
    public void start(Scanner scan) {
        exit:
            while(true) {
                System.out.println("Available products: ");
                int counter = 1;
                List<Product> list = productService.getAllProducts();
                for(Product product : list) {
                    System.out.println("press " + counter + " for " + product.getDescription());
                    counter++;
                }

                System.out.println("select a product: ");
                int userChoice = scan.nextInt();
                Product productChoice = list.get(userChoice);
                System.out.println(productChoice.getDescription());
                //product service

                //switch(scan.nextLine()) {
                    // select a product and determine number to add to cart
                    //
                //}

                break exit;
            }

    }
}
