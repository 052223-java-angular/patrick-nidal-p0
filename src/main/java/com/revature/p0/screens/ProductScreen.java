package com.revature.p0.screens;

import com.revature.p0.services.RouterService;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class ProductScreen implements IScreen{

    private final RouterService router;

    @Override
    public void start(Scanner scan) {
        exit:
            while(true) {
                System.out.println("welcome to the product screen");
                System.out.println("product a");
                System.out.println("product b");
                System.out.println("product c");
                System.out.println("product d");

                switch(scan.nextLine()) {
                    // select a product and determine number to add to cart
                    //
                }

                break exit;
            }

    }
}
