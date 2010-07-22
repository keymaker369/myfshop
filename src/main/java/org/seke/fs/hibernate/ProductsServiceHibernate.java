package org.seke.fs.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.seke.fs.Product;
import org.seke.fs.beans.ProductBean;
import org.seke.fs.services.Products;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 22, 2010
 * Time: 3:25:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductsServiceHibernate implements Products {

    private final Session session;

    public ProductsServiceHibernate(Session session) {
        this.session = session;
    }

    @Override
    public Collection<Product> retrieve() {
        Criteria criteria = session.createCriteria(ProductBean.class);
        return criteria.list();
    }

    @Override
    public Product retrieve(Serializable id) {
        return (Product) session.get(ProductBean.class, id);
    }

    @Override
    public Product save(Product product) {
        return (Product) session.get(ProductBean.class, session.save(product));
    }

}
