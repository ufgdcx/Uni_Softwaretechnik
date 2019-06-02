package GUI;

import Controller.DozentController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SAlleVeranstaltungen implements FrameContent {


    private GUIMain mainFrame;

    private JPanel AlleVeranstaltungen;
    //JList wird erstellt
    private JList list1;
    private DefaultListModel alleLV = new DefaultListModel();
    private JScrollPane scrollPane;
    //Button zum Eintragen in die ausgewählte Veranstaltung
    private JButton eintragen;
    private JButton zurueckButton;
    private JButton logoutButton;


    public String getName() {

        return "Veranstaltungsübersicht - Student";
    }

    public JPanel getPanel() {

        return AlleVeranstaltungen;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public SAlleVeranstaltungen() {

        ArrayList<String> veranstaltungen = new ArrayList<>();



        //TODO: Liste aller Varanstaltungen aus DB erhalten und hinzufügen

        //Testveranstaltungen
        veranstaltungen.add("VL1");
        veranstaltungen.add("VL2");

        alleLV.addAll(veranstaltungen);
        list1.setModel(alleLV);

        eintragen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do: ausgewählte Veranstaltung muss in Liste + DB eingetragen werden

                mainFrame.setContent(new SVeranstaltungsuebersicht());
            }
        });
        zurueckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new SVeranstaltungsuebersicht());
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
