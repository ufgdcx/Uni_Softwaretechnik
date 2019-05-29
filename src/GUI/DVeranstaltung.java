package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public String getNachname() {

        return "Veranstaltung - Dozent";
    }

    public JPanel getPanel() {

        return VeranstaltungPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DVeranstaltung() {

        /*TODO "Informationen" und "Dozent" in DB anlegen
          TODO "Informationen" und "Dozent(en)" aus DB auslesen und in "text_infos" bzw. "text_dozent" speichern
        text_infos =;
        text_dozent =;

        //setzt den Inhalt des JTextArea "infos" bzw "dozent" und speichert es in die Variable "text_infos" bzw. "text_dozent"
        infos.setText(text_infos);
        dozent.setText(text_dozent);*/

        infos.setText("Zeit / Veranstaltungsort:\n" + "Dienstag: 15:00 - 17:00, wöchentlich (ab 16.10.2018), Ort: AE22-HS037");
        dozent.setText("Prof. Dr.-Ing. habil. Peter Forbrig");

        InfosBearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DVeranstaltungbearbeiten());
            }
        });
        dozentBearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //To Do: Dozent bearbeiten und in DB + TextArea DVeranstaltungsuebersicht eintragen

                mainFrame.setContent(new DVeranstaltungbearbeiten());
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

                mainFrame.setContent(new DVeranstaltungsuebersicht());
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
