package org.seke.fs.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.*;
import org.seke.fs.beans.OrderBean;
import org.seke.fs.beans.ProductBean;
import org.seke.fs.services.CostumersService;
import org.seke.fs.services.OrdersItemsService;
import org.seke.fs.services.OrdersService;
import org.seke.fs.services.ProductsService;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
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

    private Costumer tempCastumer;

    @Persist
    private List<OrdersItem> ordersItemsInChart;

    @Inject
    private OrdersService ordersServce;

    @Inject
    private CostumersService costumersService;

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

    private boolean costumerExists;

    public boolean getCostumerExists() {
        return costumerExists;
    }

    public void setOrdersItemsInChart(List<OrdersItem> ordersItemsInChart) {
        this.ordersItemsInChart = ordersItemsInChart;
    }

    public long getCurrentItemId() {
        return Identifiable.class.cast(currentItem).getId();
    }

    @OnEvent(value = "submit", component = "fPurchaseOrder")
    Object purchaseOrder() {
        Order order = new OrderBean();
        order.setOrdersItems(ordersItemsInChart);
        order.setCommitDate("neki datum");
        tempCastumer.getOrders().add(order);
        costumersService.updateCostumersData(tempCastumer);
        ordersItemsInChart = null;
        return congratulations;
    }

    void onActivate(long id) {
        if (costumerExists) {
            tempCastumer = costumersService.retrieve(costumer.getUsername());
            //Costumer c1 = costumer;
            System.out.println("activate");
        }
    }

    long onPassivate() {
        System.out.println("passivate");
        return 36;
    }
}