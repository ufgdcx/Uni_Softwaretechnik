package GUI;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DGruppenuebersicht implements FrameContent {


    private GUIMain mainFrame;
    private JPanel GruppenuebersichtPanel;
    private JButton einsehen;
    private JButton neuTeHinzufuegen;
    private JButton neuGrHinzufuegen;
    private JButton bearbeiten;
    private JButton zurueck;
    private JPanel PanelFuerTree;
    private JTree tree;
    private JButton logoutButton;


    public String getName() {

        return "Gruppen- und Teamübersicht - Dozent";
    }

    public JPanel getPanel() {

        return GruppenuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DGruppenuebersicht() {


        einsehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new DLeistungsuebersicht());
            }
        });
        neuGrHinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do: neue Gruppe in Tree und DB hinzufügen
            }
        });
        neuTeHinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do: neues Team in Tree und DB hinzufügen
            }
        });
        bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new DGruppenbearbeiten());
            }
        });
        zurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new DVeranstaltung());

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
