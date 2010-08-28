package org.seke.fs.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.seke.fs.Product;
import org.seke.fs.beans.ProductBean;
import org.seke.fs.services.ProductsService;

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

    private final SessionFactory session;

    public ProductsServiceImpl(SessionFactory session) {
        this.session = session;
    }

    @Override
    public Collection<Product> retrieve() {
        Criteria criteria = session.openSession().createCriteria(ProductBean.class);
        return criteria.list();
    }

    @Override
    public Product retrieve(Serializable id) {
        return (Product) session.openSession().get(ProductBean.class, id);
    }

    @Override
    public Product save(Product product) {
        return (Product) session.openSession().get(ProductBean.class, session.openSession().save(product));
    }

}
