package com.gwittit.client.facebook.entities;

import java.util.Date;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwittit.client.DebugLink;
import com.gwittit.client.facebook.xfbml.FbName;
import com.gwittit.client.facebook.xfbml.FbProfilePic;

/**
 * Defines a facebook stream. See
 * http://wiki.developers.facebook.com/index.php/Stream_%28FQL%29 Stream Table
 */
public class Stream {

	/**
	 * The ID of the post from the user's stream. This field, when used as an
	 * index, is primarily used to re-retrieve posts. Otherwise, it is used to
	 * specify a post when using any of the stream setters.
	 */
	private String postId;

	/**
	 * The ID of the user whose stream you are querying. The viewer_id defaults
	 * to the active session key.
	 */
	private Long viewerId;

	/**
	 * The application ID for the application through which the post was
	 * published. This includes application IDs for FB apps (like Photos and
	 * Videos).
	 */
	private Long appId;

	/**
	 * The ID of the user or Page whose posts you want to retrieve. This
	 * includes both posts that the user or Page has authored (that is, the
	 * actor_id is the source_id) and posts that have been directed at this user
	 * or Page (that is, the target_id is the source_id).
	 */
	private Long sourceId;

	/**
	 * The time the post was last updated, which includes users adding comments
	 * or liking the post.
	 */
	private Date updatedTime;

	/**
	 * The time the post was published to the user's stream.
	 */
	private Date createdTime;

	/**
	 * The filter key to fetch data with. This key should be retrieved from
	 * stream.getFilters or querying the stream_filter FQL table.
	 */
	private String filterKey;

	/**
	 * For posts published by applications, this is the string that states
	 * through which application the post was published. For example,
	 * "Joe loves the Social Web (by MicroBloggerApp)."
	 */
	private String attribution;

	/**
	 * The user ID of the person who is the user taking the action in the post.
	 */
	private String actorId;
	
	/**
	 * The user or Page to whom the post was directed. 
	 */
	private String targetId;

	/**
	 * The message written by the user.
	 */
	private String message;

	
	/**
	 * An array of information about the attachment to the post. This is the attachment that Facebook returns. 
	 */
	private Attachment attachment;
	
	/**
	 * Todo
	 */
	// private Comments comments ;
	
	/**
	 * An array of likes associated with the post. The array contains the following fields: 
	 */
	private Likes likes;
	
	
	/**
	 * The original object. Used for debuging.
	 */
	private JSONObject wrappedObject;


	/**
	 * Experimental , let the stream object create a default widget to use.
	 */
	public Widget createWidget () {

		final VerticalPanel stream = new VerticalPanel ();
		stream.addStyleName ("stream");
		
		
		final HorizontalPanel message= new HorizontalPanel ();
		
		final FbProfilePic profilePic = new FbProfilePic ( getSourceId()  );
		final FbName fbName = new FbName ( getSourceId() );
		
		final HorizontalPanel text = new HorizontalPanel ();
		text.addStyleName ( "text" );
		text.add( new HTML ( fbName.toString() + " " +getMessage() ) );
	
		message.add ( profilePic );
		message.add ( text );

		stream.add ( message );
		
		// Actions , like etc.
		HorizontalPanel actions = new HorizontalPanel ();
		actions.addStyleName ( "actions" );
		actions.add  ( new DebugLink ( getWrappedObject()+""));
		stream.add ( actions );
		
		// Likes
		HorizontalPanel feedBack = new HorizontalPanel ();
		
		if ( likes.getCount() > 0 ) {
			feedBack.addStyleName ( "feedBack" );
			feedBack.add ( likes.createWidget() );
			stream.add ( feedBack );
		}
		
		return stream;

	}
	/**
	 * Create a new Stream object from json object
	 */
	public static Stream newInstance ( JSONObject o ) {
		Stream i = new Stream ();

		i.wrappedObject = o;
		i.postId = JsonUtil.getString(o, "post_id" );
		i.viewerId = JsonUtil.getLong(o, "viewer_id" );
		i.appId = JsonUtil.getLong(o, "app_id");
		i.sourceId = JsonUtil.getLong(o, "source_id");
		i.updatedTime = JsonUtil.getDate(o, "updated_time");
		i.createdTime = JsonUtil.getDate(o, "created_time");
		i.filterKey = JsonUtil.getString(o, "filter_key");
		i.attribution = JsonUtil.getString (o, "attribution" );
		i.actorId = JsonUtil.getString(o,"actor_id");
		i.targetId = JsonUtil.getString(o, "target_id");
		i.message = JsonUtil.getString(o, "message");
		
		//JsonUtil.debug( o.get("attachment" ).isObject() );
		
		//attachment = Attachment.newInstance ( o.get("attachment").isObject() );
		i.likes = Likes.newInstance ( o.get("likes" ) );
		return i;
		
	}
	
	public String getPostId() {
		return postId;
	}


	public void setPostId(String postId) {
		this.postId = postId;
	}


	public Long getViewerId() {
		return viewerId;
	}


	public void setViewerId(Long viewerId) {
		this.viewerId = viewerId;
	}


	public Long getAppId() {
		return appId;
	}


	public void setAppId(Long appId) {
		this.appId = appId;
	}


	public Long getSourceId() {
		return sourceId;
	}


	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}


	public Date getUpdatedTime() {
		return updatedTime;
	}


	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}


	public Date getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}


	public String getFilterKey() {
		return filterKey;
	}


	public void setFilterKey(String filterKey) {
		this.filterKey = filterKey;
	}


	public String getAttribution() {
		return attribution;
	}


	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}


	public String getActorId() {
		return actorId;
	}


	public void setActorId(String actorId) {
		this.actorId = actorId;
	}


	public String getTargetId() {
		return targetId;
	}


	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Attachment getAttachment() {
		return attachment;
	}


	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}


	public Likes getLikes() {
		return likes;
	}


	public void setLikes(Likes likes) {
		this.likes = likes;
	}


	public JSONObject getWrappedObject() {
		return wrappedObject;
	}


	public void setWrappedObject(JSONObject wrappedObject) {
		this.wrappedObject = wrappedObject;
	}
}
