package org.seke.fs.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.seke.fs.Product;
import org.seke.fs.beans.ProductBean;
import org.seke.fs.services.ProductsService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 22, 2010
 * Time: 3:25:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductsServiceImpl implements ProductsService {

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
    public Collection<Product> retrieve() {
        Criteria criteria = getSession().createCriteria(ProductBean.class);
        return criteria.list();
    }

    @Transactional
    public Product retrieve(Serializable id) {
        return (Product) getSession().get(ProductBean.class, id);
    }

    @Transactional
    public Product save(Product product) {
        return (Product) getSession().get(ProductBean.class, getSession().save(product));
    }

}
