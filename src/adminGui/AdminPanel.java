package adminGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class AdminPanel extends JPanel{
	
	JList<String> veranstaltungen;
	JButton deletebutton;
	JButton editbutton;
	JButton addbutton;
	
	public AdminPanel() {
		setLayout(null);
		setMaximumSize(new Dimension(400, 400));
		setPreferredSize(new Dimension(400, 400));
		setSize(300,400);
		setBackground(Color.cyan);
		String[] v= {"SWT","ALGO","lange Veranstaltung zum testen wie das ganze angezeigt wird111111111111111111","d","d","d","d","d","d","d","d","d","a"};
		veranstaltungen = new JList<String>(v);
		veranstaltungen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		veranstaltungen.setBounds(5, 5, 200, 200);
		JScrollPane scrollPane = new JScrollPane(veranstaltungen);
		scrollPane.setBounds(20, 20, 362, 300);
		add(scrollPane);
		
		deletebutton = new JButton("löschen");
		deletebutton.setFocusable(false);
		deletebutton.setBounds(20, 350, 100, 25);
		deletebutton.addActionListener(new Listener());
		add(deletebutton);
		
		
		addbutton = new JButton("hinzufügen");
		addbutton.setFocusable(false);
		addbutton.setBounds(150, 350, 100, 25);
		addbutton.addActionListener(new Listener());
		add(addbutton);
		
		editbutton = new JButton("bearbeiten");
		editbutton.setFocusable(false);
		editbutton.setBounds(280, 350, 100, 25);
		editbutton.addActionListener(new Listener());
		add(editbutton);
	}
	
	private class Listener implements ActionListener{
		
		Listener(){
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==deletebutton) {
			}
			if(e.getSource()==addbutton) {
			}
		}
		
	}
}
