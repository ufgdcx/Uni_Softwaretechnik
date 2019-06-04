package GUI;

import Klassen.Dozent;
import Klassen.Veranstaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DVeranstaltung implements FrameContent {

    private GUIMain mainFrame;

    public JPanel VeranstaltungPanel;
    private JButton InfosBearbeiten;
    private JButton GrTeEinsehen;
    private JButton zurueck;
    private JTextPane infos;
    private JTextPane dozent;
    private JLabel infosField;
    private JLabel dozentField;
    private JButton logoutButton;

    public String getName() {

        return "Veranstaltung - Dozent";
    }

    public JPanel getPanel() {

        return VeranstaltungPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DVeranstaltung(ArrayList<Veranstaltung> dVL, int index) {

        String d = "";

        ArrayList<Dozent> dozenten = dVL.get(index).getDozenten();
        for (Dozent doz: dozenten){
            d += doz.getTitel() + " " +doz.getVorname() + " " + doz.getNachname() + "\n";
        }

        infos.setText(dVL.get(index).getBeschreibung());
        dozent.setText(d);

        InfosBearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DVeranstaltungbearbeiten(dVL, index));
            }
        });
        GrTeEinsehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DGruppenuebersicht(dVL, index));
            }
        });
        zurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DVeranstaltungsuebersicht(dVL, index));
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
