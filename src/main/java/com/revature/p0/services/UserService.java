package com.revature.p0.services;

import com.revature.p0.models.User;
import com.revature.p0.daos.UserDAO;
import org.mindrot.jbcrypt.BCrypt;
import java.util.Optional;

public class UserService {

    private final UserDAO userDao;

    public UserService(UserDAO userDao) {
        this.userDao = userDao;
    }

    public User register(String username, String password) {
        String hashPass = BCrypt.hashpw(password, BCrypt.gensalt());
        User newUser = new User(username, hashPass, "A");
        userDao.save(newUser);
        return newUser;
    }

    public boolean login(String username, String password) {
        String hashPass = BCrypt.hashpw(password, BCrypt.gensalt());
        User isValidUser = new User(username, hashPass);
        Optional<User> checkedUser = userDao.login(isValidUser);
        return checkedUser.isPresent();
    }

}
