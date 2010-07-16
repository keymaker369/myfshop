package org.seke.fs;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 14, 2010
 * Time: 4:16:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrdersItem {

    private double ordersItemNumber;
    private int amount;
    private double price;

    public OrdersItem() {
    }

    public OrdersItem(double ordersItemNumber, int amount, double price) {
        this.ordersItemNumber = ordersItemNumber;
        this.amount = amount;
        this.price = price;
    }

    public double getOrdersItemNumber() {
        return ordersItemNumber;
    }

    public void setOrdersItemNumber(double ordersItemNumber) {
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
