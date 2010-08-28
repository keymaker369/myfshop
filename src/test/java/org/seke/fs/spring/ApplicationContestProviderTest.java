package org.seke.fs.spring;

import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: nenad
 * Date: Aug 28, 2010
 * Time: 11:34:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationContestProviderTest {

    @Test
    public void contextUnderTest() {

        ApplicationContextProvider contextUnderTest = new ApplicationContextProviderSingleton();
        contextUnderTest.getContext();
        for (int i = 0; i < contextUnderTest.getContextLocations().length; i++) {
            System.out.println(contextUnderTest.getContextLocations()[i]);
        }
    }
}
