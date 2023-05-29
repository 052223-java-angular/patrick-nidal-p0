package com.revature.p0.screens;

import com.revature.p0.models.Review;
import com.revature.p0.models.Session;
import com.revature.p0.services.ReviewService;
import com.revature.p0.services.RouterService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class ReviewScreen implements IScreen {
    private final RouterService routerService;
    private final ReviewService reviewService;
    private Session session;


    @Override
    public void start(Scanner scan) {
        System.out.println("Reviews Screen");

        exit:
        while (true) {
            System.out.print("[1] Add a review");
            System.out.print("\n[2] Browse all reviews");
            System.out.print("\n[3] Browse reviews based on product name");
            System.out.print("\n[4] Back to main menu");
            System.out.print("\n[x] Exit the system");

            System.out.println("\nEnter: ");
            switch (scan.nextLine()) {
                case "1":
                    System.out.println("Enter product name: ");
                    String productName = scan.nextLine();
                    System.out.println("Enter a rate out of 5: ");
                    int rate = scan.nextInt();
                    System.out.println("Enter your comment: ");
                    scan.nextLine();
                    String comment = scan.nextLine();
                    Review review = new Review(rate, comment, session.getId(), productName);
                    reviewService.addReview(review);
                    System.out.println("Review Added Successfully!");
                    break;
                case "2":
                    List<Review> reviews = reviewService.getAllReviews();
                    int counter = 1;
                    for (Review review1 : reviews ) {
                        System.out.println(counter + " - " + review1.getProductId() + " -Stars: " + review1.getStars()
                        + " -Comment: " + review1.getComment());
                        counter++;
                    }
                    System.out.println("\nPress Enter to continue");
                    scan.nextLine();
                    break;
                case "3":
                    System.out.println("Enter product name: ");
                    int counter2 = 1;
                    String productName2 = scan.nextLine();
                    List<Review> reviewProduct = reviewService.getReviewByProductId(productName2);
                    for (Review review2 : reviewProduct) {
                        System.out.println(counter2 + " - Product: " + review2.getProductId() + " -Stars: "
                         + review2.getStars() + " -Comment: " + review2.getComment());
                        counter2++;
                    }
                    System.out.println("Press Enter to continue: ");
                    scan.nextLine();
                    break;
                case "4":
                    routerService.navigate("/menu", scan);
                    break;
                case "x":
                    break exit;
            }
        }
    }
}
