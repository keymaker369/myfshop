package org.seke.fs.beans;

import org.seke.fs.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

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

    @Test(expectedExceptions = AssertionError.class)
    public void testUsernameInvalid() {
        assertNull((userUnderTest.getUsername()));
        String username = "As";
        userUnderTest.setUsername(username);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testUsernameInvalid1() {
        assertNull((userUnderTest.getUsername()));
        String username = "01234567890123456789123";
        userUnderTest.setUsername(username);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testUsernameInvalid2() {
        assertNull((userUnderTest.getUsername()));
        String username = null;
        userUnderTest.setUsername(username);
    }

    @Test
    public void testPassword() {
        assertNull(userUnderTest.getPassword());
        String password = "Test";
        userUnderTest.setPassword(password);
        assertSame(password, userUnderTest.getPassword());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testPasswordInvalid() {
        assertNull((userUnderTest.getPassword()));
        String password = "As";
        userUnderTest.setPassword(password);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testPasswordInvalid1() {
        assertNull((userUnderTest.getPassword()));
        String password = "01234567890123456789123";
        userUnderTest.setPassword(password);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testPasswordInvalid2() {
        assertNull((userUnderTest.getPassword()));
        String password = null;
        userUnderTest.setPassword(password);
    }

    @Test
    public void testFirstName() {
        assertNull(userUnderTest.getFirstName());
        String name = "Test";
        userUnderTest.setFirstName(name);
        assertSame(name, userUnderTest.getFirstName());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testFirstNameInvalid() {
        assertNull((userUnderTest.getFirstName()));
        String name = "";
        userUnderTest.setFirstName(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testFirstNameInvalid1() {
        assertNull((userUnderTest.getFirstName()));
        String name = "01234567890123456789123";
        userUnderTest.setFirstName(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testFirstNameInvalid2() {
        assertNull((userUnderTest.getFirstName()));
        String name = null;
        userUnderTest.setFirstName(name);
    }

    @Test
    public void testLastName() {
        assertNull(userUnderTest.getLastName());
        String name = "Test";
        userUnderTest.setLastName(name);
        assertSame(name, userUnderTest.getLastName());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testLastNameInvalid() {
        assertNull((userUnderTest.getLastName()));
        String name = "";
        userUnderTest.setLastName(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testLastNameInvalid1() {
        assertNull((userUnderTest.getLastName()));
        String name = "01234567890123456789123";
        userUnderTest.setLastName(name);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testLastNameInvalid2() {
        assertNull((userUnderTest.getLastName()));
        String name = null;
        userUnderTest.setLastName(name);
    }

    @Test
    public void testType(){

    }

    @Test
    public void testOrders() {
        assertNotNull(userUnderTest.getOrders());
    }
}
