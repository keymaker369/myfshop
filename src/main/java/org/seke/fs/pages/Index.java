package org.seke.fs.pages;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.User;
import org.seke.fs.services.UsersService;

/**
 * Start page of application fs.
 */
public class Index {

    @SessionState
    @Property
    private User user;

    private String username;
    private String password;

    @Inject
    private UsersService usersService;

    public String getUsername() {
        return username;
    }

    @Property
    private boolean userExists;

    @Property
    @Persist("flash")
    private String message;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OnEvent(value = "submit", component = "fLogIn")
    void logIn() {
        if (usersService.isUserExist(username, password)) {
            user = usersService.retrieve(username);
            return;
        }
        message = "Wrong ussername or password.";
    }

    @OnEvent(value = "submit", component = "fLogOut")
    void logOut() {
        user = null;
        System.out.println("<----------------stiso dugme za logout---------------->");
    }

}
