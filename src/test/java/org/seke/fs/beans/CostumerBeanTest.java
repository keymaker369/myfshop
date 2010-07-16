package org.seke.fs.beans;

import org.seke.fs.Costumer;
import org.seke.fs.Product;
import org.seke.fs.beans.ProductBean;
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
public class CostumerBeanTest {

    Costumer costumerUnderTest;

    @BeforeMethod
    public void setUp() {
        costumerUnderTest = new CostumerBean();
    }

    @Test
    public void testUsername() {
        assertNull(costumerUnderTest.getUsername());
        String username = "Test";
        costumerUnderTest.setUsername(username);
        assertSame(username, costumerUnderTest.getUsername());
    }

    @Test
    public void testPassword() {
        assertNull(costumerUnderTest.getPassword());
        String password = "Test";
        costumerUnderTest.setPassword(password);
        assertSame(password, costumerUnderTest.getPassword());
    }

    @Test
    public void testFirstName() {
        assertNull(costumerUnderTest.getFirstName());
        String name = "Test";
        costumerUnderTest.setFirstName(name);
        assertSame(name, costumerUnderTest.getFirstName());
    }

    @Test
    public void testLastName() {
        assertNull(costumerUnderTest.getLastName());
        String name = "Test";
        costumerUnderTest.setLastName(name);
        assertSame(name, costumerUnderTest.getLastName());
    }

    @Test
    public void testOrders(){
        assertNotNull(costumerUnderTest.getOrders());
    }
}
