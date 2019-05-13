package gui.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class SVeranstaltungsuebersicht extends JFrame {
	
	private JPanel panel = new JPanel();
	private JPanel epanel = new JPanel();
	private JPanel spanel = new JPanel();

	private JButton leistungen = new JButton("Leistungen ansehen");
	private JButton gruppen = new JButton("Gruppen & Teams ansehen");
	private JButton hinzufuegen = new JButton("Veranstaltung hinzuf�gen");

	private JLabel infos = new JLabel("Infos �ber Veranstaltung"); //Platzhalter f�r Veranstaltungsinfos aus DB
	
	String veranstaltungen[] = {"Softwaretechnik", "Betriebssysteme", "Verteilte Systeme"}; //Platzhalter f�r eingeschriebene Veranstaltungen aus DB
		
	
	public SVeranstaltungsuebersicht(int width, int height) {
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
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Veranstaltungs�bersicht");       
        this.getContentPane().add(panel);
        this.setSize(width, height);
        this.setVisible(true);

	}
	
	
	public static void main(String[] args){
		new SVeranstaltungsuebersicht(500,400);
	}
	
}
