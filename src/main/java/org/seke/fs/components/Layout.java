package org.seke.fs.components;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.*;
import org.apache.tapestry5.BindingConstants;
import org.seke.fs.User;

/**
 * Layout component for pages of application fs.
 */
@IncludeStylesheet("context:layout/layout.css")
public class Layout {
    /**
     * The page title, for the <title> element and the <h1> element.
     */
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Property
    private String pageName;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String sidebarTitle;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private Block sidebar;

    @Inject
    private ComponentResources resources;

    @SessionState
    @Property
    private User user;

    @Property
    private boolean userExists;

    public String getClassForPageName() {
        return resources.getPageName().equalsIgnoreCase(pageName)
                ? "current_page_item"
                : null;
    }

    public String[] getStandardPageNames() {
        return new String[]{"Index", "About", "Contact", "BrowseProducts",
                "Register"};
    }

    public String[] getCostumerPageNames() {
        return new String[]{"Index", "About", "Contact", "BrowseProducts",
                "Cart", "PurchasedOrders", "UserInfo", "LogOut"};
    }

    public String[] getAdminPageNames() {
        return new String[]{"Index", "About", "Contact", "BrowseProductsAdmin",
                "AddProduct", "UserInfo", "LogOut"};
    }


    public String getAdminString() {
        return "administrator";
    }

    public String getCostumerString() {
        return "costumer";
    }

}
