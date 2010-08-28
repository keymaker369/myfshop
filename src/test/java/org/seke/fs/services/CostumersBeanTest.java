package org.seke.fs.services;

import org.seke.fs.Costumer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Aug 5, 2010
 * Time: 7:12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class CostumersBeanTest {

    private CostumersServiceBean costumersUnderTest;
    private Map<String, Costumer> costumersMap;

    @BeforeMethod
    public void setUp() {
        costumersMap = new HashMap<String, Costumer>();
        costumersUnderTest = new CostumersServiceBean(costumersMap);
    }

    @Test
    public void testRegister() {
        Costumer costumer = mock(Costumer.class);
        String username = "zika";
        when(costumer.getUsername()).thenReturn(username);
        costumersUnderTest.register(costumer);
        assertTrue(costumersMap.containsKey(username));
    }


}
