package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class SAlleVeranstaltungen implements FrameContent {
	private String name = "Veranstaltung bearbeiten";
	private GUIMain mainFrame;
	private Listener def = new Listener();

	private JPanel panel = new JPanel();
	private JPanel epanel = new JPanel();
	private JPanel spanel = new JPanel();

	private JButton einschreiben = new JButton("in Veranstaltung einschreiben");

	private JLabel infos = new JLabel("Infos über Veranstaltung"); //Platzhalter für Veranstaltungsinfos aus DB
	
	String veranstaltungen[] = {"Softwaretechnik", "Betriebssysteme", "Verteilte Systeme", "Computergraphik", "Modellbildung und Simulation"}; //Platzhalter für alle Veranstaltungen aus DB
		
	
	public SAlleVeranstaltungen() {

		JList<String> veranstaltungsAuswahl = new JList<String>(veranstaltungen);
		veranstaltungsAuswahl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		//add(new JScrollPane(veranstaltungsAuswahl));
		
		panel.setLayout(new BorderLayout());
		//epanel.setLayout(new GridLayout(3,1));
		spanel.setLayout(new BorderLayout());

		panel.add(veranstaltungsAuswahl, BorderLayout.CENTER);
		panel.add(epanel, BorderLayout.EAST);
		panel.add(spanel, BorderLayout.SOUTH);


		epanel.add(einschreiben);
		
		spanel.add(infos,BorderLayout.CENTER);

		einschreiben.addActionListener(def);
	}
	public String getName() {
		return name;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setParentFrame(GUIMain p) {
		mainFrame = p;
	}

	private class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == einschreiben) {
				System.out.println("einschreiben");
			}
		}
	}
}