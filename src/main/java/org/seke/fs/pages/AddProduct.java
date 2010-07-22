package org.seke.fs.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Product;
import org.seke.fs.beans.ProductBean;
import org.seke.fs.services.Products;

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
    private Product newProduct;

    @Inject
    private Products products;

    @SetupRender
    public void createProduct() {
        newProduct = new ProductBean();
    }

    @OnEvent(value = "submit", component = "fAddProduct")
    Object saveProduct(){
        System.out.println("Stiso dugme add product!!!!!!!!!!!!!!!!!!!!!");
        products.save(newProduct);
        return congratulations;
    }
}