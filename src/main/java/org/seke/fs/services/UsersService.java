package org.seke.fs.services;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.seke.fs.Order;
import org.seke.fs.User;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Jul 25, 2010
 * Time: 11:18:04 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UsersService {

    @CommitAfter
    User register(User user);

    User retrieve(String username);

    User retrieve(long id);

    Collection<User> retrieve();

    boolean isUserExist(String username, String password);

    @CommitAfter
    void updateUsersData(User user);

    @CommitAfter
    void saveOrUpdateUser(User user);

    @CommitAfter
    void purchaseOrder(User user, Order purchasedOrder);

    public void deleteAllUsers();
}