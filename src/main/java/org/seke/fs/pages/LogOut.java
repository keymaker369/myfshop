package org.seke.fs.pages;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.SessionState;
import org.seke.fs.Costumer;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Aug 29, 2010
 * Time: 4:31:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class LogOut {

    @SessionState
    private Costumer costumer;

    @OnEvent(value = "submit", component = "fLogOut")
    void logOut() {
        costumer = null;        
    }

//    void onActivate(String message) {
//        costumer = null;
//        System.out.println("<------------------on activate--------------------->");
//
//    }
//
//    String onPassivate() {
//        System.out.println("<------------------on pasivate--------------------->");
//        costumer = null;
//        return null;
//    }

//    void onPrepare() {
//        System.out.println("<------------------tu je--------------------->");
//        costumer = null;
//    }
}