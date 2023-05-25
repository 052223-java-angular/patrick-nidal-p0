package com.mycompany.app.services;

import com.mycompany.app.models.User;
import com.mycompany.app.daos.UserDAO;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {

    private final UserDAO userDao;

    public UserService(UserDAO userDao) {
        this.userDao = userDao;
    }

    public User register(String username, String password) {
        String hashPass = BCrypt.hashpw(password, BCrypt.gensalt());
        User newUser = new User(username, hashPass, "b");
        userDao.save(newUser);
        return newUser;
    }

}
