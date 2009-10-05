package com.gwittit.client.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwittit.client.Config;
import com.gwittit.client.facebook.ApiFactory;
import com.gwittit.client.facebook.FacebookApi;
import com.gwittit.client.facebook.entities.Album;
import com.gwittit.client.facebook.xfbml.FbPhoto;
import com.gwittit.client.facebook.xfbml.Xfbml;

public class Photos_getAlbums extends Example {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Display albums of current logged in user";
	}

	@Override
	public String getHeader() {
		return "photos.getAlbums";
	}

	
	
	
	public Widget createWidget () {
		
		final VerticalPanel outer = new VerticalPanel ();

		outer.add( getLoader () );
		outer.getElement().setId( "ShowPhotosGetAlbums");
		
		Map<String,String> params = new HashMap<String,String> ();
		
		// Call facebook
		apiClient.photos_getAlbums(params, new AsyncCallback<List<Album>> () {

			public void onFailure(Throwable caught) {
				handleFailure ( caught );
			}

			public void onSuccess(List<Album> result) {
				outer.remove( getLoader () );
				for ( Album a : result ) {
					String html ="Name: " + a.getName() + ", Description: " + a.getDescription(); 
					outer.add ( new HTML ( html ) );
					outer.add ( new FbPhoto ( a.getCoverPid() ) );
				}
				Xfbml.parse(outer);
			}
			
		});
		
		return outer;
	}
	
}