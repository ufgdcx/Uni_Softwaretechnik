package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SAlleVeranstaltungen implements FrameContent {


    private GUIMain mainFrame;

    private JPanel AlleVeranstaltungen;
    private JList list1;
    private JButton eintragen;
    private JButton zurückButton;
    private JButton logoutButton;

    public String getNachname() {

        return "Veranstaltungsübersicht";
    }

    public JPanel getPanel() {

        return AlleVeranstaltungen;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public SAlleVeranstaltungen() {
        eintragen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do: ausgewählte Veranstaltung muss in Liste + DB eingetragen werden


                mainFrame.setContent(new SAlleVeranstaltungen());
            }
        });
        zurückButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new SVeranstaltungsübersicht());
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
