package org.seke.fs;

import org.testng.annotations.Test;
import org.apache.tapestry5.test.AbstractIntegrationTestSuite;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: Jul 20, 2010
 * Time: 3:07:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class SeleniumTest extends AbstractIntegrationTestSuite{

    @Test
	public void testApplicationStartUp() {
        open(BASE_URL);
		assertTextPresent("Hello");
		waitForPageToLoad("10000");//This is just for demonstration purposes. You usually do not need to use this.
    }
}
