package org.seke.fs.services;

import org.seke.fs.Product;

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

    private Map<Integer, Product> products;

    public ProductsBean(Map<Integer, Product> products) {
        super();
        this.products = products;
    }

    public ProductsBean() {
        this(new HashMap<Integer, Product>());        
    }

    public Collection<Product> retrieve() {
        return products.values();
    }

    public Product save(Product product) {
        assert product != null;
		assert product.getId() != 0;
		//assert product.getId().s > 1;
        return products.put(product.getId(),product);
    }

    public Product retrieve(int id) {
        return products.get(id);
    }
}
