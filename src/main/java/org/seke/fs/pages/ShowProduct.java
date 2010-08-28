package org.seke.fs.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Identifiable;
import org.seke.fs.Product;
import org.seke.fs.services.ProductsService;

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
    private ProductsService productsService;

    public void onActivate(long id) {
        product = productsService.retrieve(id);
    }

    long onPassivate() {
        return Identifiable.class.cast(product).getId();
    }

}