package org.seke.fs.beans;

import org.seke.fs.Costumer;
import org.seke.fs.Identifiable;
import org.seke.fs.Order;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 16, 2010
 * Time: 10:57:18 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class CostumerBean implements Costumer, Identifiable {

    @Id
    @GeneratedValue
    private long id;

    @Basic
    private String username;

    @Basic
    private String password;

    @Basic
    private String firstName;

    @Basic
    private String lastName;

    @Basic
    private String email;

    @OneToMany(targetEntity=OrderBean.class,cascade = CascadeType.ALL)
    private List<Order> orders = new LinkedList<Order>();

    public CostumerBean() {
    }

    public CostumerBean(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public long getId() {
        return id;
    }
}
