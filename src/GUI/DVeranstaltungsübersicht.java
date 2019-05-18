package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DVeranstaltungsübersicht implements FrameContent {

    private GUIMain mainFrame;

    private JPanel VeranstaltungsübersichtPanel;
    private JList VeranstalungenList;
    private JButton einsehen;
    private JButton logoutButton;


    public String getNachname() {

        return "Startseite";
    }

    public JPanel getPanel() {

        return VeranstaltungsübersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DVeranstaltungsübersicht() {

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
