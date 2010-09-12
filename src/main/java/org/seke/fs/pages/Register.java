package org.seke.fs.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.User;
import org.seke.fs.beans.UserBean;
import org.seke.fs.services.ProductsService;
import org.seke.fs.services.UsersService;
import org.seke.fs.spring.ApplicationContextProviderSingleton;
import org.springframework.context.ApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Aug 5, 2010
 * Time: 5:59:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Register {

    @Property
    private String username;

    @Property
    private String password;

    @Property
    private String firstName;

    @Property
    private String lastName;

    @Property
    private String email;

    @Property
    private String type;

    @Inject
    private UsersService usersService;

    @Inject
    private ProductsService productsService;

    @Property
    @Inject
    private Block edit;

    @Property
    @Inject
    private Block congratulations;

    private ApplicationContext applicationContext() {
        return new ApplicationContextProviderSingleton().getContext();
    }

    @Property
    @Persist("flash")
    private User registeringUser;

    @OnEvent(value = "submit", component = "fRegister")
    Object registerUser() {
        registeringUser = new UserBean();
        registeringUser.setUsername(username);
        registeringUser.setPassword(password);
        registeringUser.setFirstName(firstName);
        registeringUser.setLastName(lastName);
        registeringUser.setEmail(email);
        registeringUser.setType(type);
        usersService.register(registeringUser);
        return congratulations;
    }
}
