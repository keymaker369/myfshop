package org.seke.fs.beans;

import org.seke.fs.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertSame;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 16, 2010
 * Time: 11:04:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserBeanTest {

    User userUnderTest;

    @BeforeMethod
    public void setUp() {
        userUnderTest = new UserBean();
    }

    @Test
    public void testUsername() {
        assertNull(userUnderTest.getUsername());
        String username = "Test";
        userUnderTest.setUsername(username);
        assertSame(username, userUnderTest.getUsername());
    }

    @Test
    public void testPassword() {
        assertNull(userUnderTest.getPassword());
        String password = "Test";
        userUnderTest.setPassword(password);
        assertSame(password, userUnderTest.getPassword());
    }

    @Test
    public void testFirstName() {
        assertNull(userUnderTest.getFirstName());
        String name = "Test";
        userUnderTest.setFirstName(name);
        assertSame(name, userUnderTest.getFirstName());
    }

    @Test
    public void testLastName() {
        assertNull(userUnderTest.getLastName());
        String name = "Test";
        userUnderTest.setLastName(name);
        assertSame(name, userUnderTest.getLastName());
    }

    @Test
    public void testOrders(){
        assertNotNull(userUnderTest.getOrders());
    }
}
