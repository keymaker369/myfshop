package org.seke.fs.beans;

import org.seke.fs.OrdersItem;
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
 * Time: 11:21:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrdersItemBeanTest {

    OrdersItem ordersItemUnderTest;

    @BeforeMethod
    public void setUp(){
        ordersItemUnderTest = new OrdersItemBean();
    }

    @Test
    public void testOrdersItemNumber(){
        assertEquals(0,ordersItemUnderTest.getOrdersItemNumber());
        int ordersItemNumber = 141;
        ordersItemUnderTest.setOrdersItemNumber(ordersItemNumber);
        assertEquals(ordersItemNumber,ordersItemUnderTest.getOrdersItemNumber());
    }

    @Test
    public void testAmount(){
        assertEquals(0,ordersItemUnderTest.getAmount());
        int amount = 141;
        ordersItemUnderTest.setAmount(amount);
        assertEquals(amount,ordersItemUnderTest.getAmount());
    }

    @Test
    public void testPrice(){
        assertEquals(0.0,ordersItemUnderTest.getPrice());
        double price = 141.24;
        ordersItemUnderTest.setPrice(price);
        assertEquals(price,ordersItemUnderTest.getPrice());
    }
}
