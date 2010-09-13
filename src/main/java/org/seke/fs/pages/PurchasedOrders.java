package org.seke.fs.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Identifiable;
import org.seke.fs.Order;
import org.seke.fs.User;
import org.seke.fs.services.UsersService;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Sep 8, 2010
 * Time: 2:43:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class PurchasedOrders {

    @SessionState
    private User user;

    @Inject
    private UsersService usersService;

    @Property
    private Order currentOrder;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private boolean userExists;

    public boolean getUserExists() {
        return userExists;
    }

    public long getCurrentOrderId() {
        return Identifiable.class.cast(currentOrder).getId();
    }

    public void setUserExists(boolean costmerExists) {
        this.userExists = userExists;
    }

    @SetupRender
    void setup() {
        if (userExists) {
            user = usersService.retrieve(user.getUsername());
            System.out.println("endOfSetup");
        }
    }
}
