package GUI;

import Klassen.Dozent;
import Klassen.Veranstaltung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DVeranstaltung implements FrameContent {

    private GUIMain mainFrame;

    public JPanel VeranstaltungPanel;
    private JButton InfosBearbeiten;
    private JButton dozentBearbeiten;
    private JButton GrTeBearbeiten;
    private JButton zurueck;
    private JTextPane infos;
    private JTextPane dozent;
    private JLabel infosField;
    private JLabel dozentField;
    private JButton logoutButton;

    private String text_infos, text_dozent;

    public String getName() {

        return "Veranstaltung - Dozent";
    }

    public JPanel getPanel() {

        return VeranstaltungPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DVeranstaltung(ArrayList<Veranstaltung> dVL, int... index) {

        int getIndex = 0;
        String d = "";

        if(index.length > 0){
            getIndex = index[0];
        }

        ArrayList<Dozent> dozenten = dVL.get(getIndex).getDozenten();
        for (Dozent doz: dozenten){
            d += doz.getTitel() + " " +doz.getVorname() + " " + doz.getNachname() + "\n";
        }

        infos.setText(dVL.get(getIndex).getBeschreibung());
        dozent.setText(d);

        InfosBearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DVeranstaltungbearbeiten(dVL, index));
            }
        });
        GrTeBearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DGruppenuebersicht());
            }
        });
        zurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DVeranstaltungsuebersicht(dVL));
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
