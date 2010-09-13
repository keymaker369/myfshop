package org.seke.fs.pages;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Identifiable;
import org.seke.fs.Order;
import org.seke.fs.OrdersItem;
import org.seke.fs.User;
import org.seke.fs.services.OrdersService;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Sep 13, 2010
 * Time: 5:16:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowOrder {

    @Property
    private Order order;

    @SessionState
    @Property
    private User user;

    @Inject
    private OrdersService ordersService;

    @Property
    private boolean userExists;

    @Property
    private OrdersItem ordersItem;

    @Property
    @Persist("flash")
    private String message;

    public void onActivate(long id) {
        order = ordersService.retrieve(id);
    }

    long onPassivate() {
        return Identifiable.class.cast(order).getId();
    }

    @OnEvent(value = "submit", component = "fProcessOrder")
    void processOrder() {
        ordersService.processOrder(order);
        message = "Order suecessfuly processed!";
    }

    public boolean isUserAdmin() {
        if (!userExists)
            return false;
        if (user.getType().equals("administrator"))
            return true;
        return false;
    }

}
