package org.seke.fs.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Identifiable;
import org.seke.fs.OrdersItem;
import org.seke.fs.Product;
import org.seke.fs.beans.OrdersItemBean;
import org.seke.fs.services.ProductsService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Sep 9, 2010
 * Time: 10:37:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowProductAdmin {

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
