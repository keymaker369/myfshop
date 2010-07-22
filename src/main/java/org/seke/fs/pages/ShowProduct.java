package org.seke.fs.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Product;
import org.seke.fs.services.Products;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 21, 2010
 * Time: 4:20:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowProduct {

    @Property
    private Product product;

    @Inject
    private Products products;

    public void onActivate(int id) {
        product = products.retrieve(id);
    }

    String onPassivate() {
        return product.getTitle();
    }

}