package Controller;

import GUI.*;
import Klassen.*;

public class MainController {
	private GUIMain mainFrame;
	private Nutzer n;
	
	public MainController(GUIMain m) {
		mainFrame = m;
		//render GUI for login
		//handle authentification
		//TODO
		//n = getUserInfo();
		
		//switch to StudentController or DozentController
		if(n instanceof Dozent){
			//TODO
		}
		else{
			//creating student to pass the info to StudentController
			Student s = new Student();
			//transforming Nutzer object n to Student object s
			//TODO
			new StudentController(mainFrame,s);
		}
	}
}
