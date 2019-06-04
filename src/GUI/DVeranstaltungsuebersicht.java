package GUI;

import Klassen.Veranstaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DVeranstaltungsuebersicht implements FrameContent {

    private GUIMain mainFrame;

    private JPanel VeranstaltungsuebersichtPanel;
    //JList wird erstellt
    private JList VeranstalungenList;
    private DefaultListModel dLV = new DefaultListModel();
    private JScrollPane scrollPane;
    private JButton einsehen;
    private JButton logoutButton;
    private JLabel errorLabel;


    public String getName() {

        return "Veranstaltungsübersicht - Dozent";
    }

    public JPanel getPanel() {

        return VeranstaltungsuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DVeranstaltungsuebersicht(ArrayList<Veranstaltung> dVL, int index) {

        ArrayList<String> veranstaltungen = new ArrayList<String>();

        for (Veranstaltung v: dVL){
            veranstaltungen.add(v.getName());
        }

        dLV.addAll(veranstaltungen);
        VeranstalungenList.setModel(dLV);

        einsehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(VeranstalungenList.getSelectedIndex() >= 0){
                    mainFrame.setContent(new DVeranstaltung(dVL, VeranstalungenList.getSelectedIndex()));
                }
                else {
                    errorLabel.setVisible(true);
                }

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
