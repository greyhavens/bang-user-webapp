//
// $Id$

package com.threerings.banguser.server

import com.samskivert.jdbc.{ConnectionProvider, StaticConnectionProvider}
import com.samskivert.util.Config

import com.threerings.user.server.UserServlet

/**
 * Customizes the user servlet.
 */
class BangUserServlet extends UserServlet
{
  override protected def createConnectionProvider :ConnectionProvider = {
    val config = new Config("ooouser")
    new StaticConnectionProvider(config.getSubProperties("db"))
  }
}
