package adminGui;

import Database.DBrequest;
import Database.DatabaseException;
import Klassen.Dozent;
import Klassen.Veranstaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DozentenAddRemoveDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	DefaultListModel availableDozentenListModel = new DefaultListModel();
	DefaultListModel addedDozentenListModel = new DefaultListModel();
	JList<String> availableDozentenList;
	JList<String> addedDozentenList;
	ArrayList<Dozent> availableDozenten;
	ArrayList<Dozent> addedDozenten;

	private JButton removeButton;
	private JButton addButton;
	private JButton confirmButton;
	private JButton abortButton;

	JList<String> Dozenten;

	public DozentenAddRemoveDialog(ArrayList<Dozent> addedDozenten) {
		this.addedDozenten = addedDozenten;
		setModal(true);
		setSize(550, 340);
		setLayout(null);

		DBrequest dbr = DBrequest.getIntstance();

		try {
			availableDozenten = dbr.getAllDozenten();
		}catch (DatabaseException de){
			System.out.println(de.getErrorMsg());
		}

		JLabel availableDozentenLabel = new JLabel("verfügbare Dozenten");
		availableDozentenLabel.setBounds(30, 10, 200, 25);
		add(availableDozentenLabel);
		availableDozentenList = new JList<String>(availableDozentenListModel);
		availableDozentenList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for(Dozent d: availableDozenten){
			if(!isadded(d)) {
				availableDozentenListModel.add(0, d.getEmail());
			}
		}
		JScrollPane availableDozentenscrollPane = new JScrollPane(availableDozentenList);
		availableDozentenscrollPane.setBounds(30, 30, 200, 200);
		add(availableDozentenscrollPane);

		JLabel DozentenLabel = new JLabel("Dozenten der Veranstaltung:");
		DozentenLabel.setBounds(300, 10, 200, 25);
		add(DozentenLabel);
		addedDozentenList = new JList<String>(addedDozentenListModel);
		addedDozentenList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for(Dozent d: addedDozenten){
			addedDozentenListModel.add(0,d.getEmail());
		}
		JScrollPane addedDozentenScrollPane = new JScrollPane(addedDozentenList);
		addedDozentenScrollPane.setBounds(300, 30, 200, 200);
		add(addedDozentenScrollPane);

		addButton = new JButton(">>");
		addButton.setFocusable(false);
		addButton.setBounds(240, 90, 50, 25);
		addButton.addActionListener(new Listener());
		add(addButton);

		removeButton = new JButton("<<");
		removeButton.setFocusable(false);
		removeButton.setBounds(240, 140, 50, 25);
		removeButton.addActionListener(new Listener());
		add(removeButton);

		abortButton = new JButton("abbrechen");
		abortButton.setFocusable(false);
		abortButton.setBounds(140, 260, 100, 25);
		abortButton.addActionListener(new Listener());
		add(abortButton);

		confirmButton = new JButton("OK");
		confirmButton.setFocusable(false);
		confirmButton.setBounds(290, 260, 100, 25);
		confirmButton.addActionListener(new Listener());
		add(confirmButton);
		
	}

	private boolean isadded(Dozent d){
		for(Dozent dozent: addedDozenten){
			if(dozent.getEmail().equals(d.getEmail())) return true;
		}
		return false;
	}

private class Listener implements ActionListener{

		Listener(){
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==abortButton) {
				dispose();
			}
		}
		
	}
}