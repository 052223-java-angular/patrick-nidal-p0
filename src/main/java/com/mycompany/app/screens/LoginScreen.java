package com.mycompany.app.screens;

import com.mycompany.app.services.RouterService;
import com.mycompany.app.models.Session;
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
