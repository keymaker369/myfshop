package org.seke.fs.beans;

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
 * Date: Jul 15, 2010
 * Time: 11:20:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProductBeanTest {

    Product productUnderTest;

    @BeforeMethod
    public void setUp() {
        productUnderTest = new ProductBean();
    }


    @Test
    public void testId() {
        assertNotNull(productUnderTest.getId());
        assertSame(0, productUnderTest.getId());
        int id = 3;
        productUnderTest.setId(id);
        assertSame(id, productUnderTest.getId());
    }

    @Test
    public void testTitle() {
        assertNull(productUnderTest.getTitle());
        String title = "test";
        productUnderTest.setTitle(title);
        assertSame(title, productUnderTest.getTitle());
    }

    @Test
    public void testAmountInStock() {
        assertNotNull(productUnderTest.getAmountInStock());
        int amountInStock = 134;
        productUnderTest.setAmountInStock(amountInStock);
        assertEquals(amountInStock, productUnderTest.getAmountInStock());
    }

    @Test
    public void testPrice() {
        assertNotNull(productUnderTest.getPrice());
        assertEquals(0.0, productUnderTest.getPrice());
        double price = 134.134;
        productUnderTest.setPrice(price);
        assertEquals(price, productUnderTest.getPrice());
    }

}
