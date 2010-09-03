package org.seke.fs.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.seke.fs.Order;
import org.seke.fs.beans.OrderBean;
import org.seke.fs.services.OrdersService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Aug 30, 2010
 * Time: 5:04:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrdersServiceImpl implements OrdersService {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        if (sessionFactory.isClosed())
            return sessionFactory.openSession();
        else return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void purchaseOrder(Order order) {
        getSession().saveOrUpdate(order);
    }
}
