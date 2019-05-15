package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


public class DGruppenuebersicht implements FrameContent {
    private String name = "Gruppen- und Teamübersicht";
    private GUIMain mainFrame;
    private Listener def = new Listener();

    private JPanel panel = new JPanel();
    private JPanel left = new JPanel();
	private JPanel right = new JPanel();
	private JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);

	private JTree tree;
	private JLabel selectedLabel;
	
	private JButton leistungen = new JButton("Leistungen einsehen");
	private JButton gruppehinzufuegen = new JButton("neue Gruppe hinzufügen");
	private JButton teamhinzufuegen = new JButton("neues Team hinzufügen");
	private JButton bearbeiten = new JButton("Gruppen/Teams bearbeiten");

	public DGruppenuebersicht() {
		
		 //create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Gruppen- und Teamübersicht");
        //create the lv 1 child nodes
        DefaultMutableTreeNode g1 = new DefaultMutableTreeNode("Gruppe 1");
        DefaultMutableTreeNode g2 = new DefaultMutableTreeNode("Gruppe 2");
        DefaultMutableTreeNode g3 = new DefaultMutableTreeNode("Gruppe 3");
        //add the lv 1 child nodes to the root node
        root.add(g1);
        root.add(g2);
        root.add(g3);
        //create the lv 2 child nodes
        DefaultMutableTreeNode g1t1 = new DefaultMutableTreeNode("Team 1");
        DefaultMutableTreeNode g1t2 = new DefaultMutableTreeNode("Team 2");
        DefaultMutableTreeNode g2t1 = new DefaultMutableTreeNode("Team 1");
        DefaultMutableTreeNode g2t2 = new DefaultMutableTreeNode("Team 2");
        DefaultMutableTreeNode g3t1 = new DefaultMutableTreeNode("Team 1");
        DefaultMutableTreeNode g3t2 = new DefaultMutableTreeNode("Team 2");
        //add the lv 2 child nodes to the lv 1 nodes
        g1.add(g1t1);
        g1.add(g1t2);
        g2.add(g2t1);
        g2.add(g2t2);
        g3.add(g3t1);
        g3.add(g3t2);      
        //create the lv 3 child nodes and add to the lv 2 nodes
        g1t1.add(new DefaultMutableTreeNode("Mitglied 1"));
        g1t1.add(new DefaultMutableTreeNode("Mitglied 2"));
        g1t2.add(new DefaultMutableTreeNode("Mitglied 1"));
        g1t2.add(new DefaultMutableTreeNode("Mitglied 2"));
        g2t1.add(new DefaultMutableTreeNode("Mitglied 1"));
        g2t1.add(new DefaultMutableTreeNode("Mitglied 2"));
        g2t2.add(new DefaultMutableTreeNode("Mitglied 1"));
        g2t2.add(new DefaultMutableTreeNode("Mitglied 2"));
        g3t1.add(new DefaultMutableTreeNode("Mitglied 1"));
        g3t1.add(new DefaultMutableTreeNode("Mitglied 2"));    
        g3t2.add(new DefaultMutableTreeNode("Mitglied 1"));
        g3t2.add(new DefaultMutableTreeNode("Mitglied 2"));      
        //create the tree by passing in the root node
        tree = new JTree(root);
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();       

         
        tree.setCellRenderer(renderer);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(false);
        //add(new JScrollPane(tree));
         
        selectedLabel = new JLabel();
        panel.add(selectedLabel, BorderLayout.SOUTH);
        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                selectedLabel.setText(selectedNode.getUserObject().toString());
            }
        });
		
        panel.add(splitpane);
        splitpane.setLeftComponent(left);
        splitpane.setRightComponent(right);
        
		right.setLayout(new GridLayout(4,1));

		
        left.add(tree);
        
        right.add(leistungen);
        right.add(gruppehinzufuegen);
        right.add(teamhinzufuegen);
        right.add(bearbeiten);

        leistungen.addActionListener(def);
        gruppehinzufuegen.addActionListener(def);
        teamhinzufuegen.addActionListener(def);
        bearbeiten.addActionListener(def);
	}

    public String getName(){
        return name;
    }
    public JPanel getPanel(){
        return panel;
    }
    public void setParentFrame(GUIMain p){
        mainFrame = p;
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == leistungen) {
                System.out.println("leistungen");
            }
            if (e.getSource() == gruppehinzufuegen) {
                System.out.println("gruppehinzufuegen");
            }
            if (e.getSource() == teamhinzufuegen) {
                System.out.println("teamhinzufuegen");
            }
            if (e.getSource() == bearbeiten) {
                System.out.println("bearbeiten");
            }
        }
    }
}
