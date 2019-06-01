package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public DVeranstaltungbearbeiten() {

        //TODO DB Abruf des Inhaltes der Infos- bzw Dozentvariable
        infos.setText("Zeit / Veranstaltungsort:\n" +
                "Dienstag: 15:00 - 17:00, wöchentlich (ab 16.10.2018), Ort: AE22-HS037");
        dozent.setText("Prof. Dr.-Ing. habil. Peter Forbrig");

        bestaetigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //holt den Inhalt des JTextArea "infos" bzw "dozent" und speichert es in die Variable "text_infos" bzw. "text_dozent"
                text_infos = infos.getText();
                text_dozent = dozent.getText();
                //TODO "Informationen" und "Dozent(en)" in DB speichern


            }
        });
        zurueckButton.addActionListener(new ActionListener() {
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
