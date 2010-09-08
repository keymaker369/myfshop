package org.seke.fs.pages;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Costumer;
import org.seke.fs.services.CostumersService;

/**
 * Start page of application fs.
 */
public class Index {

    @SessionState
    private Costumer costumer;

    private String username;
    private String password;

    @Inject
    private CostumersService costumersService;

    public String getUsername() {
        return username;
    }

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
        if (costumersService.isCostumerExist(username, password)) {
            costumer = costumersService.retrieve(username);
        }
        System.out.println("<----------------stiso dugme za login---------------->");
        //return null;
    }

    @OnEvent(value = "submit", component = "fLogOut")
    void logOut() {
        costumer = null;
        System.out.println("<----------------stiso dugme za logout---------------->");
    }

}
