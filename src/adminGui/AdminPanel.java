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

public class AdminPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	ArrayList<Veranstaltung> veranstaltungen = new ArrayList<>();
	JList<String> veranstaltungslist;
	DefaultListModel listModel = new DefaultListModel();
	DBrequest dbr = DBrequest.getIntstance();
	JButton deletebutton;
	JButton editbutton;
	JButton addbutton;
	
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
		for(Veranstaltung v: veranstaltungen){
			listModel.add(0,v.getName());
		}
		JScrollPane scrollPane = new JScrollPane(veranstaltungslist);
		scrollPane.setBounds(20, 20, 362, 300);
		add(scrollPane);

		deletebutton = new JButton("löschen");
		deletebutton.setFocusable(false);
		deletebutton.setBounds(20, 350, 100, 25);
		deletebutton.addActionListener(new Listener(this));
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
		add(editbutton);
	}
	
	private class Listener implements ActionListener{
		AdminPanel aP;
		
		Listener(AdminPanel aP){
			this.aP =aP;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==deletebutton) {
				for(Veranstaltung v: veranstaltungen){
					try {
						if (v.getName().equals(veranstaltungslist.getSelectedValue()))
							dbr.deleteVeranstaltung(v.getName());
					}catch(DatabaseException dbe){
						System.out.println(dbe.getErrorMsg());
					}
				}

				listModel.remove(veranstaltungslist.getSelectedIndex());

			}
			if(e.getSource()==addbutton) {
				CreateDialog cD = new CreateDialog();
				cD.setResizable(false);
				cD.setLocationRelativeTo(aP);
				cD.setVisible(true);
			}
		}
		
	}
}
