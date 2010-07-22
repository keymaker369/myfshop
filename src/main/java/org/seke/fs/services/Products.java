package org.seke.fs.services;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.seke.fs.Product;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 16, 2010
 * Time: 2:04:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Products {

    Collection<Product> retrieve();

    @CommitAfter
    Product save(Product product);

    Product retrieve(Serializable id);

}
