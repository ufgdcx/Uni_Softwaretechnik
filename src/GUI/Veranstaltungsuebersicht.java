package gui.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Veranstaltungsuebersicht extends JFrame {
	
	private JPanel panel = new JPanel();
	private JPanel epanel = new JPanel();
	private JPanel spanel = new JPanel();

	private JButton leistungen = new JButton("Leistungen ansehen");
	private JButton gruppen = new JButton("Gruppen & Teams ansehen");
	private JButton hinzufuegen = new JButton("Veranstaltung hinzufügen");

	private JLabel infos = new JLabel("Infos über Veranstaltung"); //Platzhalter für Veranstaltungsinfos aus DB
	
	String veranstaltungen[] = {"Softwaretechnik", "Betriebssysteme", "Verteilte Systeme"}; //Platzhalter für eingeschriebene Veranstaltungen aus DB
		
	
	public Veranstaltungsuebersicht() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		
		JList<String> veranstaltungsAuswahl = new JList<String>(veranstaltungen);
		veranstaltungsAuswahl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		add(new JScrollPane(veranstaltungsAuswahl));
		
		panel.setLayout(new BorderLayout());
		epanel.setLayout(new GridLayout(3,1));
		spanel.setLayout(new BorderLayout());

		
		panel.add(veranstaltungsAuswahl, BorderLayout.CENTER);
		panel.add(epanel, BorderLayout.EAST);
		panel.add(spanel, BorderLayout.SOUTH);

		epanel.add(gruppen);
		epanel.add(leistungen);
		epanel.add(hinzufuegen);
		
		spanel.add(infos,BorderLayout.CENTER);
		
		
		this.getContentPane().add(panel);
		pack();

	}
	
	
	public static void main(String[] args){
		new Veranstaltungsuebersicht().setVisible(true);
	}
	
}
