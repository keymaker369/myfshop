package org.seke.fs.beans;

import org.seke.fs.Costumer;
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

    @ManyToOne(targetEntity=CostumerBean.class)
    private Costumer costumer;

    @OneToMany(targetEntity=OrdersItemBean.class,cascade=CascadeType.ALL)
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

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public List<OrdersItem> getOrdersItems(){
        return ordersItems;
    }

}
