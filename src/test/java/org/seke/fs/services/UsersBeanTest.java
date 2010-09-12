package org.seke.fs.services;

import org.seke.fs.User;
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
public class UsersBeanTest {

    private UsersServiceBean usersUnderTest;
    private Map<String, User> usersMap;

    @BeforeMethod
    public void setUp() {
        usersMap = new HashMap<String, User>();
        usersUnderTest = new UsersServiceBean(usersMap);
    }

    @Test
    public void testRegister() {
        User user = mock(User.class);
        String username = "zika";
        when(user.getUsername()).thenReturn(username);
        usersUnderTest.register(user);
        assertTrue(usersMap.containsKey(username));
    }


}
