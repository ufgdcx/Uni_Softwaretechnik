package gui.swing;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;

public class GUIMain extends javax.swing.JFrame {
	private static final long serialVersionUID = -4809967054110045268L;
	
	private Toolkit t;
	private int x = 0, y = 0, width = 800, height = 600;
		
	public GUIMain() {
		t = Toolkit.getDefaultToolkit();

		Dimension d = t.getScreenSize();
		x = (int) ((d.getWidth() - width) / 2);
		y = (int) ((d.getHeight() - height) / 2);
		
		
		setTitle("Startseite");
		setBounds(x,y,width,height);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args){
		new GUIMain();
	}
}
