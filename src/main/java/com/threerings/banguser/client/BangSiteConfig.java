//
// $Id$

package com.threerings.banguser.client;

import com.google.gwt.user.client.ui.Widget;

import com.threerings.gwt.ui.Widgets;

import com.threerings.user.client.PageContext;
import com.threerings.user.client.simple.SimpleSiteConfig;

/**
 * Configures things for the Bang website.
 */
public class BangSiteConfig extends SimpleSiteConfig
{
    // our header and footer are static and in our index.html file

    @Override public Widget createHeader (PageContext ctx) {
        return null;
    }

    @Override public Widget createFooter (PageContext ctx) {
        return null;
    }
}
