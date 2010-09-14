package org.seke.fs.beans;

import org.seke.fs.Identifiable;
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
public class OrdersItemBean implements OrdersItem, Identifiable {

    @Id
    @GeneratedValue
    private long id;

    @Basic
    private int amount;

    @Basic
    private double price;

    @ManyToOne(targetEntity = ProductBean.class)
    private Product product;

    public OrdersItemBean() {
    }

    public OrdersItemBean(int amount, double price) {
        this.amount = amount;
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        assert amount > 0;
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        assert price > 0;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        assert product != null;
        this.product = product;
    }

    public long getId() {
        return id;
    }
}
