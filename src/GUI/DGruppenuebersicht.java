package GUI;

import Klassen.Veranstaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DGruppenuebersicht implements FrameContent {


    private GUIMain mainFrame;
    private JPanel GruppenuebersichtPanel;
    private JButton einsehen;
    private JButton bearbeiten;
    private JButton zurueck;
    private JButton logoutButton;
    private JTree tree;

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
