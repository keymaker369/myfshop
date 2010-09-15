package org.seke.fs.seleniumTests;

import org.apache.tapestry5.test.AbstractIntegrationTestSuite;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Sep 15, 2010
 * Time: 2:18:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class SeleniumTest extends AbstractIntegrationTestSuite {

    @Test
    public void registeringTest() {
        open("/fs/");
        click("link=Register");
        waitForPageToLoad("30000");
        type("tfUsername", "zika");
        type("tfPassword", "zika");
        type("tfFirstName", "Zika");
        type("tfLastName", "Zikic");
        type("tfEmail", "zika@beotel.yu");
        select("type", "label=administrator");
        click("bRegister");
        click("link=Index");
        waitForPageToLoad("30000");
        click("link=Index");
        waitForPageToLoad("30000");
        type("tfUsername", "zika");
        type("tfPassword", "zika");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");
    }

    @Test
    public void browsingSiteTest() {
        open("/fs/");
        click("link=Index");
        waitForPageToLoad("30000");
        click("link=BrowseProducts");
        waitForPageToLoad("30000");
        click("link=Register");
        waitForPageToLoad("30000");
        click("link=Contact");
        waitForPageToLoad("30000");
        click("link=About");
        waitForPageToLoad("30000");
        click("link=Index");
        waitForPageToLoad("30000");
    }

    @Test
    public void browsingProductsTest() {
        open("/fs/");
        click("link=Register");
        waitForPageToLoad("30000");
        type("tfUsername", "koja");
        type("tfPassword", "koja");
        type("tfFirstName", "Koja");
        type("tfLastName", "Kojic");
        type("tfEmail", "koja@beotel.yu");
        select("type", "label=administrator");
        click("bRegister");
        click("link=Index");
        waitForPageToLoad("30000");
        type("tfUsername", "koja");
        type("tfPassword", "koja");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=BrowseProductsAdmin");
        waitForPageToLoad("30000");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");
    }

    @Test
    public void addProductTest() {
        open("/fs/");
        click("link=Register");
        waitForPageToLoad("30000");
        type("tfUsername", "mika");
        type("tfPassword", "mika");
        type("tfFirstName", "mika");
        type("tfLastName", "mikic");
        type("tfEmail", "mika@beotel.yu");
        select("type", "label=administrator");
        click("bRegister");
        click("link=Index");
        waitForPageToLoad("30000");
        type("tfUsername", "mika");
        type("tfPassword", "mika");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=AddProduct");
        waitForPageToLoad("30000");
        type("tfTitle", "Cher");
        type("tfAmountInStock", "500");
        type("tfPrice", "1500");
        click("Yes");
        click("add");
        click("link=BrowseProductsAdmin");
        waitForPageToLoad("30000");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");
    }

    @Test(dependsOnMethods = {"addProductTest"})
    public void activateAndDeactivateProductTest() {
        open("/fs/");
        waitForPageToLoad("30000");
        type("tfUsername", "mika");
        type("tfPassword", "mika");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=BrowseProductsAdmin");
        waitForPageToLoad("30000");
        click("link=deactivate");
        waitForPageToLoad("30000");
        click("yesId");
        click("link=BrowseProductsAdmin");
        waitForPageToLoad("30000");
        click("link=reactivate");
        waitForPageToLoad("30000");
        click("yesId");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");
    }

    @Test(dependsOnMethods = {"addProductTest"})
    public void alterProductTest() {
        open("/fs/");
        click("link=Index");
        waitForPageToLoad("30000");
        click("link=Register");
        waitForPageToLoad("30000");
        type("tfUsername", "vlada");
        type("tfPassword", "vlada");
        type("tfFirstName", "Vlada");
        type("tfLastName", "Vladic");
        type("tfEmail", "vlada@beotel.yu");
        select("type", "label=administrator");
        click("bRegister");
        click("link=Index");
        waitForPageToLoad("30000");
        type("tfUsername", "vlada");
        type("tfPassword", "vlada");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=BrowseProductsAdmin");
        waitForPageToLoad("30000");
        click("link=alter");
        waitForPageToLoad("30000");
        type("tfPrice", "1700");
        click("yesId");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");
    }

    @Test(dependsOnMethods = {"addProductTest"})
    public void registerCostumerTest() {

        open("/fs/");
        open("/fs/register");
        click("link=Index");
        waitForPageToLoad("30000");
        click("link=Register");
        waitForPageToLoad("30000");
        type("tfUsername", "laza");
        type("tfPassword", "laza");
        type("tfFirstName", "Lazar");
        type("tfLastName", "lazic");
        type("tfEmail", "laza@beotel.yu");
        select("type", "label=administrator");
        select("type", "label=costumer");
        click("bRegister");
        click("link=Index");
        waitForPageToLoad("30000");
        type("tfUsername", "laza");
        type("tfPassword", "laza");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=BrowseProducts");
        waitForPageToLoad("30000");
        click("link=PurchasedOrders");
        waitForPageToLoad("30000");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");

    }

    @Test(dependsOnMethods = {"addProductTest"})
    public void addToCartTest() {
        open("/fs/");
        click("link=Index");
        waitForPageToLoad("30000");
        click("link=Register");
        waitForPageToLoad("30000");
        type("tfUsername", "pera");
        type("tfPassword", "pera");
        type("tfFirstName", "Pera");
        type("tfLastName", "Peric");
        type("tfEmail", "pera@pwe.po");
        select("type", "label=administrator");
        select("type", "label=costumer");
        click("bRegister");
        click("link=Index");
        waitForPageToLoad("30000");
        type("tfUsername", "pera");
        type("tfPassword", "pera");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=BrowseProducts");
        waitForPageToLoad("30000");
        click("//a[contains(text(),'Title:Cher\nAmount in stock: 500\nPrice: 1700.0')]");
        waitForPageToLoad("30000");
        type("tfWontedAmount", "10");
        click("bInsertInCart");
        waitForPageToLoad("30000");
        click("link=Cart");
        waitForPageToLoad("30000");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");

    }

    @Test(dependsOnMethods = {"addToCartTest"})
    public void purchaseOrderTest() {
        open("/fs/");
        click("link=Index");
        waitForPageToLoad("30000");
        type("tfUsername", "pera");
        type("tfPassword", "pera");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=Cart");
        waitForPageToLoad("30000");
        click("bPurchaseOrder");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");

    }

    @Test(dependsOnMethods = {"purchaseOrderTest"})
    public void checkStateOfPurchasedOrderTest() {
        open("/fs/");
        click("link=Index");
        waitForPageToLoad("30000");
        click("link=Register");
        waitForPageToLoad("30000");
        type("tfUsername", "limeni");
        type("tfPassword", "limeni");
        type("tfFirstName", "Joe");
        type("tfLastName", "Doe");
        type("tfEmail", "lim@lim.li");
        click("bRegister");
        click("link=Index");
        waitForPageToLoad("30000");
        type("tfUsername", "limeni");
        type("tfPassword", "limeni");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=BrowseProducts");
        waitForPageToLoad("30000");
        click("//a[contains(text(),'Title:Cher\nAmount in stock: 490\nPrice: 1700.0')]");
        waitForPageToLoad("30000");
        type("tfWontedAmount", "100");
        click("bInsertInCart");
        waitForPageToLoad("30000");
        click("link=Cart");
        waitForPageToLoad("30000");
        click("bPurchaseOrder");
        click("link=BrowseProducts");
        waitForPageToLoad("30000");
        click("//a[contains(text(),'Title:Cher\nAmount in stock: 390\nPrice: 1700.0')]");
        waitForPageToLoad("30000");
        click("link=PurchasedOrders");
        waitForPageToLoad("30000");
        click("link=2");
        waitForPageToLoad("30000");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");

    }

    @Test(dependsOnMethods = {"checkStateOfPurchasedOrderTest"})
    public void processOrderTest() {
        open("/fs/");
        waitForPageToLoad("30000");
        type("tfUsername", "mika");
        type("tfPassword", "mika");
        click("bLogIn");
        waitForPageToLoad("30000");

        click("link=Orders");
        waitForPageToLoad("30000");
        click("link=2");
        waitForPageToLoad("30000");
        click("bprocessOrder");
        waitForPageToLoad("30000");

        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");

    }

    @Test(dependsOnMethods = {"addProductTest"})
    public void browseAllUsersTest() {
        open("/fs/");
        type("tfUsername", "mika");
        type("tfPassword", "mika");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=AllUsers");
        waitForPageToLoad("30000");
        click("link=1");
        waitForPageToLoad("30000");
        click("link=AllUsers");
        waitForPageToLoad("30000");
        click("link=2");
        waitForPageToLoad("30000");
        click("link=AllUsers");
        waitForPageToLoad("30000");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");
    }

    @Test(dependsOnMethods = {"checkStateOfPurchasedOrderTest"})
    public void browseAllOrdersTest() {
        open("/fs/");
        type("tfUsername", "mika");
        type("tfPassword", "mika");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=Orders");
        waitForPageToLoad("30000");
        click("link=1");
        waitForPageToLoad("30000");
        click("link=Orders");
        waitForPageToLoad("30000");
        click("link=2");
        waitForPageToLoad("30000");
        click("link=Orders");
        waitForPageToLoad("30000");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");
    }

    @Test(dependsOnMethods = {"registeringTest"})
    public void changeUserDetailsTest() {
        open("/fs/");
        type("tfUsername", "zika");
        type("tfPassword", "zika");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=UserInfo");
        waitForPageToLoad("30000");
        type("tfFirstName", "Zivorad");
        type("tfLastName", "Zikic");
        type("tfEmail", "zile@beotel.yu");
        type("tfOldPassword", "zika");
        click("bUpdate");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");
    }

    @Test
    public void changeUserPasswordTest() {
        open("/fs/");
        click("link=Register");
        waitForPageToLoad("30000");
        type("tfUsername", "cole");
        type("tfPassword", "colic");
        type("tfFirstName", "Konstanitin");
        type("tfLastName", "Perin");
        type("tfEmail", "cole@beotel.yu");
        click("bRegister");
        click("link=Index");
        waitForPageToLoad("30000");
        type("tfUsername", "cole");
        type("tfPassword", "colic");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=UserInfo");
        waitForPageToLoad("30000");
        type("tfOldPassword", "colic");
        type("tfNewPassword", "cole");
        type("tfAgainNewPassword", "cole");
        click("bUpdate");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");
        type("tfUsername", "cole");
        type("tfPassword", "cole");
        click("bLogIn");
        waitForPageToLoad("30000");
        click("link=LogOut");
        waitForPageToLoad("30000");
        click("bLogOut");
        waitForPageToLoad("30000");
    }

    @Override
    public void selectPopUp(String windowID) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deselectPopUp() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String captureNetworkTraffic(String type) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addCustomRequestHeader(String key, String value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
