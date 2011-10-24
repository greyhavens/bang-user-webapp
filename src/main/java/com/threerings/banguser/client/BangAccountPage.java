//
// $Id$

package com.threerings.banguser.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import com.threerings.user.client.Args;
import com.threerings.user.client.Page;
import com.threerings.user.client.PageContext;
import com.threerings.user.client.simple.SimpleAccountPage;
import com.threerings.user.rpc.AccountInfo;

/**
 * Customizes the account page layout for Bang! Howdy.
 */
public class BangAccountPage extends SimpleAccountPage
{
    public BangAccountPage (PageContext ctx) {
        super(ctx);
    }

    @Override protected void gotAccountInfo (AccountInfo info) {
        super.gotAccountInfo(info);
        _username.setText(info.username);
        // TODO: send extended AccountInfo, provide support info

        _create.addClickHandler(new ClickHandler() {
            public void onClick (ClickEvent event) {
                Args.go(Page.CREATE);
            }
        });

        // TODO: wire up _billing button
    }

    @Override protected void bindUI () {
        initWidget(_binder.createAndBindUi(this));
    }

    protected @UiField Label _username, _access;
    protected @UiField Button _billing, _create;

    protected interface Binder extends UiBinder<Widget, BangAccountPage> {}
    protected static final Binder _binder = GWT.create(Binder.class);
}
