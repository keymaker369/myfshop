package org.seke.fs.beans;

import org.seke.fs.User;
import org.seke.fs.Identifiable;
import org.seke.fs.Order;

import javax.persistence.*;
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
public class UserBean implements User, Identifiable {

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

    @Basic
    private String type;

    @OneToMany(targetEntity = OrderBean.class, cascade = CascadeType.ALL)
    private List<Order> orders = new LinkedList<Order>();

    public UserBean() {
    }

    public UserBean(String username, String password, String firstName, String lastName, String email, String type) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        assert username != null;
        assert username.length() >= 3 && username.length() <= 20;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        assert password != null;
        assert password.length() >= 3 && password.length() <= 20;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        assert firstName != null;
        assert firstName.length() >= 1 && firstName.length() <= 20;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        assert lastName != null;
        assert lastName.length() >= 1 && lastName.length() <= 20;
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

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        assert type != null;
        assert type.equals("administrator") || type.equals("costumer");
        this.type = type;
    }

    public long getId() {
        return id;
    }
}
