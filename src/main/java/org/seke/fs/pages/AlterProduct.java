package org.seke.fs.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Identifiable;
import org.seke.fs.Product;
import org.seke.fs.services.ProductsService;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Sep 8, 2010
 * Time: 4:43:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class AlterProduct {

    @Property
    @Inject
    private Block edit;

    @Property
    @Inject
    private Block congratulations;

    @Property
    @Persist("flash")
    private Product product;

    @Inject
    private ProductsService productsService;

    @InjectPage
    private BrowseProductsAdmin browseProductsAdmin;

    private Object returningPage;

    public void onActivate(long id) {
        product = productsService.retrieve(id);
    }

    long onPassivate() {
        return Identifiable.class.cast(product).getId();
    }

    public long getId() {
        return Identifiable.class.cast(product).getId();
    }

    @OnEvent(value = "submit", component = "fAlterProduct")
    Object saveProduct() {
        return returningPage;
    }

    void onSelectedFromYesButton() {
        productsService.save(product);
        System.out.println("<--------------------Product altered------------------->");
        returningPage = congratulations;
    }

    void onSelectedFromNoButton() {
        System.out.println("Activating product canceled!");
        returningPage = browseProductsAdmin;
    }
}
