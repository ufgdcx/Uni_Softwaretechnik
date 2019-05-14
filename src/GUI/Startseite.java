package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Startseite implements FrameContent{
	private String name = "Startseite";
	
	private JPanel panel = new JPanel();
	private JPanel cpanel = new JPanel();
	private JPanel spanel = new JPanel();
	private JButton login = new JButton("Login");
	private JButton registrieren = new JButton("Registrieren");
	private JTextField email = new JTextField("Test");
	private JPasswordField pwd = new JPasswordField("Test");
	private JLabel pwdLabel = new JLabel("Passwort: ");
	private JLabel mailLabel = new JLabel("E-Mail-Adresse: ");
	private Listener def = new Listener();

	public Startseite() {
		
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
		
		login.addActionListener(def);
		registrieren.addActionListener(def);
	}
	
	public String getName(){
		return name;
	}
	public JPanel getPanel(){
		return panel;
	}

	private class Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==login){
				//System.out.println("login button pressed");
				
			}
			if(e.getSource()==registrieren){
				System.out.println("registrieren");
			}
		}
	}

}