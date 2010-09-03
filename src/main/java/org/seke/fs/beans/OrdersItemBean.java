package org.seke.fs.beans;

import org.seke.fs.Identifiable;
import org.seke.fs.Order;
import org.seke.fs.OrdersItem;
import org.seke.fs.Product;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 14, 2010
 * Time: 4:16:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class OrdersItemBean implements OrdersItem, Identifiable{

    @Id
    @GeneratedValue
    private long id;

    @Basic
    private int ordersItemNumber;

    @Basic
    private int amount;

    @Basic
    private double price;

    @ManyToOne(targetEntity = ProductBean.class)
    private Product product;

//    @ManyToOne(targetEntity = OrderBean.class)
//    private Order order;

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

//    @Override
//    public Order getOrder() {
//        return order;
//    }
//
//    @Override
//    public void setOrder(Order order) {
//        this.order = order;
//    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public long getId() {
        return id;
    }
}
