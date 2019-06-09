package adminGui;

import Database.DBrequest;
import Database.DatabaseException;
import Klassen.Dozent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class DozentenAddRemoveDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private DefaultListModel availableDozentenListModel = new DefaultListModel();
	private DefaultListModel addedDozentenListModel = new DefaultListModel();
	private JList<String> availableDozentenList;
	private JList<String> addedDozentenList;
	private ArrayList<Dozent> availableDozenten;
	private ArrayList<Dozent> addedDozenten;//temporary list
	private ArrayList<Dozent> dozenten;// actual list

	private JButton removeButton;
	private JButton addButton;
	private JButton confirmButton;
	private JButton abortButton;

	DozentenAddRemoveDialog(ArrayList<Dozent> dozenten) {
		this.dozenten = dozenten;
		addedDozenten = new ArrayList<>();
		for(Dozent d: dozenten){
			addedDozenten.add(d);
		}
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
		availableDozentenList.addListSelectionListener(new MyListSelectionListener());
		for(Dozent d: availableDozenten){
			if(!isadded(d)) {
				availableDozentenListModel.add(availableDozentenListModel.getSize(), d.getEmail());
			}
		}
		JScrollPane availableDozentenscrollPane;
		availableDozentenscrollPane = new JScrollPane(availableDozentenList);
		availableDozentenscrollPane.setBounds(30, 30, 200, 200);
		add(availableDozentenscrollPane);

		JLabel DozentenLabel = new JLabel("Dozenten der Veranstaltung:");
		DozentenLabel.setBounds(300, 10, 200, 25);
		add(DozentenLabel);
		addedDozentenList = new JList<String>(addedDozentenListModel);
		addedDozentenList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addedDozentenList.addListSelectionListener(new MyListSelectionListener());
		for(Dozent d: addedDozenten){
			addedDozentenListModel.add(addedDozentenListModel.getSize(),d.getEmail());
		}
		JScrollPane addedDozentenScrollPane = new JScrollPane(addedDozentenList);
		addedDozentenScrollPane.setBounds(300, 30, 200, 200);
		add(addedDozentenScrollPane);

		addButton = new JButton(">>");
		addButton.setFocusable(false);
		addButton.setBounds(240, 90, 50, 25);
		addButton.addActionListener(new Listener());
		addButton.setEnabled(false);
		add(addButton);

		removeButton = new JButton("<<");
		removeButton.setFocusable(false);
		removeButton.setBounds(240, 140, 50, 25);
		removeButton.addActionListener(new Listener());
		removeButton.setEnabled(false);
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
			if(e.getSource() == abortButton) {
				dispose();
			}
			if(e.getSource() == confirmButton){
				dozenten.clear();
				for(Dozent d: addedDozenten){
					dozenten.add(d);
				}
				dispose();
			}
			if(e.getSource() == addButton){
				for(Dozent d: availableDozenten){
					if(availableDozentenList.getSelectedValue().equals(d.getEmail())){
						for(int i = 0; i <= addedDozentenListModel.getSize();i++) {
							if(i == addedDozentenListModel.getSize()){
								addedDozenten.add(i, d);
								addedDozentenListModel.add(i, d.getEmail());
								break;
							}else {
								if (d.getEmail().compareTo(addedDozenten.get(i).getEmail()) <= 0) {
									addedDozenten.add(i, d);
									addedDozentenListModel.add(i, d.getEmail());
									break;
								}
							}
						}
						availableDozentenListModel.remove(availableDozentenList.getSelectedIndex());
						availableDozenten.remove(d);
						addedDozentenList.setSelectedValue(d.getEmail(),true);
						break;
					}
				}
			}
			if(e.getSource() == removeButton){
				for(Dozent d: addedDozenten){
					if(addedDozentenList.getSelectedValue().equals(d.getEmail())){
						for(int i = 0; i <= availableDozentenListModel.getSize();i++) {
							if(i == availableDozentenListModel.getSize()){
								availableDozenten.add(i, d);
								availableDozentenListModel.add(i, d.getEmail());
								break;
							}else{
								if (d.getEmail().compareTo(availableDozenten.get(i).getEmail()) <= 0) {
									availableDozenten.add(i, d);
									availableDozentenListModel.add(i, d.getEmail());
									break;
								}
							}
						}
						addedDozentenListModel.remove(addedDozentenList.getSelectedIndex());
						addedDozenten.remove(d);
						availableDozentenList.setSelectedValue(d.getEmail(),true);
						break;
					}
				}
			}
		}
	}
	private class MyListSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(e.getSource() == availableDozentenList) {
				if (availableDozentenList.getSelectedIndex() >= 0) {
					addButton.setEnabled(true);
					addedDozentenList.clearSelection();
				} else {
					addButton.setEnabled(false);
				}
			}
			if(e.getSource() == addedDozentenList) {
				if (addedDozentenList.getSelectedIndex() >= 0) {
					removeButton.setEnabled(true);
					availableDozentenList.clearSelection();
				} else {
					removeButton.setEnabled(false);
				}
			}
		}
	}
}