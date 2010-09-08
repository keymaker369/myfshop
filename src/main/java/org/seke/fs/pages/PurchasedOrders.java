package org.seke.fs.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Costumer;
import org.seke.fs.Order;
import org.seke.fs.services.CostumersService;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Sep 8, 2010
 * Time: 2:43:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class PurchasedOrders {
    @SessionState
    private Costumer costumer;

    @Inject
    private CostumersService costumersService;

    @Property
    private Order currentOrder;

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    private boolean costumerExists;

    public boolean getCostumerExists() {
        return costumerExists;
    }

    public void setCostumerExists(boolean costmerExists) {
        this.costumerExists = costumerExists;
    }

    @SetupRender
    void setup() {
        if (costumerExists) {
            costumer = costumersService.retrieve(costumer.getUsername());
            System.out.println("endOfSetup");
        }
    }
}
