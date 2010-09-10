package org.seke.fs.components;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.*;
import org.apache.tapestry5.BindingConstants;
import org.seke.fs.Costumer;

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
    private Costumer costumer;

    @Property
    private boolean costumerExists;

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
                "Cart", "CostumerInfo", "LogOut"};
    }

    public String[] getAdminPageNames() {
        return new String[]{"Index", "About", "Contact", "BrowseProductsAdmin",
                "AddProduct", "CostumerInfo", "LogOut"};
    }


    public String getAdminString() {
        return "administrator";
    }

    public String getCostumerString() {
        return "costumer";
    }

}
