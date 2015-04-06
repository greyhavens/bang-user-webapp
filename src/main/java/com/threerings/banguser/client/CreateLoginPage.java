//
// $Id$

package com.threerings.banguser.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import com.threerings.user.client.AbstractPage;
import com.threerings.user.client.Args;
import com.threerings.user.client.CreatePanel;
import com.threerings.user.client.LoginPanel;
import com.threerings.user.client.PageContext;

/**
 * Displays the Bang! Howdy login page.
 */
public class CreateLoginPage extends AbstractPage
{
    public CreateLoginPage (PageContext ctx) {
        super(ctx);
        initWidget(_binder.createAndBindUi(this));

        _login.setWidget(_loginPanel = new LoginPanel(ctx, true));
        _create.setWidget(new CreatePanel(ctx, false) {
            protected String getTosLink () {
                return "/support/tos.html";
            }
        });
    }

    @Override protected void onArgsChange (Args args) {
        super.onArgsChange(args);
        _loginPanel.onArgsChange(args);
    }

    protected @UiField SimplePanel _login,  _create;
    protected LoginPanel _loginPanel;

    protected interface Binder extends UiBinder<Widget, CreateLoginPage> {}
    protected static final Binder _binder = GWT.create(Binder.class);
}
