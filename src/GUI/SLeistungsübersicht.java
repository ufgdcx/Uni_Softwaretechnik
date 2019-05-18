package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SLeistungsübersicht implements FrameContent{

    private GUIMain mainFrame;

    private JPanel LeistungsübersichtPanel;
    private JButton zurueck;
    private JTree tree1;
    private JButton logoutButton;


    public String getNachname() {

        return "Leistungsübersicht";
    }

    public JPanel getPanel() {

        return LeistungsübersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public SLeistungsübersicht() {
        zurueck.addActionListener(new ActionListener() {
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
