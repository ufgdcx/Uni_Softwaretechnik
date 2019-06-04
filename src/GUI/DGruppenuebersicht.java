package GUI;

import Klassen.Gruppe;
import Klassen.Team;
import Klassen.Veranstaltung;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DGruppenuebersicht implements FrameContent {


    private GUIMain mainFrame;
    private JPanel GruppenuebersichtPanel;
    private JButton einsehen;
    private JButton bearbeiten;
    private JButton zurueck;
    private JPanel treePanel;
    // Der Baum wird ergestellt
    private JTree tree;
    // Der Wurzelknoten wird ergestellt
    private DefaultMutableTreeNode root;
    private DefaultTreeModel treeModel;
    private JButton logoutButton;

    private int newNodeSuffix = 1;


    public String getName() {

        return "Gruppen- und Teamübersicht - Dozent";
    }

    public JPanel getPanel() {

        return GruppenuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DGruppenuebersicht(ArrayList<Veranstaltung> dVL, int index) {

        root = new DefaultMutableTreeNode( "Wurzel" );
        treeModel = new DefaultTreeModel(root);

        ArrayList<String> gruppen = new ArrayList<String>();
        ArrayList<String> teams = new ArrayList<String>();



        for (Gruppe g: dVL.get(index).getGruppen()){
            gruppen.add(String.valueOf(g.getGruppenID()));
        }

        

        einsehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DLeistungsuebersicht(dVL, index));
            }
        });
        bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DGruppenbearbeiten(dVL, index));
            }
        });
        zurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DVeranstaltung(dVL, index));

            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new LogoutSeite());
            }
        });
    }

}
