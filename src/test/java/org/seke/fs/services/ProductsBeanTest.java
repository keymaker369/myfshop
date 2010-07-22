package org.seke.fs.services;

import org.seke.fs.Product;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertSame;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 22, 2010
 * Time: 11:59:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProductsBeanTest {

    private ProductsBean productsUnderTest;
    private Map<Integer, Product> productsMap;

    @BeforeMethod
    public void setUp() {
        productsMap = new HashMap<Integer, Product>();
        productsUnderTest = new ProductsBean(productsMap);
    }

    @Test
    public void testSave() {
        Product product = mock(Product.class);
        int id = 478;
        when(product.getId()).thenReturn(id);
        productsUnderTest.save(product);
        assertTrue(productsMap.containsKey(id));
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testSaveInvalid() {
        Product product = mock(Product.class);
        int id = 0;
        when(product.getId()).thenReturn(id);
        productsUnderTest.save(product);
    }

    @Test
    public void testRetreive() {
        assertSame(productsMap.values(), productsUnderTest.retrieve());
    }

    @Test
    public void testRetreiveById() {
        Product product = mock(Product.class);
        int id = 789;
        when(product.getId()).thenReturn(id);
        productsMap.put(id, product);
        assertSame(product, productsUnderTest.retrieve(id));
        assertNull(productsUnderTest.retrieve(9854));
    }


}
