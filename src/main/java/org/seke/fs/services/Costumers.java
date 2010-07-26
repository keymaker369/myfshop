package org.seke.fs.services;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.seke.fs.Costumer;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Jul 25, 2010
 * Time: 11:18:04 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Costumers {

    @CommitAfter
    Costumer save(Costumer costumer);

    Costumer retrieve(Serializable id);
}
