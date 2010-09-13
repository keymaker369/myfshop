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
 * Time: 6:01:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShowUser {
    @Property
    private User user;

    @Inject
    private UsersService usersService;

    public void onActivate(long id) {
        user = usersService.retrieve(id);
    }

    long onPassivate() {
        return Identifiable.class.cast(user).getId();
    }
}
