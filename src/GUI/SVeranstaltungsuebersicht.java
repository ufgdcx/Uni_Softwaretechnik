package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class SVeranstaltungsuebersicht implements FrameContent {
	private String name = "Veranstaltungsübersicht";
	private GUIMain mainFrame;
	private Listener def = new Listener();

	private JPanel panel = new JPanel();
	private JPanel epanel = new JPanel();
	private JPanel spanel = new JPanel();

	private JButton leistungen = new JButton("Leistungen ansehen");
	private JButton gruppen = new JButton("Gruppen & Teams ansehen");
	private JButton hinzufuegen = new JButton("Veranstaltung hinzufügen");

	private JLabel infos = new JLabel("Infos über Veranstaltung"); //Platzhalter für Veranstaltungsinfos aus DB
	
	String veranstaltungen[] = {"Softwaretechnik", "Betriebssysteme", "Verteilte Systeme"}; //Platzhalter für eingeschriebene Veranstaltungen aus DB
		
	
	public SVeranstaltungsuebersicht() {

		JList<String> veranstaltungsAuswahl = new JList<String>(veranstaltungen);
		veranstaltungsAuswahl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		veranstaltungsAuswahl.add(new JScrollPane());
		
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

		leistungen.addActionListener(def);
		gruppen.addActionListener(def);
		hinzufuegen.addActionListener(def);
	}
	public String getName(){
		return name;
	}
	public JPanel getPanel(){
		return panel;
	}
	public void setParentFrame(GUIMain p){
		mainFrame = p;
	}

	private class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == leistungen) {
				System.out.println("leistungen");
			}
			if (e.getSource() == gruppen) {
				System.out.println("gruppen");
			}
			if (e.getSource() == hinzufuegen) {
				System.out.println("hinzufuegen");
			}
		}
	}

}
