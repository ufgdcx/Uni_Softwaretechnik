package adminGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class AdminPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JList<String> veranstaltungen;
	JButton deletebutton;
	JButton editbutton;
	JButton addbutton;
	
	public AdminPanel() {
		setLayout(null);
		setMaximumSize(new Dimension(400, 400));
		setPreferredSize(new Dimension(400, 400));
		setSize(300,400);
		//setBackground(Color.GREEN);
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
