package org.seke.fs.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Order;
import org.seke.fs.User;
import org.seke.fs.services.UsersService;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Aug 29, 2010
 * Time: 1:52:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserInfo {

    @SessionState
    private User user;

    @Inject
    private UsersService usersService;

    @Property
    private Order currentOrder;

    @Property
    private String oldPassword;

    @Property
    private String newPassword;

    @Property
    private String retypedNewPassword;

    @Property
    @Inject
    private Block edit;

    @Property
    @Inject
    private Block congratulations;

    @Property
    @Persist("flash")
    private String message;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private boolean userExists;

    public boolean getUserExists() {
        return userExists;
    }

    public void setUserExists(boolean costmerExists) {
        this.userExists = userExists;
    }

    @OnEvent(value = "submit", component = "fRegister")
    Object updateUser() {
        if(!newPassword.equals(retypedNewPassword)){
            message = "Passwords not same!";
            return null;
        }
        usersService.saveOrUpdateUser(user);
        return congratulations;
    }
//    @SetupRender
//    void setup() {
//        if (userExists) {
//            User c2 = user;
//            user = usersService.retrieve(user.getUsername());
//            User c1 = user;
//            System.out.println("kraj");
//        }
//    }
}
