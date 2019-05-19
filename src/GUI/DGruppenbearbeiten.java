package GUI;

import javax.swing.*;
import javax.swing.JTree;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DGruppenbearbeiten implements FrameContent {

    private GUIMain mainFrame;

    private JButton bestaetigen;
    private JButton zurueckButton;
    private JPanel GruppenbearbeitenPanel;
    private JPanel TreePanel;
    private JTree tree;
    private JButton logoutButton;
    private JButton gruppeHinzuButton;
    private JButton teamHinzufButton;
    private JButton teamLoeschenButton;
    private JButton gruppeLoeschenButton;

    public String getNachname() {

        return "Gruppen und Teams bearbeiten";
    }

    public JPanel getPanel() {
        return GruppenbearbeitenPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }


    public DGruppenbearbeiten() {

        bestaetigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new DGruppenuebersicht());

            }
        });
        zurueckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DGruppenuebersicht());
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new LogoutSeite());
            }
        });
        gruppeHinzuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO: neue Gruppe in Baum einfügen
            }
        });
        teamHinzufButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO: neue Gruppe in Baum einfügen
            }
        });
        gruppeLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO: Gruppe aus Baum entfernen
            }
        });
        teamLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO: Team aus Baum entfernen
            }
        });
    }
}

