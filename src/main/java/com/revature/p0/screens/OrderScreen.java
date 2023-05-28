package com.revature.p0.screens;

import com.revature.p0.services.RouterService;
import com.revature.p0.models.Session;
import java.util.Scanner;

public class OrderScreen {
    private final RouterService router;
    private Session session;

    public OrderScreen(RouterService router, Session session) {
        this.router = router;
        this.session = session;
    }

    public void start(Scanner scan) {


    }

}
