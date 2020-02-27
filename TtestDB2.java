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
public class TtestDB2 extends Program implements FacePamphletConstants {
	private FacePamphletDatabase friendsdb;
	private FacePamphletProfile currentProfile;
	private FacePamphletCanvas canvas;
public void run() {
	canvas = new FacePamphletCanvas();
	add(canvas);
	friendsdb=new FacePamphletDatabase();
	currentProfile=new FacePamphletProfile("Joe"); 
	println(currentProfile.getName());
	friendsdb.addProfile(currentProfile);
	if (friendsdb.containsProfile("Joe")) { println("success");} else {
		println("failure");
		canvas.displayProfile(currentProfile);
	}
	
}

}

