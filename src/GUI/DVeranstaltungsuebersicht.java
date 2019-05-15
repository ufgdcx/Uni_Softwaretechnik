package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class DVeranstaltungsuebersicht implements FrameContent{
	private String name = "eingeschriebene Veranstaltungen";
	private GUIMain mainFrame;
	private Listener def = new Listener();

	private JPanel panel = new JPanel();
	private JPanel npanel = new JPanel();
	private JPanel epanel = new JPanel();
	private JPanel spanel = new JPanel();

	private JButton ansehen = new JButton("Veranstaltung ansehen");
	private JButton abmelden = new JButton("Abmelden");
	private JButton hauptseite = new JButton("Veranstaltungsübersicht");

	private JLabel infos = new JLabel("Infos über Veranstaltung"); //Platzhalter für Veranstaltungsinfos aus DB


	String veranstaltungen[] = {"Softwaretechnik", "Betriebssysteme", "Verteilte Systeme"}; //Platzhalter für zugeordnete Veranstaltungen aus DB


	public DVeranstaltungsuebersicht() {

		JList<String> veranstaltungsAuswahl = new JList<String>(veranstaltungen);
		veranstaltungsAuswahl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		//add(new JScrollPane(veranstaltungsAuswahl));

		panel.setLayout(new BorderLayout());
		epanel.setLayout(new GridLayout(3,1));
		spanel.setLayout(new BorderLayout());
		npanel.setLayout(new GridLayout(1,2));

		panel.add(npanel, BorderLayout.NORTH);
		panel.add(veranstaltungsAuswahl, BorderLayout.CENTER);
		panel.add(epanel, BorderLayout.EAST);
		panel.add(spanel, BorderLayout.SOUTH);

		npanel.add(hauptseite);
		npanel.add(abmelden);

		epanel.add(ansehen);

		spanel.add(infos,BorderLayout.CENTER);
		ansehen.addActionListener(def);

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
			if (e.getSource() == ansehen) {
				System.out.println("ansehen");
			}
		}
	}
}
