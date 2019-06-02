package GUI;

import Controller.DozentController;
import Controller.MainController;
import Database.DBrequest;
import Klassen.Dozent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Vector;

public class DVeranstaltungsuebersicht implements FrameContent {

    private GUIMain mainFrame;

    private JPanel VeranstaltungsuebersichtPanel;
    //JList wird erstellt
    private JList VeranstalungenList;
    private DefaultListModel dLV = new DefaultListModel();
    private JScrollPane scrollPane;
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

    public DVeranstaltungsuebersicht(ArrayList<String> dVL) {

        //TODO: Liste der Varanstaltungen des Dozenten aus DB erhalten und hinzufügen
        ArrayList<String> veranstaltungen = dVL;


        //Testveranstaltungen
        //veranstaltungen.add("VL1");
        //veranstaltungen.add("VL2");

        dLV.addAll(veranstaltungen);
        VeranstalungenList.setModel(dLV);

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
        VeranstalungenList.addComponentListener(new ComponentAdapter() {
        });
        VeranstalungenList.addMouseListener(new MouseAdapter() {
        });
    }

}
