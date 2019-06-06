package adminGui;

import Klassen.Dozent;
import Klassen.Veranstaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane;
	DefaultListModel listModel = new DefaultListModel();
	JList<String> dozentenlist;

	private JButton confirmButton;
	private JButton dozentenButton;
	private JButton abortButton;
	private JTextField veranstaltungsnameField;
	private JTextField fakultaetField;
	private JTextField teamzahlJeGruppeField;
	private JTextField teilnehmerzahlJeTeamField;
	private JTextArea beschreibungField;

	JList<String> Dozenten;

	public EditDialog(Veranstaltung veranstaltung) {
		setModal(true);
		setSize(700, 350);
		setLayout(null);
		
		JLabel veranstaltungsnameLabel = new JLabel("Name:");
		veranstaltungsnameLabel.setBounds(30, 10, 200, 25);
		add(veranstaltungsnameLabel);
		veranstaltungsnameField = new JTextField();
		veranstaltungsnameField.setBounds(30, 30, 200, 25);
		veranstaltungsnameField.setText(veranstaltung.getName());
		add(veranstaltungsnameField);
		
		JLabel fakultaetLabel = new JLabel("Fakultät:");
		fakultaetLabel.setBounds(30, 70, 200, 25);
		add(fakultaetLabel);
		fakultaetField = new JTextField();
		fakultaetField.setBounds(30, 90, 200, 25);
		fakultaetField.setText(veranstaltung.getFakultaet());
		add(fakultaetField);
		
		JLabel teamzahlJeGruppeLabel = new JLabel("Maximale Teams pro Gruppe:");
		teamzahlJeGruppeLabel.setBounds(30, 130, 200, 25);
		add(teamzahlJeGruppeLabel);
		teamzahlJeGruppeField = new JTextField();
		teamzahlJeGruppeField.setBounds(30, 150, 200, 25);
		teamzahlJeGruppeField.setText(Integer.toString(veranstaltung.getTeamanzahl()));
		add(teamzahlJeGruppeField);
		
		JLabel teilnehmerzahlJeTeamLabel = new JLabel("maximale Mitglieder pro Team:");
		teilnehmerzahlJeTeamLabel.setBounds(30, 190, 200, 25);
		add(teilnehmerzahlJeTeamLabel);
		teilnehmerzahlJeTeamField = new JTextField();
		teilnehmerzahlJeTeamField.setBounds(30, 210, 200, 25);
		teilnehmerzahlJeTeamField.setText(Integer.toString(veranstaltung.getMaxTeilnehmer()));
		add(teilnehmerzahlJeTeamField);
		
		JLabel beschreibungLabel = new JLabel("Beschreibung:");
		beschreibungLabel.setBounds(250, 10, 200, 25);
		add(beschreibungLabel);
		beschreibungField = new JTextArea();
		beschreibungField.setBounds(250, 30, 200, 205);
		beschreibungField.setText(veranstaltung.getBeschreibung());
		add(beschreibungField);

		JLabel DozentenLabel = new JLabel("Dozenten:");
		DozentenLabel.setBounds(470, 10, 200, 25);
		add(DozentenLabel);
		dozentenlist = new JList<String>(listModel);
		dozentenlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for(Dozent d: veranstaltung.getDozenten()){
			listModel.add(0,d.getEmail());
		}
		JScrollPane scrollPane = new JScrollPane(dozentenlist);
		scrollPane.setBounds(470, 30, 200, 175);
		add(scrollPane);

		dozentenButton = new JButton("Dozenten hinzufügen/löschen");
		dozentenButton.setFocusable(false);
		dozentenButton.setBounds(465, 210, 210, 25);
		dozentenButton.addActionListener(new Listener());
		add(dozentenButton);

		abortButton = new JButton("abbrechen");
		abortButton.setFocusable(false);
		abortButton.setBounds(150, 270, 150, 25);
		abortButton.addActionListener(new Listener());
		add(abortButton);

		confirmButton = new JButton("OK");
		confirmButton.setFocusable(false);
		confirmButton.setBounds(350, 270, 150, 25);
		confirmButton.addActionListener(new Listener());
		add(confirmButton);
		
	}

private class Listener implements ActionListener{

		Listener(){
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==abortButton) {
				dispose();
			}
			if(e.getSource()==dozentenButton) {
				DozentenAddRemoveDialog dARD = new DozentenAddRemoveDialog();
				dARD.setResizable(false);
				dARD.setLocationRelativeTo(null);
				dARD.setVisible(true);
			}
		}
		
	}
}