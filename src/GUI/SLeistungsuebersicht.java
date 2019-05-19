package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SLeistungsuebersicht implements FrameContent {

    private GUIMain mainFrame;

    private JPanel LeistungsuebersichtPanel;
    private JButton zurueck;
    private JTree tree1;
    private JButton logoutButton;


    public String getNachname() {

        return "Leistungsübersicht";
    }

    public JPanel getPanel() {

        return LeistungsuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public SLeistungsuebersicht() {
        zurueck.addActionListener(new ActionListener() {
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
