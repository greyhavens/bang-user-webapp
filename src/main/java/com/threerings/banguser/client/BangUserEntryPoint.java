//
// $Id$

package com.threerings.banguser.client;

import com.threerings.user.client.SiteConfig;
import com.threerings.user.client.UserEntryPoint;

/**
 * The main entry point for the Bang User webapp.
 */
public class BangUserEntryPoint extends UserEntryPoint
{
    @Override protected SiteConfig createSiteConfig () {
        return new BangSiteConfig();
    }
}
