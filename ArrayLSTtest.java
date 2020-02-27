import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ArrayLSTtest extends ConsoleProgram {
public void run() {
	ArrayList<String> rls = new ArrayList<>();
	rls.add("AA");
	rls.add("BB");
	rls.add("CC");
	rls.add("Dub");
	if (rls.remove("TT")==true) {
		println("Success");
	} else {
		println("You loose");
	}
	for (String element : rls) println(element);
	}
	
}

