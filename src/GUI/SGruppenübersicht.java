package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SGruppenübersicht implements FrameContent{

    private GUIMain mainFrame;

    private JPanel GruppenübersichtPanel;
    private JButton beitreten;
    private JButton verlassen;
    private JButton zurückButton;
    private JTree tree1;
    private JButton logoutButton;


    public String getNachname() {

        return "Gruppenübersicht";
    }

    public JPanel getPanel() {

        return GruppenübersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public SGruppenübersicht() {
        beitreten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TO Do: Name des Studenten muss in Gruppe/Team + DB eingetragen werden


                mainFrame.setContent(new SGruppenübersicht());
            }
        });
        verlassen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //To Do: Name des Studenten muss in Gruppe/Team + DB entfernt werden


                mainFrame.setContent(new SGruppenübersicht());
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
