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
 * Time: 4:34:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveProduct {

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

    @OnEvent(value = "submit", component = "fDisableProduct")
    Object saveProduct() {
        System.out.println("Pressed submit button");
        return returningPage;
    }
    
    void onSelectedFromYesButton() {
        product.setActivity(false);
        productsService.updateProduct(product);
        returningPage = congratulations;
        System.out.println("Product is disabled");
    }

    void onSelectedFromNoButton() {
        System.out.println("disabling product canceled!");
        returningPage = browseProductsAdmin;
    }

}
