package org.seke.fs.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Identifiable;
import org.seke.fs.Product;
import org.seke.fs.beans.ProductBean;
import org.seke.fs.services.ProductsService;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 20, 2010
 * Time: 10:43:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddProduct {

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

    @Property
    @Persist("flash")
    private String activity;

    @SetupRender
    public void createObject() {
        product = new ProductBean();
    }

    @OnEvent(value = "submit", component = "fAddProduct")
    Object saveProduct() {
        product.setActivity(Boolean.parseBoolean(activity));
        productsService.save(product);
        System.out.println("<--------------------" + activity + "------------------->");
        return congratulations;
    }

    public long getId() {
        return Identifiable.class.cast(product).getId();
    }

    public String getYes() {
        return "true";
    }

    public String getNo() {
        return "false";
    }
}