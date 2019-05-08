package gui.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Startseite extends JFrame {

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
		setBounds(200,200,600,400);
		
		
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
