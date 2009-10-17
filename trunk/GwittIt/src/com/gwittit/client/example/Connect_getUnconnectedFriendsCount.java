package com.gwittit.client.example;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Connect_getUnconnectedFriendsCount extends Showcase {

    public Connect_getUnconnectedFriendsCount () {
        super ( "connect.getUnconnectedFriendsCount" );
    }
    
    public Widget createWidget () {
        final VerticalPanel outer = new VerticalPanel ();
     
        addLoader ( outer );
        
        apiClient.connect_getUnconnectedFriendsCount (new AsyncCallback<Integer> () {

            public void onFailure(Throwable caught) {
                handleFailure ( caught );
            }

            public void onSuccess(Integer result) {
                removeLoader ( outer );
                outer.add ( new HTML ( "<h4>Unconnected Friends Count</h4>" ) );
                outer.add ( new HTML ( "Result : " + result ) ) ;
            }
            
        });
        
        return outer;
    }
}
