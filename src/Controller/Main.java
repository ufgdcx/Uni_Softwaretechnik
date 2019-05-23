package Controller;

import GUI.*;

public class Main {
	
	public static void main(String[] args) {
		//GUIMain renders the main window, which is then filled with content
		//new GUIMain(800,600);
		new MainController(new GUIMain(800,600));
		return;
	}
}
