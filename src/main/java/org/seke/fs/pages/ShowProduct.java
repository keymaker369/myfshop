package org.seke.fs.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Costumer;
import org.seke.fs.Identifiable;
import org.seke.fs.OrdersItem;
import org.seke.fs.Product;
import org.seke.fs.beans.OrdersItemBean;
import org.seke.fs.services.ProductsService;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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

    @InjectPage
    private Cart cart;
        
    @Property
    private int wontedAmount;

    public void onActivate(long id) {
        product = productsService.retrieve(id);
    }

    @Property
    private boolean costumerExists;

    @SessionState
    private Costumer costumer;

    long onPassivate() {
        return Identifiable.class.cast(product).getId();
    }

    @OnEvent(value = "submit", component = "fAddToCart")
    void addToCart() {
        List<OrdersItem> collection = new LinkedList<OrdersItem>();
        if (cart.getOrdersItemsInChart() != null){
            collection = cart.getOrdersItemsInChart();
        }
        OrdersItem newOrdersItem = new OrdersItemBean();
        newOrdersItem.setProduct(product);
        newOrdersItem.setAmount(wontedAmount);
        newOrdersItem.setPrice(wontedAmount*product.getPrice());
        collection.add(newOrdersItem);
        cart.setOrdersItemsInChart(collection);
        System.out.println("<----------------stiso dugme za add to cart---------------->");
        //return cart;
    }

}