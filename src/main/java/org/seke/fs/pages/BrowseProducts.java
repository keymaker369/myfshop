package org.seke.fs.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Product;
import org.seke.fs.services.Products;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 19, 2010
 * Time: 3:12:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class BrowseProducts {

    @Inject
    @Property
    private Products products;

    @Property
    private Product product;
}