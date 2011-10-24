//
// $Id$

package com.threerings.banguser.server

import com.samskivert.jdbc.{ConnectionProvider, StaticConnectionProvider}
import com.samskivert.util.{ConfigUtil, PropertiesUtil}

import com.threerings.user.server.UserServlet

/**
 * Customizes the user servlet.
 */
class BangUserServlet extends UserServlet
{
  override protected def createConnectionProvider :ConnectionProvider = {
    val props = ConfigUtil.loadProperties("oooauth.properties")
    new StaticConnectionProvider(PropertiesUtil.getSubProperties(props, "db"))
  }
}
