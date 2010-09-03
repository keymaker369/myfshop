package org.seke.fs.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.seke.fs.Costumer;
import org.seke.fs.beans.CostumerBean;
import org.seke.fs.services.CostumersService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Jul 25, 2010
 * Time: 11:16:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class CostumersServiceImpl implements CostumersService {

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
    public Costumer register(Costumer costumer) {
        return (Costumer) getSession().get(CostumerBean.class, getSession().save(costumer));
    }

    @Transactional
    public Costumer retrieve(String username) {
        Object costumer = getSession().createQuery("from CostumerBean where username = '" + username + "'").uniqueResult();
        if (costumer == null)
            return null;
        else
            return (Costumer) costumer;
    }

    @Transactional
    public boolean isCostumerExist(String username,String password) {
        Object costumer = getSession().createQuery("from CostumerBean where username = '" + username + "' and password = '"+password+"'").uniqueResult();
        if (costumer == null)
            return false;
        else
            return true;
    }

    @Transactional
    public void updateCostumersData(Costumer costumer){
        getSession().saveOrUpdate(costumer);
    }
}
