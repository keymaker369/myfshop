package org.seke.fs.services;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.seke.fs.Costumer;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Jul 25, 2010
 * Time: 11:18:04 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CostumersService {

    @CommitAfter
    Costumer register(Costumer costumer);

    Costumer retrieve(String username);
}
