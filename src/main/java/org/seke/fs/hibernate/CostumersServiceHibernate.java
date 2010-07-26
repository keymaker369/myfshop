package org.seke.fs.hibernate;

import org.hibernate.Session;
import org.seke.fs.Costumer;
import org.seke.fs.beans.CostumerBean;
import org.seke.fs.services.Costumers;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Jul 25, 2010
 * Time: 11:16:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class CostumersServiceHibernate implements Costumers {

    private final Session session;

    public CostumersServiceHibernate(Session session) {
        this.session = session;
    }

    @Override
    public Costumer save(Costumer costumer) {
          return (Costumer) session.get(CostumerBean.class, session.save(costumer));
    }

    @Override
    public Costumer retrieve(Serializable id) {
        return (Costumer) session.get(CostumerBean.class, id);
    }
}
