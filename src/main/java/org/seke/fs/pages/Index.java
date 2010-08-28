package org.seke.fs.pages;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.seke.fs.Costumer;
import org.seke.fs.services.CostumersService;

import java.util.Date;

/**
 * Start page of application fs.
 */
public class Index {

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

    public Date getCurrentTime() {
        return new Date();
    }
    
	@SetupRender
	public void createObject() {
	    //System.out.println("!!!!!!!zika zikic!!!!!!!!!!!!!!!!!!!!!!!");
	}

    @OnEvent(value = "submit", component = "fLogIn")
    void logIn(){

        Costumer logingCostumer = costumersService.retrieve(username);
        System.out.println(logingCostumer.getPassword());

    }
}
