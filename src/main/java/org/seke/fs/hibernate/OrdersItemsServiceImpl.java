package org.seke.fs.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.seke.fs.Order;
import org.seke.fs.OrdersItem;
import org.seke.fs.services.OrdersItemsService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Sep 7, 2010
 * Time: 8:12:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrdersItemsServiceImpl implements OrdersItemsService{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
//
//    private Session getSession() {
//        if (sessionFactory.isClosed())
//            return sessionFactory.openSession();
//        else return sessionFactory.getCurrentSession();
//    }

    @Transactional
    public void saveOrdersItem(OrdersItem ordersItem) {
        sessionFactory.getCurrentSession().save(ordersItem);
    }
    
}
