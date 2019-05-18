package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SVeranstaltungsübersicht implements FrameContent{



    private GUIMain mainFrame;

    private JPanel VeranstaltungsuebersichtPanel;
    private JButton bearbeiten;
    private JButton ansehen;
    private JButton hinzufügen;
    private JList Veranstaltungen;
    private JButton logoutButton;


    public String getNachname() {

        return "Startseite";
    }

    public JPanel getPanel() {

        return VeranstaltungsuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public SVeranstaltungsübersicht() {

        hinzufügen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new SAlleVeranstaltungen());
            }
        });
        bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new SGruppenübersicht());
            }
        });
        ansehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new SLeistungsübersicht());
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
