package GUI;

import Klassen.Veranstaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DGruppenbearbeiten implements FrameContent {

    private GUIMain mainFrame;

    private JButton bestaetigen;
    private JButton zurueckButton;
    private JPanel GruppenbearbeitenPanel;
    private JPanel TreePanel;
    private JTree tree;
    private JButton logoutButton;
    private JButton gruppeHinzufuegenButton;
    private JButton teamHinzufuegenButton;
    private JButton gruppeLoeschenButton;
    private JButton teamLoeschenButton;

    public String getName() {

        return "Gruppen und Teams bearbeiten - Dozent";
    }

    public JPanel getPanel() {
        return GruppenbearbeitenPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }


    public DGruppenbearbeiten(ArrayList<Veranstaltung> dVL, int index) {

        gruppeHinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        teamHinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        gruppeLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        teamLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bestaetigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do:

            }
        });
        zurueckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DGruppenuebersicht(dVL, index));
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
