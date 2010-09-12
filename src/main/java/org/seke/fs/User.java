package org.seke.fs;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 16, 2010
 * Time: 10:56:29 AM
 * To change this template use File | Settings | File Templates.
 */
public interface User {

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getEmail();

    void setEmail(String email);

    List<Order> getOrders();

    void setOrders(List<Order> orders);

    public String getType();

    public void setType(String type);
    
}
