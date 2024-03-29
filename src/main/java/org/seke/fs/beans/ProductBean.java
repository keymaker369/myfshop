package org.seke.fs.beans;

import org.seke.fs.Identifiable;
import org.seke.fs.Product;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA. User: user Date: Jul 14, 2010 Time: 4:27:04 PM To
 * change this template use File | Settings | File Templates.
 */
@Entity
public class ProductBean implements Product, Identifiable {

    @Id
    @GeneratedValue
    private long id;

    @Basic
    private String title;

    @Basic
    private int amountInStock;

    @Basic
    private double price;

    @Basic
    private boolean active;

    public ProductBean() {
    }

    public ProductBean(String title, int amountInStock, double price) {
        this.title = title;
        this.amountInStock = amountInStock;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        assert title != null;
        assert title.length() > 0;
        assert !title.equals(" ");
        this.title = title;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        assert amountInStock >= 0;
        this.amountInStock = amountInStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        assert price > 0;
        this.price = price;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActivity(boolean active) {
        this.active = active;
    }
}
