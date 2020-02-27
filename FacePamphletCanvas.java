/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */


import acm.graphics.*;
import java.awt.*;
import java.util.*;

public class FacePamphletCanvas extends GCanvas 
					implements FacePamphletConstants {
	
	
	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the display
	 */
	public FacePamphletCanvas() {
		// You fill this in
	}

	
	/** 
	 * This method displays a message string near the bottom of the 
	 * canvas.  Every time this method is called, the previously 
	 * displayed message (if any) is replaced by the new message text 
	 * passed in.
	 */
	public void showMessage(String msg) {
		// You fill this in
	}
	
	
	/** 
	 * This method displays the given profile on the canvas.  The 
	 * canvas is first cleared of all existing items (including 
	 * messages displayed near the bottom of the screen) and then the 
	 * given profile is displayed.  The profile display includes the 
	 * name of the user from the profile, the corresponding image 
	 * (or an indication that an image does not exist), the status of
	 * the user, and a list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {
		removeAll();
		/*if (profile!=null) {*/
		drawPhotoFrame(LEFT_MARGIN, (TOP_MARGIN+40),IMG_WDTH, IMG_HGHT);
		addPhoto(profile);
		drawProfileName(profile);		
		GLabel status=new GLabel(profile.getStatus(), LEFT_MARGIN,(TOP_MARGIN+PROFILE_TXT_HGHT+20+IMG_HGHT+STATUS_MARGIN));
		status.setFont(PROFILE_STATUS_FONT);
		add(status);
		drawfriendlist(profile);
	}
	
	private void addPhoto(FacePamphletProfile profile) {
		GImage photo =profile.getImage(); 
		if (photo!=null) {
		photo.setLocation(LEFT_MARGIN, TOP_MARGIN+40);
		photo.setSize(IMG_WDTH,IMG_HGHT);
		add(photo);}
	}
	
	private void drawProfileName (FacePamphletProfile profile) {
		GLabel profile_name= new GLabel(profile.getName(),LEFT_MARGIN,(TOP_MARGIN+PROFILE_TXT_HGHT));
		profile_name.setColor(Color.blue);
		profile_name.setFont(PROFILE_NAME_FONT);
		add(profile_name);
		
	}
	private void drawfriendlist(FacePamphletProfile aprofile) {
		Iterator<String> iter=aprofile.getFriends();
		int i=0;
		int y=100;
		while (iter.hasNext()) {
			if(iter.hasNext()) 
			{i+=i+1;
			y=y+20;
			}
		
		GLabel titlefriendlst=new GLabel("Friends",450, 70);
		titlefriendlst.setFont(PROFILE_FRIEND_LABEL_FONT);
		add (titlefriendlst);
		GLabel frdlst=new GLabel(iter.next(),450,y);
		frdlst.setFont(PROFILE_FRIEND_FONT);
		add(frdlst);
		
		}
	}
	private void drawPhotoFrame(double x, double y, double width, double height) {
		add (new GRect(x,y, width,height));
		GLabel emptyPhoto = new GLabel("Add Photo",x+IMG_WDTH/4,y+IMG_HGHT/2);
		emptyPhoto.setFont(MESSAGE_FONT);
		add(emptyPhoto);
	}
	
	
}
