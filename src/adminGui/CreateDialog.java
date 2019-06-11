package adminGui;

import Database.DBrequest;
import Database.DatabaseException;
import Klassen.Dozent;
import Klassen.Veranstaltung;
import utilities.FileHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class CreateDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private DefaultListModel listModel = new DefaultListModel();
	private JList<String> dozentenlist;
	private Veranstaltung veranstaltung;

	private DBrequest dbrequest = DBrequest.getIntstance();
	private FileHandler<Veranstaltung> filehandler = new FileHandler<>();

	private JButton confirmButton;
	private JButton dozentenButton;
	private JButton dataButton;
	private JButton abortButton;
	private JTextField veranstaltungsnameField;
	private JTextField fakultaetField;
	private JTextField teamzahlJeGruppeField;
	private JTextField teilnehmerzahlJeTeamField;
	private JTextArea beschreibungField;
	
	JList<String> Dozenten;
	
	public CreateDialog() {
        veranstaltung = new Veranstaltung("", "",0,0, "");
        veranstaltung.setDozenten(new ArrayList<>());
		setModal(true);
		setSize(700, 350);
		setLayout(null);
		
		JLabel veranstaltungsnameLabel = new JLabel("Name:");
		veranstaltungsnameLabel.setBounds(30, 10, 200, 25);
		add(veranstaltungsnameLabel);
		veranstaltungsnameField = new JTextField();
		veranstaltungsnameField.setBounds(30, 30, 200, 25);
		add(veranstaltungsnameField);
		
		JLabel fakultaetLabel = new JLabel("Fakultät:");
		fakultaetLabel.setBounds(30, 70, 200, 25);
		add(fakultaetLabel);
		fakultaetField = new JTextField();
		fakultaetField.setBounds(30, 90, 200, 25);
		add(fakultaetField);
		
		JLabel teamzahlJeGruppeLabel = new JLabel("Maximale Teams pro Gruppe:");
		teamzahlJeGruppeLabel.setBounds(30, 130, 200, 25);
		add(teamzahlJeGruppeLabel);
		teamzahlJeGruppeField = new JTextField();
		teamzahlJeGruppeField.setBounds(30, 150, 200, 25);
		add(teamzahlJeGruppeField);
		
		JLabel teilnehmerzahlJeTeamLabel = new JLabel("maximale Mitglieder pro Team:");
		teilnehmerzahlJeTeamLabel.setBounds(30, 190, 200, 25);
		add(teilnehmerzahlJeTeamLabel);
		teilnehmerzahlJeTeamField = new JTextField();
		teilnehmerzahlJeTeamField.setBounds(30, 210, 200, 25);
		add(teilnehmerzahlJeTeamField);
		
		JLabel beschreibungLabel = new JLabel("Beschreibung:");
		beschreibungLabel.setBounds(250, 10, 200, 25);
		add(beschreibungLabel);
		beschreibungField = new JTextArea();
		beschreibungField.setBounds(250, 30, 200, 205);
		add(beschreibungField);
		
		JLabel DozentenLabel = new JLabel("Dozenten:");
		DozentenLabel.setBounds(470, 10, 200, 25);
		add(DozentenLabel);
		dozentenlist = new JList<String>(listModel);
		dozentenlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		abortButton.setBounds(65, 270, 150, 25);
		abortButton.addActionListener(new Listener());
		add(abortButton);

		dataButton = new JButton("aus Datei laden");
		dataButton.setFocusable(false);
		dataButton.setBounds(265, 270, 150, 25);
		dataButton.addActionListener(new Listener());
		dataButton.setEnabled(false);
		add(dataButton);
		
		confirmButton = new JButton("OK");
		confirmButton.setFocusable(false);
		confirmButton.setBounds(465, 270, 150, 25);
		confirmButton.addActionListener(new Listener());
		add(confirmButton);
		
	}

private class Listener implements ActionListener{

		Listener(){
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==dataButton)
			{
				JFileChooser chooser = new JFileChooser();
				int rueckgabeWert = chooser.showOpenDialog(null);
				if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {
					ArrayList<Veranstaltung> liste = filehandler.readFile(chooser.getSelectedFile().getName(),Veranstaltung.class);



					dispose();
				}
			}
			if(e.getSource()==abortButton) {
				dispose();
			}
			if(e.getSource()==confirmButton) {
				try {
					veranstaltung.setName(veranstaltungsnameField.getText());
					veranstaltung.setFakultaet(fakultaetField.getText());
					veranstaltung.setTeamanzahl(Integer.parseInt(teamzahlJeGruppeField.getText()));
					veranstaltung.setMaxTeilnehmer(Integer.parseInt(teilnehmerzahlJeTeamField.getText()));
					veranstaltung.setBeschreibung(beschreibungField.getText());
				} catch (Exception e2) {
					ErrorDialog eD = new ErrorDialog("Ungueltige Eingabe");
					eD.setResizable(false);
					eD.setLocationRelativeTo(null);
					eD.setVisible(true);
					return;
				}
				try{
					dbrequest.createVeranstaltung(veranstaltung);
					for(Dozent d : veranstaltung.getDozenten())
					{
						dbrequest.createLeitet(d, veranstaltung);
					}
				}
				catch(DatabaseException dbe)
				{
					ErrorDialog eD = new ErrorDialog(dbe.getErrorMsg());
					eD.setResizable(false);
					eD.setLocationRelativeTo(null);
					eD.setVisible(true);
					return;
				}
				dispose();
			}
			if(e.getSource()==dozentenButton) {
				DozentenAddRemoveDialog dARD = new DozentenAddRemoveDialog(veranstaltung.getDozenten());
				dARD.setResizable(false);
				dARD.setLocationRelativeTo(null);
				dARD.setVisible(true);
				listModel.clear();
				for(Dozent d: veranstaltung.getDozenten()){
					listModel.add(listModel.getSize(),d.getEmail());
				}
			}
		}
		
	}
}