package org.seke.fs.pages;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Costumer;
import org.seke.fs.Order;
import org.seke.fs.Product;
import org.seke.fs.beans.CostumerBean;
import org.seke.fs.beans.ProductBean;
import org.seke.fs.services.CostumersService;
import org.seke.fs.services.ProductsService;
import org.seke.fs.spring.ApplicationContextProviderSingleton;
import org.springframework.context.ApplicationContext;

import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Aug 5, 2010
 * Time: 5:59:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Register {

    @Property
    private String username;

    @Property
    private String password;

    @Property
    private String firstName;

    @Property
    private String lastName;

    @Property
    private String email;

    @Inject
    private CostumersService costumersService;

    @Inject
    private ProductsService productsService;

//    @Property
//    @Inject
//    private Block congratulations;
//
//    @Property
//    @Inject
//    private Block edit;

    private ApplicationContext applicationContext() {
        return new ApplicationContextProviderSingleton().getContext();
    }

    @Property
    @Persist("flash")
    private Costumer registeringCostumer;

    @OnEvent(value = "submit", component = "fRegister")
    void registerCostumer() {
        registeringCostumer = new CostumerBean();
        //Costumer registeringCoastumer = new CostumerBean();
        registeringCostumer.setUsername(username);
        registeringCostumer.setPassword(password);
        registeringCostumer.setFirstName(firstName);
        registeringCostumer.setLastName(lastName);
        registeringCostumer.setEmail(email);
        //registeringCostumer.setOrders(new LinkedList<Order>());
        System.out.println(username+password+firstName+lastName+email);
        Product p = new ProductBean();
        p.setTitle("rhwrh");
        p.setAmountInStock(31);
        p.setPrice(3135);
        //productsService.save(p);
        
        costumersService.register(registeringCostumer);
        //return congratulations;
    }
}
