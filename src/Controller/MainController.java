package Controller;

import Database.*;
import GUI.*;
import Klassen.*;

public class MainController {
	protected GUIMain mainFrame;
	private Nutzer n;
	protected DBrequest dbr = new DBrequest();
	
	public MainController(GUIMain m) {
		mainFrame = m;
		mainFrame.setController(this);
	}
	
	public void login(String email, char[] passwd) {
		//handle authentification
		try {
			n = dbr.getNutzer(email,passwd);
		} catch (DatabaseException e) {
			e.printStackTrace();
			System.out.println(e);
            return;
		}
		
		//switch to StudentController or DozentController
		if(n instanceof Dozent){
			//creating Dozent object d to pass the info to DozentController
			//and transforming Nutzer object n to Dozent object d
			Dozent d = (Dozent) n;
			new DozentController(mainFrame,d);

		}
		else{
			//creating Student object s to pass the info to StudentController
			//and transforming Nutzer object n to Student object s
			Student s = (Student) n;
			
			//Student s = new Student("abc@uni-rostock.it","1234","Lord","Hanz","Mueller","Verteidigung gegen die Dunklen Kuenste",987654321);
			new StudentController(mainFrame,s);
		}
	}
}
