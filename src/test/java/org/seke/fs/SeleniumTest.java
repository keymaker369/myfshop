package org.seke.fs;

import org.apache.tapestry5.test.AbstractIntegrationTestSuite;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 20, 2010
 * Time: 8:39:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeleniumTest extends AbstractIntegrationTestSuite {

    @Test
    void testApplicationStartup() {
        open(BASE_URL);
        assertTextPresent("Main");
        //waitForPageToLoad("10000");//This is just for demonstration purposes. You usually do not need to use this.
    }

    @Test
    void testAddProduct() {
        open("/fs/");
        click("link=AddProduct");
        waitForPageToLoad("30000");
        type("tfTitle", "Chair");
        //type("tfId", "34");
        type("tfAmountInStock", "356");
        type("tfPrice", "245.98");
        click("add");
        waitForCondition("var value=selenium.getText(\"addZone\");value.match(/You have successfully added product: Chair/);", "2000");
        click("link=browsing");
        waitForPageToLoad("30000");
        click("link=BrowseProducts");
        waitForPageToLoad("30000");
    }

    @Test
    void testShowProductDoesNotExist() {
        open(BASE_URL + "showproduct/" + "987");
        assertTextPresent("Unknown product.");
    }

    @Test
    void testUserLogingIfExists() {
//        open("/fs/");
//        click("link=Register");
//        waitForPageToLoad("30000");
//        type("tfUsername", "nenad");
//        type("tfPassword", "seke");
//        type("tfFirstName", "nenad");
//        type("tfLastName", "seke");
//        type("tfEmail", "rwr@ekjn.po");
//        click("bRegister");
//        waitForPageToLoad("30000");
//        click("link=Index");
//        waitForPageToLoad("30000");
//        type("tfUsername", "nenad");
//        type("tfPassword", "seke");
//        click("bLogIn");
//        waitForPageToLoad("30000");

    }

}
