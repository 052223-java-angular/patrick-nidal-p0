package com.mycompany.app.services;

import com.mycompany.app.models.User;
import com.mycompany.app.daos.UserDAO;

public class UserService {

    private final UserDAO userDao;

    public UserService(UserDAO userDao) {
        this.userDao = userDao;
    }

    public User register(String username, String password) {
        User newUser = new User("b", username, password, "b");
        userDao.save(newUser);
        return newUser;
    }

}
