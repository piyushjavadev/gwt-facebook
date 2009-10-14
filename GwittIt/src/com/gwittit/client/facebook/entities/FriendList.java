package com.gwittit.client.facebook.entities;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

/**
 * Facebook friendlist
 */
public class FriendList extends JavaScriptObject {

    protected FriendList() {
    }

    public final native String getFlidString() /*-{
        return this.flid + "";
    }-*/;

    public final Long getFlid() {
        return new Long ( getFlidString () );
    }

    public final native String getName() /*-{
        return this.name;
    }-*/;
}