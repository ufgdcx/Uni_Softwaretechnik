package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class DVeranstaltungsuebersicht extends JFrame {
	
	private JPanel panel = new JPanel();
	private JPanel epanel = new JPanel();
	private JPanel spanel = new JPanel();

	private JButton ansehen = new JButton("Veranstaltung ansehen");
	
	private JLabel infos = new JLabel("Infos über Veranstaltung"); //Platzhalter für Veranstaltungsinfos aus DB


	String veranstaltungen[] = {"Softwaretechnik", "Betriebssysteme", "Verteilte Systeme"}; //Platzhalter für zugeordnete Veranstaltungen aus DB
		
	
	public DVeranstaltungsuebersicht(int width, int height) {
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

		epanel.add(ansehen);

		
		spanel.add(infos,BorderLayout.CENTER);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Veranstaltungsübersicht");       
        this.getContentPane().add(panel);
        this.setSize(width, height);
        this.setVisible(true);

	}
	
	
	public static void main(String[] args){
		new DVeranstaltungsuebersicht(500,400);
	}
	
}
