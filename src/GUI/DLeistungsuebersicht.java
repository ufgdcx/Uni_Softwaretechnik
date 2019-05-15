package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


public class DLeistungsuebersicht implements FrameContent {
    private String name = "Gruppen- und Teamübersicht";
    private GUIMain mainFrame;
    private Listener def = new Listener();

    private JPanel panel = new JPanel();
    private JPanel left = new JPanel();
	private JPanel right = new JPanel();
	private JSplitPane splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true);

	private JTree tree;
	private JLabel selectedLabel;
	private JLabel label = new JLabel("Bewertung: ");
	private JTextField bewertung = new JTextField();
	private JButton blockhinzufuegen = new JButton("Leistungsblock hinzufügen");
	private JButton unterblockhinzufuegen = new JButton("Unterblock hinzufügen");
	private JButton leistunghinzufuegen = new JButton("Leistung hinzufügen");
	private JButton loeschen = new JButton("Element löschen");
	

	public DLeistungsuebersicht() {
		
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

        panel.setLayout(new BorderLayout());
        panel.add(splitpane,BorderLayout.CENTER);
        splitpane.setResizeWeight(0.5);        splitpane.setLeftComponent(left);
        splitpane.setRightComponent(right);
        
		right.setLayout(new GridLayout(3,2));
		
        left.add(tree);
        
        right.add(label);
        right.add(bewertung);
        right.add(blockhinzufuegen);
        right.add(unterblockhinzufuegen);
        right.add(leistunghinzufuegen);
        right.add(loeschen);


        bewertung.addActionListener(def);
        blockhinzufuegen.addActionListener(def);
        unterblockhinzufuegen.addActionListener(def);
        leistunghinzufuegen.addActionListener(def);
        loeschen.addActionListener(def);

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
            if (e.getSource() == bewertung) {
                System.out.println("bewertung");
            }
            if (e.getSource() == blockhinzufuegen) {
                System.out.println("blockhinzufuegen");
            }
            if (e.getSource() == unterblockhinzufuegen) {
                System.out.println("unterblockhinzufuegen");
            }
            if (e.getSource() == leistunghinzufuegen) {
                System.out.println("leistunghinzufuegen");
            }
            if (e.getSource() == loeschen) {
                System.out.println("loeschen");
            }
        }
    }
}