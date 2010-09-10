package org.seke.fs.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.InjectPage;
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
 * Time: 4:56:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReactivateProduct {
    @Property
    private Product product;

    @Inject
    private ProductsService productsService;

    @InjectPage
    private BrowseProductsAdmin browseProductsAdmin;

    private Object returningPage;

    @Property
    @Inject
    private Block edit;

    @Property
    @Inject
    private Block congratulations;

    public void onActivate(long id) {
        product = productsService.retrieve(id);
    }

    long onPassivate() {
        return Identifiable.class.cast(product).getId();
    }

    @OnEvent(value = "submit", component = "fReactivateProduct")
    Object saveProduct() {
        System.out.println("Pressed submit button");
        return returningPage;
    }

    void onSelectedFromYesButton() {
        product.setActivity(true);
        productsService.updateProduct(product);
        returningPage = congratulations;
        System.out.println("Product is active again");
    }

    void onSelectedFromNoButton() {
        System.out.println("Activating product canceled!");
        returningPage = browseProductsAdmin;
    }
}
