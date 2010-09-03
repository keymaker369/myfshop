package org.seke.fs.services;

import org.seke.fs.Costumer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Aug 5, 2010
 * Time: 6:35:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class CostumersServiceBean implements CostumersService {

    private Map<String, Costumer> costumers;

    public CostumersServiceBean(Map<String, Costumer> costumers) {
        super();
        this.costumers = costumers;
    }

    public CostumersServiceBean() {
        this(new HashMap<String, Costumer>());
    }

    @Override
    public Costumer register(Costumer costumer) {
        return costumers.put(costumer.getUsername(),costumer);
    }

    @Override
    public Costumer retrieve(String username) {
        return costumers.get(username);
    }

    @Override
    public boolean isCostumerExist(String username, String password) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateCostumersData(Costumer costumer) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
