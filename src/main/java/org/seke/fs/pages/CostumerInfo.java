package org.seke.fs.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.seke.fs.Costumer;
import org.seke.fs.Order;

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

    public void setCostumerExists(boolean costmerExists){
        this.costumerExists = costumerExists;
    }
}
