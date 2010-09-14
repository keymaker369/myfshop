package org.seke.fs.beans;

import org.seke.fs.OrdersItem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

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
    public void setUp() {
        ordersItemUnderTest = new OrdersItemBean();
    }

    @Test
    public void testAmount() {
        assertEquals(0, ordersItemUnderTest.getAmount());
        int amount = 141;
        ordersItemUnderTest.setAmount(amount);
        assertEquals(amount, ordersItemUnderTest.getAmount());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testInvalidAmount() {
        assertEquals(0, ordersItemUnderTest.getAmount());
        int amount = -12;
        ordersItemUnderTest.setAmount(amount);
    }

    @Test
    public void testPrice() {
        assertEquals(0.0, ordersItemUnderTest.getPrice());
        double price = 141.24;
        ordersItemUnderTest.setPrice(price);
        assertEquals(price, ordersItemUnderTest.getPrice());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testInvalidPrice() {
        assertEquals(0.0, ordersItemUnderTest.getPrice());
        int price = -12;
        ordersItemUnderTest.setPrice(price);
    }

//    @Test
//    public void testProduct(){
//         assertNotNull(ordersItemUnderTest.getProduct());
//    }
//
//    @Test(expectedExceptions = AssertionError.class)
//    public void testProductInvalid(){
//    }

}
