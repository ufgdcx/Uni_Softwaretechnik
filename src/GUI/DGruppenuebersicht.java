package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DGruppenuebersicht implements FrameContent{



    private GUIMain mainFrame;

    private JButton einsehen;
    private JButton neuTeHinzufuegen;
    private JButton neuGrHinzufuegen;
    private JButton bearbeiten;
    private JButton zurück;
    private JPanel PanelFuerTree;
    private JPanel GruppenübersichtPanel;
    private JTree tree;
    private JButton logoutButton;
    private JPanel GruppenuebersichtPanel;
    private JButton zurueck;


    public String getNachname() {

        return "Gruppen- und Teamübersicht";
    }

    public JPanel getPanel() {

        return GruppenübersichtPanel;
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
        zurück.addActionListener(new ActionListener() {
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
