package org.seke.fs.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Identifiable;
import org.seke.fs.Product;
import org.seke.fs.services.ProductsService;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Sep 9, 2010
 * Time: 10:46:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class BrowseProductsAdmin {
    @Inject
    @Property
    private ProductsService productsService;

    @Property
    private Product currentProduct;

    public long getCurrentProductId() {
        return Identifiable.class.cast(currentProduct).getId();
    }
}