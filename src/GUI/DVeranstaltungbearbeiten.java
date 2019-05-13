package gui.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class DVeranstaltungbearbeiten extends JFrame {
	
	private JPanel panel = new JPanel();
	private JPanel epanel = new JPanel();
	private JPanel cpanel = new JPanel();

	private JButton bestaetigen = new JButton("Änderungen bestätigen");
	private JButton abbrechen = new JButton("abbrechen");

	private JTextArea dozent = new JTextArea("Dozent der Veranstaltung"); //Platzhalter für verantwortlichen Dozenten aus DB
	private JTextArea infos = new JTextArea("Infos über Veranstaltung"); //Platzhalter für Veranstaltungsinfos aus DB
	
	String veranstaltungen[] = {"Softwaretechnik", "Betriebssysteme", "Verteilte Systeme"}; //Platzhalter für eingeschriebene Veranstaltungen aus DB
		
	
	public DVeranstaltungbearbeiten(int width, int height) {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		panel.setLayout(new BorderLayout());
		epanel.setLayout(new GridLayout(2,1));
		cpanel.setLayout(new GridLayout(2,1));

		
		panel.add(cpanel, BorderLayout.CENTER);
		panel.add(epanel, BorderLayout.EAST);

		epanel.add(bestaetigen);
		epanel.add(abbrechen);
		
		cpanel.add(infos);
		cpanel.add(dozent);

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Veranstaltung bearbeiten");       
        this.getContentPane().add(panel);
        this.setSize(width, height);
        this.setVisible(true);

	}
	
	
	public static void main(String[] args){
		new DVeranstaltungbearbeiten(500,400);
	}
	
}
