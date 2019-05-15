package Controller;

import Database.*;
import GUI.*;
import Klassen.*;

public class MainController {
	private GUIMain mainFrame;
	private Nutzer n;
	private DBrequest dbr = new DBrequest();
	
	public MainController(GUIMain m) {
		mainFrame = m;
		//render GUI for login
		//handle authentification
		String email = "test";
		String passwd = "test";
		n = dbr.getNutzer(email,passwd);
		
		//switch to StudentController or DozentController
		if(n instanceof Dozent){
			//TODO
		}
		else{
			//creating student to pass the info to StudentController
			Student s;
			//transforming Nutzer object n to Student object s
			//TODO
			new StudentController(mainFrame,s);
		}
	}
}
