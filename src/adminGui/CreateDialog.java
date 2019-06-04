package adminGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class CreateDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	
	private JButton confirmButton;
	private JButton deleteButton;
	private JButton addButton;
	private JButton dataButton;
	private JTextField veranstaltungsnameField;
	private JTextField fakultaetField;
	private JTextField teamzahlJeGruppeField;
	private JTextField teilnehmerzahlJeTeamField;
	private JTextField beschreibungField;
	
	JList<String> Dozenten;
	
	public CreateDialog() {
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
		beschreibungField = new JTextField();
		beschreibungField.setBounds(250, 30, 200, 25);
		add(beschreibungField);
		
		JLabel DozentenLabel = new JLabel("Dozenten:");
		DozentenLabel.setBounds(470, 10, 200, 25);
		add(DozentenLabel);
		String[] v= {"SWT","ALGO","lange Veranstaltung zum testen wie das ganze angezeigt wird111111111111111111","d","d","d","d","d","d","d","d","d","a"};
		Dozenten = new JList<String>(v);
		Dozenten.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(Dozenten);
		scrollPane.setBounds(470, 30, 200, 205);
		add(scrollPane);
		
		addButton = new JButton("hinzufügen");
		addButton.setFocusable(false);
		addButton.setBounds(350, 100, 100, 25);
		addButton.addActionListener(new Listener());
		add(addButton);
		
		deleteButton = new JButton("löschen");
		deleteButton.setFocusable(false);
		deleteButton.setBounds(350, 150, 100, 25);
		deleteButton.addActionListener(new Listener());
		add(deleteButton);
		
		dataButton = new JButton("aus Datei laden");
		dataButton.setFocusable(false);
		dataButton.setBounds(150, 270, 150, 25);
		dataButton.addActionListener(new Listener());
		add(dataButton);
		
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
			if(e.getSource()==confirmButton) {	
			}
		}
		
	}
}