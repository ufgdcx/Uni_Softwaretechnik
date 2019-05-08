package gui.swing;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


public class Leistungsuebersicht extends JFrame {

	private JTree tree;
	private JLabel selectedLabel;
	
	public Leistungsuebersicht() {
		
		 //create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Leistungsuebersicht");
        //create the lv 1 child nodes
        DefaultMutableTreeNode hausaufgaben = new DefaultMutableTreeNode("Hausaufgaben");
        DefaultMutableTreeNode projekt = new DefaultMutableTreeNode("Projekt");
        DefaultMutableTreeNode testate = new DefaultMutableTreeNode("Testate");
        //add the lv 1 child nodes to the root node
        root.add(hausaufgaben);
        root.add(projekt);
        root.add(testate);
        //create the lv 2 child nodes
        DefaultMutableTreeNode ha1 = new DefaultMutableTreeNode("Hausaufgabe 1");
        DefaultMutableTreeNode t1 = new DefaultMutableTreeNode("Testat 1");

        //add the lv 2 child nodes to the lv 1 nodes
        projekt.add(new DefaultMutableTreeNode("Pflichtenheft"));
        projekt.add(new DefaultMutableTreeNode("Lastenheft"));
        hausaufgaben.add(ha1);
        testate.add(t1);
        //create the lv 3 child nodes
        DefaultMutableTreeNode ha1a1 = new DefaultMutableTreeNode("Aufgabe 1");
        DefaultMutableTreeNode t1a1 = new DefaultMutableTreeNode("Aufgabe 1");
        //add the lv 3 child nodes to the lv 2 nodes
        ha1.add(ha1a1);
        t1.add(t1a1);
         
        //create the tree by passing in the root node
        tree = new JTree(root);
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();       

         
        tree.setCellRenderer(renderer);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(false);
        add(new JScrollPane(tree));
         
        selectedLabel = new JLabel();
        add(selectedLabel, BorderLayout.SOUTH);
        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                selectedLabel.setText(selectedNode.getUserObject().toString());
            }
        });
		
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");       
        this.setSize(200, 200);
        this.setVisible(true);
	}
	
	
	public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {
        	@Override
        	public void run() {
        		new Leistungsuebersicht();
        	}
        });	
	}
}
