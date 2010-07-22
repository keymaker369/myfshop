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
public class SeleniumTests extends AbstractIntegrationTestSuite {

    @Test
    void testApplicationStartup() {
        open(BASE_URL);
        waitForPageToLoad("10000");//This is just for demonstration purposes. You usually do not need to use this.
    }

    @Test
    void testAddproduct() {
        open("/fs/");
        click("link=AddProduct");
        waitForPageToLoad("30000");
        type("tfTitle", "Chair");
        type("tfId", "34");
        type("tfAmountInStock", "356");
        type("tfPrice", "245.98");
        click("add");
        waitForCondition("var value=selenium.getText(\"addZone\");value.match(/You have successfully added product: 34 Chair/);","300");
        click("link=browsing");
        waitForPageToLoad("30000");
        click("link=BrowseProducts");
        waitForPageToLoad("30000");
    }

}
