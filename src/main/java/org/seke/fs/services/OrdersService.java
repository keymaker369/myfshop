package org.seke.fs.services;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.seke.fs.Order;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Aug 30, 2010
 * Time: 5:02:14 AM
 * To change this template use File | Settings | File Templates.
 */
public interface OrdersService {

    @CommitAfter
    void purchaseOrder(Order order);

    Order retrieve(long id);

    Collection<Order> retrieve();

    void processOrder(Order order);
}
