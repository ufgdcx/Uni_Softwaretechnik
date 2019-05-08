package gui.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;

public class Startseite extends javax.swing.JFrame {
	private static final long serialVersionUID = 5390607598122791520L;

	private Toolkit t;
	private int x = 0, y = 0, width = 800, height = 600;
	
	private JPanel panel = new JPanel();
	private JPanel cpanel = new JPanel();
	private JPanel spanel = new JPanel();
	private JButton login = new JButton("Login");
	private JButton registrieren = new JButton("Registrieren");
	private JTextField email = new JTextField("Test");
	private JPasswordField pwd = new JPasswordField("Test");
	private JLabel pwdLabel = new JLabel("Passwort: ");
	private JLabel mailLabel = new JLabel("E-Mail-Adresse: ");
	
	
	public Startseite() {
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		Dimension d = t.getScreenSize();
		x = (int) ((d.getWidth() - width) / 2);
		y = (int) ((d.getHeight() - height) / 2);
		
		
		setTitle("Startseite");
		setBounds(x,y,width,height);
		
		panel.setLayout(new BorderLayout());
		cpanel.setLayout(new GridLayout(2,2));
		spanel.setLayout(new FlowLayout());
		
		
		panel.add(cpanel, BorderLayout.CENTER);
		panel.add(spanel, BorderLayout.SOUTH);
		
		spanel.add(registrieren);
		spanel.add(login);
		
		cpanel.add(mailLabel);
		cpanel.add(email);
		cpanel.add(pwdLabel);
		cpanel.add(pwd);
		
		this.getContentPane().add(panel);
		pack();
	}
	public static void main(String[] args){
		new Startseite().setVisible(true);
	}
}
