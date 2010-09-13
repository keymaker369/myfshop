package org.seke.fs.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;
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

    @InjectPage
    private UserInfo userInfoPage;

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

    @OnEvent(value = "submit", component = "fUpdateUsersData")
    Object updateUser() {
        if (oldPassword == null) {
            message = "Password is needed for verification!";
            return userInfoPage;
        }
        if (!(user.getPassword().equals(oldPassword))) {
            message = "Wrong password";
            return userInfoPage;
        }
        if (newPassword == null && retypedNewPassword == null) {
            usersService.saveOrUpdateUser(user);
            return congratulations;
        }
        if (!((newPassword == null && retypedNewPassword != null) ||
                (newPassword != null && retypedNewPassword == null))) {
            if (newPassword.equals(retypedNewPassword)) {
                user.setPassword(newPassword);
                usersService.saveOrUpdateUser(user);
                return congratulations;
            }
        }
        message = "New password is not same as retyped new password!";
        return userInfoPage;
    }

}
