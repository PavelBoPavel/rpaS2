package by.jrr.start.service;

import by.jrr.start.bean.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginServiceTest {

    LoginService loginService;
    User user;

    @Before
    public void setUp(){
        this.loginService = new LoginService();
        this.user = getUser();
        Assert.assertEquals(3, user.getLoginAttempts());
    }

    @Test
    public void checkUserPassword_positive() {
        String userInput = "password";

        boolean actuelResult = loginService.checkUserPassword(user, userInput);
        Assert.assertTrue(actuelResult);

    }

    @Test
    public void checkUserPassword_negative() {
        String userInput = "wrong";

        boolean actuelResult = loginService.checkUserPassword(user, userInput);
        Assert.assertFalse(actuelResult);
    }

    @Test
    public void reduceLoginAttempts() {
        loginService.reduceLoginAttempts (user);
        Assert.assertEquals(2, user.getLoginAttempts());
    }
    @Test
    public void login_positive() {
        String userInput = "password";

        boolean actuelResult = loginService.login(user, userInput);
        Assert.assertTrue(actuelResult);
    }
    @Test
    public void login_negative() {
        String userInput = "wrong";

        boolean actuelResult = loginService.login(user, userInput);
        Assert.assertFalse(actuelResult);
        Assert.assertEquals(2, user.getLoginAttempts());
    }

    private User getUser() {
        User user = new User();
        user.setPassword("password");
        return user;
    }

}