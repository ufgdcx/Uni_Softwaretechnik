package GUI;

import Controller.DozentController;
import Database.DBrequest;
import Klassen.Dozent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DVeranstaltungsuebersicht implements FrameContent {

    private GUIMain mainFrame;

    private JPanel VeranstaltungsuebersichtPanel;
    //DefaultListModell wird erzeugt
    DefaultListModel VL = new DefaultListModel();
    //JList wird erstellt
    private JList VeranstalungenList  = new JList(VL);
    private JButton einsehen;
    private JButton logoutButton;




    public String getName() {

        return "Veranstaltungsübersicht - Dozent";
    }

    public JPanel getPanel() {

        return VeranstaltungsuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DVeranstaltungsuebersicht() {

        //Liste der Veranstaltungen des Dozenten hinzufügen


        einsehen.addActionListener(new ActionListener() {
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
