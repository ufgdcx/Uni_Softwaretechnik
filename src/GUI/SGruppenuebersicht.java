package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SGruppenuebersicht implements FrameContent{

    private GUIMain mainFrame;

    private JPanel GruppenuebersichtPanel;
    private JButton beitreten;
    private JButton verlassen;
    private JButton zurueckButton;
    private JTree tree1;
    private JButton logoutButton;


    public String getNachname() {

        return "Gruppenübersicht";
    }

    public JPanel getPanel() {

        return GruppenuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public SGruppenuebersicht() {
        beitreten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TO Do: Name des Studenten muss in Gruppe/Team + DB eingetragen werden


                mainFrame.setContent(new SGruppenuebersicht());
            }
        });
        verlassen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //To Do: Name des Studenten muss in Gruppe/Team + DB entfernt werden


                mainFrame.setContent(new SGruppenuebersicht());
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
