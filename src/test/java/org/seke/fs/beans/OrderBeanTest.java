package org.seke.fs.beans;

import org.seke.fs.Order;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test
    public void testOrdersItems() {
        assertNotNull(orderUnderTest.getOrdersItems());
    }

}
