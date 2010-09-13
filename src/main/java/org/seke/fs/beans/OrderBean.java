package org.seke.fs.beans;

import org.seke.fs.Identifiable;
import org.seke.fs.Order;
import org.seke.fs.OrdersItem;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 16, 2010
 * Time: 10:52:46 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class OrderBean implements Order, Identifiable {

    @Id
    @GeneratedValue
    private long id;

    @Basic
    private String commitDate;

    @Basic
    private double price;

    @Basic
    private boolean processed;

    @OneToMany(targetEntity = OrdersItemBean.class)
    private List<OrdersItem> ordersItems = new LinkedList<OrdersItem>();

    public OrderBean() {
    }

    public OrderBean(int id, String commitDate) {
        this.id = id;
        this.commitDate = commitDate;
    }

    public long getId() {
        return id;
    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = commitDate;
    }

    public List<OrdersItem> getOrdersItems() {
        return ordersItems;
    }

    public void setOrdersItems(List<OrdersItem> ordersItems) {
        this.ordersItems = ordersItems;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean isProcessed() {
        return processed;
    }

    @Override
    public void setProcessing(boolean processed) {
        this.processed = processed;
    }

//    @Override
//    public User getUser() {
//        return user;
//    }
//
//    @Override
//    public void setUser(User user) {
//        this.user = user;
//    }

}
