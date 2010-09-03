package org.seke.fs.pages;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.*;
import org.seke.fs.beans.OrderBean;
import org.seke.fs.beans.ProductBean;
import org.seke.fs.services.CostumersService;
import org.seke.fs.services.OrdersService;
import org.seke.fs.services.ProductsService;

import java.util.Collection;
import java.util.LinkedList;
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
    private Costumer costumer;

    @Persist
    private List<OrdersItem> ordersItemsInChart;

    @Inject
    private OrdersService ordersServce;

    @Inject
    private CostumersService cs;

    @Property
    private OrdersItem currentItem;

    public List<OrdersItem> getOrdersItemsInChart() {
        return ordersItemsInChart;
    }

    public void setOrdersItemsInChart(List<OrdersItem> ordersItemsInChart) {
        this.ordersItemsInChart = ordersItemsInChart;
    }

    public long getCurrentItemId() {
        return Identifiable.class.cast(currentItem).getId();
    }

    @OnEvent(value = "submit", component = "fPurchaseOrder")
    void purchaseOrder() {
        Order order = new OrderBean();
        order.setOrdersItems(ordersItemsInChart);
        order.setCostumer(costumer);
        order.setCommitDate("neki datum");
        List<Order> list = new LinkedList<Order>();
        list.add(order);
        costumer.setOrders(list);
        cs.updateCostumersData(costumer);
        ordersItemsInChart = null;
        //System.out.println("<----------------stiso dugme za Purchase order---------------->");
        //return null;
    }
}
