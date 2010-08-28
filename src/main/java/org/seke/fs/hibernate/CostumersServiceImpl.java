package org.seke.fs.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.seke.fs.Costumer;
import org.seke.fs.beans.CostumerBean;
import org.seke.fs.services.CostumersService;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Jul 25, 2010
 * Time: 11:16:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class CostumersServiceImpl implements CostumersService {

    private final SessionFactory session;

    public CostumersServiceImpl(SessionFactory session) {
        this.session = session;
    }

    @Override
    public Costumer register(Costumer costumer) {
        return (Costumer) session.openSession().get(CostumerBean.class, session.openSession().save(costumer));
    }

    @Override
    public Costumer retrieve(String username) {
        Object costumer = session.openSession().createQuery("from CostumerBean where username = '" + username + "'").uniqueResult();
        if (costumer == null)
            return null;
        else
            return (Costumer) costumer;
    }
}
