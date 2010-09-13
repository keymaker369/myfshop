package org.seke.fs.pages;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Identifiable;
import org.seke.fs.User;
import org.seke.fs.services.UsersService;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Sep 13, 2010
 * Time: 5:54:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class AllUsers {

    @Inject
    @Property
    private UsersService usersService;

    @Property
    private User currentUser;

    public long getCurrentUserId() {
        return Identifiable.class.cast(currentUser).getId();
    }
}
