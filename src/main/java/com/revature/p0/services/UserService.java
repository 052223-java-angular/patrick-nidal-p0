package com.revature.p0.services;

import com.revature.p0.models.Cart;
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
        if(userDao.create(newUser)) {
            return newUser;
        }
        return null;
    }

    public User login(String username, String password) {
        //dont delete comment please
        //https://stackoverflow.com/questions/277044/do-i-need-to-store-the-salt-with-bcrypt

        Optional<User> checkedUser = userDao.login(username);
        if(checkedUser.isEmpty()) {
            return null;
        }
        if(!BCrypt.checkpw(password, checkedUser.get().getPassword())) {
            return null;
        }

        return checkedUser.get();
    }

    public String createCart(String account_id) {

        Cart cart = new Cart(account_id);
        boolean isExist = false;

        while(!isExist) {
            isExist = userDao.createCart(cart);
        }
        return cart.getId();
    }

    public String getCartId(String accountId) {
        return userDao.getCartId(accountId);
    }

}
