package adminGui;

import Database.DBrequest;
import Database.DatabaseException;
import Klassen.Veranstaltung;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AdminPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private ArrayList<Veranstaltung> veranstaltungen = new ArrayList<>();
	private JList<String> veranstaltungslist;
	private DefaultListModel listModel = new DefaultListModel();
	private DBrequest dbr = DBrequest.getIntstance();
	private JButton deletebutton;
	private JButton editbutton;
	private JButton addbutton;
	
	public AdminPanel() {
		setLayout(null);
		setMaximumSize(new Dimension(400, 400));
		setPreferredSize(new Dimension(400, 400));
		setSize(300,400);
		//setBackground(Color.GREEN);
		try {
			veranstaltungen = dbr.getAllVeranstaltungen();
		}catch (DatabaseException de){
			System.out.println(de.getErrorMsg());
		}
		veranstaltungslist = new JList<String>(listModel);
		veranstaltungslist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		veranstaltungslist.addListSelectionListener(new MyListSelectionListener());
		for(Veranstaltung v: veranstaltungen){
			listModel.add(listModel.getSize(),v.getName());
		}
		JScrollPane scrollPane = new JScrollPane(veranstaltungslist);
		scrollPane.setBounds(20, 20, 362, 300);
		add(scrollPane);

		deletebutton = new JButton("löschen");
		deletebutton.setFocusable(false);
		deletebutton.setBounds(20, 350, 100, 25);
		deletebutton.addActionListener(new Listener(this));
		deletebutton.setEnabled(false);
		add(deletebutton);
		
		
		addbutton = new JButton("hinzufügen");
		addbutton.setFocusable(false);
		addbutton.setBounds(150, 350, 100, 25);
		addbutton.addActionListener(new Listener(this));
		add(addbutton);
		
		editbutton = new JButton("bearbeiten");
		editbutton.setFocusable(false);
		editbutton.setBounds(280, 350, 100, 25);
		editbutton.addActionListener(new Listener(this));
		editbutton.setEnabled(false);
		add(editbutton);
	}
	
	private class Listener implements ActionListener {
		AdminPanel aP;

		Listener(AdminPanel aP) {
			this.aP = aP;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == deletebutton) {
				for (Veranstaltung v : veranstaltungen) {
					if (v.getName().equals(veranstaltungslist.getSelectedValue())) {
						try {
							dbr.deleteVeranstaltung(v.getName());
						} catch (DatabaseException dbe) {
							System.out.println(dbe.getErrorMsg());
						}
						veranstaltungen.remove(v);
						break;
					}
				}
				listModel.remove(veranstaltungslist.getSelectedIndex());
			}
			if (e.getSource() == addbutton) {
				CreateDialog cD = new CreateDialog();
				cD.setResizable(false);
				cD.setLocationRelativeTo(aP);
				cD.setVisible(true);
				try {
					veranstaltungen = dbr.getAllVeranstaltungen();
				}catch (DatabaseException de){
					System.out.println(de.getErrorMsg());
				}
				listModel.clear();
				for(Veranstaltung v: veranstaltungen){
					listModel.add(listModel.getSize(),v.getName());
				}
			}
			if (e.getSource() == editbutton) {
				for (Veranstaltung v : veranstaltungen) {
					if (v.getName().equals(veranstaltungslist.getSelectedValue())) {
						EditDialog eD = new EditDialog(v);
						eD.setResizable(false);
						eD.setLocationRelativeTo(aP);
						eD.setVisible(true);
						break;
					}
				}
				try {
					veranstaltungen = dbr.getAllVeranstaltungen();
				}catch (DatabaseException de){
					System.out.println(de.getErrorMsg());
				}
				listModel.clear();
				for(Veranstaltung v: veranstaltungen){
					listModel.add(listModel.getSize(),v.getName());
				}
			}
		}
	}
	private class MyListSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(veranstaltungslist.getSelectedIndex()>=0){
				deletebutton.setEnabled(true);
				editbutton.setEnabled(true);
			}else{
				deletebutton.setEnabled(false);
				editbutton.setEnabled(false);
			}
		}
	}
}