package com.revature.p0.services;

import com.revature.p0.daos.CartDAO;
import com.revature.p0.daos.UserDAO;
import com.revature.p0.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
public class TestUserService {
    @Mock
    private UserDAO userDao;
    @Mock
    private CartDAO cartDao;
    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userDao, cartDao);
    }

    @Test
    public void testValidUsername() {
        String validUsername = "checkUsernameValidity";
        String invalidUsername = "";

        assertTrue(userService.validUsername(validUsername));
        assertFalse(userService.validUsername(invalidUsername));
    }

    @Test
    public void testUniqueUsername() {
        String existingUsername = "UserFoundInDB";
        String newUsername = "UserNotFoundInDB";

        when(userDao.uniqueUsername(existingUsername)).thenReturn(Optional.empty());
        when(userDao.uniqueUsername(newUsername)).thenReturn(Optional.of(new User()));

        //returning is Optional.empty() from userService is true
        assertTrue(userService.uniqueUsername(existingUsername));
        //returning is Option.empty() from userService is false
        assertFalse(userService.uniqueUsername(newUsername));
    }

    @Test
    public void testValidPassword() {
        String validPassword = "aValidPass";
        String invalidPassword = "no";

        assertTrue(userService.validPassword(validPassword));
        assertFalse(userService.validPassword(invalidPassword));
    }

    @Test
    public void testMatchPasswordCheck() {
        String password = "confirmpassword";
        String confirmPassword = "confirmpassword";
        String differentPassword = "assertfalsepassword";

        assertTrue(userService.matchPasswordCheck(password, confirmPassword));
        assertFalse(userService.matchPasswordCheck(password, differentPassword));
    }
}
