package org.seke.fs.services;

import org.seke.fs.Order;
import org.seke.fs.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Aug 5, 2010
 * Time: 6:35:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class UsersServiceBean implements UsersService {

    private Map<String, User> users;

    public UsersServiceBean(Map<String, User> users) {
        super();
        this.users = users;
    }

    public UsersServiceBean() {
        this(new HashMap<String, User>());
    }

    @Override
    public User register(User user) {
        return users.put(user.getUsername(), user);
    }

    @Override
    public User retrieve(String username) {
        return users.get(username);
    }

    @Override
    public User retrieve(long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<User> retrieve() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isUserExist(String username, String password) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateUsersData(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void saveOrUpdateUser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void purchaseOrder(User user, Order purchasedOrder) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteAllUsers() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
