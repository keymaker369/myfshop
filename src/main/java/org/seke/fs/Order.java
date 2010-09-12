package org.seke.fs;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 15, 2010
 * Time: 9:59:05 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Order {

    String getCommitDate();

    void setCommitDate(String commitDate);

    List<OrdersItem> getOrdersItems();

    void setOrdersItems(List<OrdersItem> ordersItems);
//
//    User getUser();
//
//    void setUser(User user);
}
