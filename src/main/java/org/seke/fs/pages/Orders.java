package org.seke.fs.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Identifiable;
import org.seke.fs.Order;
import org.seke.fs.services.OrdersService;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Sep 13, 2010
 * Time: 6:35:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Orders {

    @Inject
    @Property
    private OrdersService ordersService;

    @Property
    private Order currentOrder;

    public long getCurrentOrderId() {
        return Identifiable.class.cast(currentOrder).getId();
    }
}
