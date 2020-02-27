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
public class TtestDB extends ConsoleProgram {
	private FacePamphletDatabase friendsdb;
	private FacePamphletProfile currentProfile;
public void run() {
	friendsdb=new FacePamphletDatabase();
	currentProfile=new FacePamphletProfile("Joe"); 
	println(currentProfile.getName());
	friendsdb.addProfile(currentProfile);
	if (friendsdb.containsProfile("Joe")) { println("success");} else {
		println("failure");
	}
	
}

}

