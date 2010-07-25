package org.seke.fs.services;

import org.seke.fs.Product;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 16, 2010
 * Time: 2:04:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductsBean implements Products{

    private Map<String, Product> products;

    public ProductsBean(Map<String, Product> products) {
        super();
        this.products = products;
    }

    public ProductsBean() {
        this(new HashMap<String, Product>());        
    }

    public Collection<Product> retrieve() {
        return products.values();
    }

    public Product save(Product product) {
        assert product != null;
		assert Character.isUpperCase(product.getTitle().charAt(0));
		assert product.getTitle().length() > 1;
        return products.put(product.getTitle(),product);
    }

    public Product retrieve(Serializable title) {
        return products.get(title);
    }
}
