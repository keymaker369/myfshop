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
 * Date: Aug 29, 2010
 * Time: 1:52:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class CostumerInfo {

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

//    @SetupRender
//    void setup() {
//        if (costumerExists) {
//            Costumer c2 = costumer;
//            costumer = costumersService.retrieve(costumer.getUsername());
//            Costumer c1 = costumer;
//            System.out.println("kraj");
//        }
//    }
}
