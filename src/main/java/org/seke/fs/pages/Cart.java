package org.seke.fs.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Identifiable;
import org.seke.fs.Order;
import org.seke.fs.OrdersItem;
import org.seke.fs.User;
import org.seke.fs.beans.OrderBean;
import org.seke.fs.services.OrdersItemsService;
import org.seke.fs.services.OrdersService;
import org.seke.fs.services.UsersService;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Aug 30, 2010
 * Time: 3:19:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class Cart {

    @SessionState
    private User user;

    private User tempCastumer;

    @Persist
    private List<OrdersItem> ordersItemsInChart;

    @Inject
    private OrdersService ordersServce;

    @Inject
    private UsersService usersService;

    @Inject
    private OrdersItemsService ois;

    @Property
    private OrdersItem currentItem;

    @Property
    @Inject
    private Block edit;

    @Property
    @Inject
    private Block congratulations;

//    @InjectPage
//    private Congratulations congratulations;

    public List<OrdersItem> getOrdersItemsInChart() {
        return ordersItemsInChart;
    }

    private boolean userExists;

    public boolean getUserExists() {
        return userExists;
    }

    public void setOrdersItemsInChart(List<OrdersItem> ordersItemsInChart) {
        this.ordersItemsInChart = ordersItemsInChart;
    }

    public long getCurrentItemId() {
        return Identifiable.class.cast(currentItem).getId();
    }

    @OnEvent(value = "submit", component = "fPurchaseOrder")
    Object purchaseOrder() {
        tempCastumer = usersService.retrieve(user.getUsername());
        Order order = new OrderBean();
        order.setOrdersItems(ordersItemsInChart);
        order.setCommitDate((new Date().toString()));
        usersService.purchaseOrder(tempCastumer,order);
        ordersItemsInChart = null;
        return congratulations;
    }

}