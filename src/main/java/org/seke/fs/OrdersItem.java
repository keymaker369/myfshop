package org.seke.fs;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 14, 2010
 * Time: 4:16:41 PM
 * To change this template use File | Settings | File Templates.
 */
public interface OrdersItem {

    int getOrdersItemNumber();

    void setOrdersItemNumber(int ordersItemNumber);

    int getAmount();

    void setAmount(int amount);

    double getPrice();

    void setPrice(double price);

//    Order getOrder();
//
//    void setOrder(Order order);

    Product getProduct();

    void setProduct(Product product);
}
