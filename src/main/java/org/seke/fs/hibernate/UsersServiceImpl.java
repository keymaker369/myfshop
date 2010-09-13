package org.seke.fs.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.seke.fs.Order;
import org.seke.fs.OrdersItem;
import org.seke.fs.Product;
import org.seke.fs.User;
import org.seke.fs.beans.UserBean;
import org.seke.fs.services.UsersService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Jul 25, 2010
 * Time: 11:16:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class UsersServiceImpl implements UsersService {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public User register(User user) {
        return (User) getSession().get(UserBean.class, getSession().save(user));
    }

    @Transactional
    public User retrieve(String username) {
        Object user = getSession().createQuery("from UserBean where username = '" + username + "'").uniqueResult();
        if (user == null)
            return null;
        else
            return (User) user;
    }

    @Override
    public User retrieve(long id) {
        Object user = getSession().createQuery("from UserBean where id = " + id).uniqueResult();
        if (user == null)
            return null;
        else
            return (User) user;
    }

    @Override
    public Collection<User> retrieve() {
        Criteria criteria = getSession().createCriteria(UserBean.class);
        return criteria.list();
    }

    @Transactional
    public boolean isUserExist(String username, String password) {
        Object user = getSession().createQuery("from UserBean where username = '" + username + "' and password = '" + password + "'").uniqueResult();
        if (user == null)
            return false;
        else
            return true;
    }

    @Transactional
    public void updateUsersData(User user) {
        Iterator it = user.getOrders().iterator();
        while (it.hasNext()) {
            Order currentOrder = (Order) it.next();
            Iterator it1 = currentOrder.getOrdersItems().iterator();
            while (it1.hasNext()) {
                getSession().save((OrdersItem) it1.next());
            }
            getSession().save(currentOrder);
        }
        getSession().update(user);
    }

    @Transactional
    public void saveOrUpdateUser(User user) {
        getSession().saveOrUpdate(user);
    }

    @Transactional
    public void purchaseOrder(User user, Order purchasedOrder) {
        double ordersPrice = 0;
        Iterator it = purchasedOrder.getOrdersItems().iterator();
        while (it.hasNext()) {
            OrdersItem currentItem = (OrdersItem) it.next();
            Product currentProduct = currentItem.getProduct();
            ordersPrice += currentItem.getPrice();
            int amountOfOrderedProducts = currentItem.getAmount();
            int newAmount = currentProduct.getAmountInStock() - amountOfOrderedProducts;
            currentProduct.setAmountInStock(newAmount);
            getSession().saveOrUpdate(currentProduct);
            getSession().save(currentItem);
        }
        purchasedOrder.setPrice(ordersPrice);
        user.getOrders().add(purchasedOrder);
        getSession().update(user);


    }
}
