package org.seke.fs.pages;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.SessionState;
import org.seke.fs.User;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Aug 29, 2010
 * Time: 4:31:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class LogOut {

    @SessionState
    private User user;

    @InjectPage
    private Index indexPage;

    @OnEvent(value = "submit", component = "fLogOut")
    Object logOut() {
        user = null;
        return indexPage;
    }

//    void onActivate(String message) {
//        user = null;
//        System.out.println("<------------------on activate--------------------->");
//
//    }
//
//    String onPassivate() {
//        System.out.println("<------------------on pasivate--------------------->");
//        user = null;
//        return null;
//    }

//    void onPrepare() {
//        System.out.println("<------------------tu je--------------------->");
//        user = null;
//    }
}