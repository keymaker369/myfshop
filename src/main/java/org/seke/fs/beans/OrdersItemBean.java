package org.seke.fs.beans;

import org.seke.fs.OrdersItem;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 14, 2010
 * Time: 4:16:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrdersItemBean implements OrdersItem{

    private int ordersItemNumber;
    private int amount;
    private double price;

    public OrdersItemBean() {
    }

    public OrdersItemBean(int ordersItemNumber, int amount, double price) {
        this.ordersItemNumber = ordersItemNumber;
        this.amount = amount;
        this.price = price;
    }

    public int getOrdersItemNumber() {
        return ordersItemNumber;
    }

    public void setOrdersItemNumber(int ordersItemNumber) {
        this.ordersItemNumber = ordersItemNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
