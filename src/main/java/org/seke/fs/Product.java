package org.seke.fs;

/**
 * Created by IntelliJ IDEA. User: user Date: Jul 14, 2010 Time: 4:27:04 PM To
 * change this template use File | Settings | File Templates.
 */
public interface Product {

    int getId();

    void setId(int id);

    String getTitle();

    void setTitle(String title);

    int getAmountInStock();

    void setAmountInStock(int amountInStock);

    double getPrice();

    void setPrice(double price);
}

