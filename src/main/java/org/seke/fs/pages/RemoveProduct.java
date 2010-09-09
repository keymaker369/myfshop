package org.seke.fs.pages;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Identifiable;
import org.seke.fs.Product;
import org.seke.fs.services.ProductsService;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Sep 8, 2010
 * Time: 4:34:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveProduct {

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

    @OnEvent(value = "submit", component = "fRemoveProduct")
    void saveProduct() {
    }

    @OnEvent(component = "yesButton")
    void onYesButton() {
        System.out.println("Product is disabled");
    }

    @OnEvent(component = "noButton")
    void onNoButton() {
        System.out.println("disabling product canceled!");
    }

}
