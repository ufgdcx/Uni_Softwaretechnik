package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SVeranstaltungsuebersicht implements FrameContent {


    private GUIMain mainFrame;

    private JPanel VeranstaltungsuebersichtPanel;
    private JButton bearbeiten;
    private JButton ansehen;
    private JButton hinzufuegen;
    private JList Veranstaltungen;
    private JButton logoutButton;


    public String getName() {

        return "Veranstaltungsübersicht - Student";
    }

    public JPanel getPanel() {

        return VeranstaltungsuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public SVeranstaltungsuebersicht() {



        hinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new SAlleVeranstaltungen());
            }
        });
        bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new SGruppenuebersicht());
            }
        });
        ansehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new SLeistungsuebersicht());
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
