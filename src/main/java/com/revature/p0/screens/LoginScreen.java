package com.revature.p0.screens;

import com.revature.p0.services.RouterService;
import com.revature.p0.models.Session;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginScreen implements IScreen {
    private RouterService router;
    private Session session;

    public void start(Scanner scan) {
        // to do : scanner logic for log in - maintain state using session
        System.out.println("Please log in");

        //navigate to MainMenu after successful login

    }

}
