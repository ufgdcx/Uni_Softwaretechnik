package gui.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class DVeranstaltung extends JFrame {
	
	private JPanel panel = new JPanel();
	private JPanel epanel = new JPanel();
	private JPanel cpanel = new JPanel();

	private JButton bearbeiten = new JButton("Informationen bearbeiten");
	private JButton gruppen = new JButton("Gruppen und Teams ansehen");

	private JLabel dozent = new JLabel("Dozent der Veranstaltung"); //Platzhalter für verantwortlichen Dozenten aus DB
	private JLabel infos = new JLabel("Infos über Veranstaltung"); //Platzhalter für Veranstaltungsinfos aus DB
	
	String veranstaltungen[] = {"Softwaretechnik", "Betriebssysteme", "Verteilte Systeme"}; //Platzhalter für eingeschriebene Veranstaltungen aus DB
		
	
	public DVeranstaltung(int width, int height) {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		panel.setLayout(new BorderLayout());
		epanel.setLayout(new GridLayout(2,1));
		cpanel.setLayout(new GridLayout(2,1));

		
		panel.add(cpanel, BorderLayout.CENTER);
		panel.add(epanel, BorderLayout.EAST);

		epanel.add(bearbeiten);
		epanel.add(gruppen);
		
		cpanel.add(infos);
		cpanel.add(dozent);

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Veranstaltung");       
        this.getContentPane().add(panel);
        this.setSize(width, height);
        this.setVisible(true);

	}
	
	
	public static void main(String[] args){
		new DVeranstaltung(500,400);
	}
	
}
