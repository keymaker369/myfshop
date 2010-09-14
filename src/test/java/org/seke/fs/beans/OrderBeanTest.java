package org.seke.fs.beans;

import org.seke.fs.Order;
import org.seke.fs.OrdersItem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.*;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 16, 2010
 * Time: 11:14:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrderBeanTest {

    Order orderUnderTest;

    @BeforeMethod
    public void setUp() {
        orderUnderTest = new OrderBean();
    }

    @Test
    public void commitDate() {
        assertNull(orderUnderTest.getCommitDate());
        String commitDate = "12.12.2002";
        orderUnderTest.setCommitDate(commitDate);
        assertSame(commitDate, orderUnderTest.getCommitDate());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testCommitDateInvalid() {
        assertNull(orderUnderTest.getCommitDate());
        String date = null;
        orderUnderTest.setCommitDate(date);
    }


    @Test(expectedExceptions = AssertionError.class)
    public void testCommitDateInvalid1() {
        assertNull(orderUnderTest.getCommitDate());
        String date = "";
        orderUnderTest.setCommitDate(date);
    }

    @Test
    public void testOrdersItems() {
        assertNotNull(orderUnderTest.getOrdersItems());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testOrdersItemsInvalid() {
        assertNotNull(orderUnderTest.getOrdersItems());
        List<OrdersItem> ordersItems = null;
        orderUnderTest.setOrdersItems(ordersItems);
    }

}
