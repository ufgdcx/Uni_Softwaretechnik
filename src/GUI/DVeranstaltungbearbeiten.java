package GUI;

import Klassen.Veranstaltung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DVeranstaltungbearbeiten implements FrameContent {

    private GUIMain mainFrame;

    private JPanel VeranstaltungbearbeitenPanel;
    private JButton bestaetigen;
    private JButton zurueckButton;
    private JTextArea infos;
    private JTextArea dozent;
    private JLabel infosLabel;
    private JLabel dozentLabel;
    private JButton logoutButton;

    private String text_infos, text_dozent;

    public String getName() {

        return "Veranstaltung bearbeiten - Dozent";
    }

    public JPanel getPanel() {

        return VeranstaltungbearbeitenPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DVeranstaltungbearbeiten(ArrayList<Veranstaltung> dVL, int[] index) {

        bestaetigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(index.length > 0) {
                    dVL.get(index[0]).setBeschreibung(infos.getText());
                    mainFrame.getController().setVBeschreibung(dVL.get(index[0]));

                }
            }
        });
        zurueckButton.addActionListener(new ActionListener() {
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
