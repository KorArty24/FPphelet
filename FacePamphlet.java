/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class FacePamphlet extends Program 
					implements FacePamphletConstants {

	
	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init() {
		// You fill this in
		canvas = new FacePamphletCanvas();
		add(canvas);
		changeStatus=new JTextField("",TEXT_FIELD_SIZE);
		changePicture=new JTextField("",TEXT_FIELD_SIZE);
		addFriend =new JTextField("",TEXT_FIELD_SIZE);
		name= new JTextField("",TEXT_FIELD_SIZE);
		changeStatus.setActionCommand("Change Status");
		changePicture.setActionCommand("Change Picture");
		addFriend.setActionCommand("Add Friend");
		add (new JButton("Change Status"), WEST);
		add(changeStatus,WEST);
		add(new JLabel(EMPTY_LABEL_TEXT),WEST);
		add (new JButton ("Change Picture"), WEST);
		add(changePicture,WEST);
		add(new JLabel(EMPTY_LABEL_TEXT),WEST);
		add (new JButton ("Add Friend"), WEST);
		add(addFriend,WEST);
		add(new JLabel("Name"),NORTH);
		add(name,NORTH);
		add(new JButton("Add"),NORTH);
		add(new JButton("Delete"),NORTH);
		add(new JButton("Lookup"),NORTH);
		
		changeStatus.addActionListener(this);
		friendsdb=new FacePamphletDatabase();
		addActionListeners();
		
    }
    
  
    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e) {
		// You fill this in as well as add any additional methods
    	
    	String cmd=e.getActionCommand();
    	if(cmd.equals("Change Status")) {
    		
    		String current_status=changeStatus.getText();
    		if (currentProfile!=null) {
    			currentProfile.setStatus(current_status);
    			System.out.println(currentProfile.getStatus());
    			update();
    		}
    			
    	} else if (cmd.equals("Change Picture")) {
    		
    		if (currentProfile!=null) {
    			fileopen();
    			currentProfile.setImage(photo);
    			update();
    			
    		} else { /*To be implemented further*/}
    		
    		
    	} else if (cmd.equals("Add Friend")) {
    		String friend=addFriend.getText();
   if (false)	{Iterator<String> iter=currentProfile.getFriends();
    		ArrayList<String> friendlst =new ArrayList<>();}
   
    		if (currentProfile!=null) {
    			if (friendsdb.containsProfile(friend)) {
    				currentProfile.addFriend(friend);
    				FacePamphletProfile	friendprofile=friendsdb.getProfile(friend);
    				friendprofile.addFriend(currentProfile.getName());
    				update();
    			} else System.out.println("No such profile! Please choose the right profile");
    		}
    		
    	} else if (cmd.equals("Add")) {
    		
    		String new_name=name.getText();
    		System.out.println(new_name);
    		if (friendsdb.containsProfile(new_name)) {
    		currentProfile=friendsdb.getProfile(new_name);	
    		canvas.displayProfile(currentProfile);
    		update();
    		
    		} else { 
    		currentProfile = new FacePamphletProfile(new_name);
    		friendsdb.addProfile(currentProfile);
    		if (friendsdb.containsProfile(new_name)) System.out.println("success");} 
    		update();
    		
    	} else if (cmd.equals("Delete")) {
    		if (currentProfile!=null) {
    		friendsdb.deleteProfile(currentProfile.getName());
    		
    		currentProfile=null;
    		}
    	} else if (cmd.equals("Lookup")) {
    		String new_name=name.getText();
    		if (friendsdb.containsProfile(new_name)) {
    			currentProfile=friendsdb.getProfile(new_name);
    			System.out.println(currentProfile.getName());
    		if (currentProfile!=null) {canvas.displayProfile(currentProfile);} else {}
    			
    		}	
    		}
    		
    	}
 
	
    private void fileopen() {
    	try {
    		photo =null;
    		JFileChooser chooser = new JFileChooser();
    	      in = null;
    	      if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
    	      {
    	         File selectedFile = chooser.getSelectedFile();
    	         in = new Scanner(selectedFile);
    	         photo=new GImage(selectedFile.getAbsolutePath());
    	      }
    	      
    	} 
    	catch (IOException exception)
    	{
    		System.out.println("Could not open input file");
    	}		
    	
    }
    
    private void update() {
    	
    	canvas.displayProfile(currentProfile);
    	
    	
    }
    
    /*Private instance variables*/
	private JTextField changeStatus;
	private JTextField changePicture;
	private JTextField addFriend;
	private JTextField name;
	private FacePamphletProfile currentProfile;
	private FacePamphletProfile	friendprofile;
	private FacePamphletDatabase friendsdb;
	private Scanner in;
	private GImage photo;
	private FacePamphletCanvas canvas;
}
