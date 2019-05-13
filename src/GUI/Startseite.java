package GUI;

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
	
	
	public Startseite(int width, int height) {
		
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
		
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Startseite");       
        this.getContentPane().add(panel);       
        this.setSize(width, height);
        this.setVisible(true);
	}
	public static void main(String[] args){
		new Startseite(500,400);
	}
}
