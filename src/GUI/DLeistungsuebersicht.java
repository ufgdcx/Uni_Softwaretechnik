package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DLeistungsuebersicht implements FrameContent{

    private GUIMain mainFrame;

    private JLabel BewertungLabel;
    private JButton LBhinzufuegen;
    private JButton UBhinzufuegen;
    private JButton loeschen;
    private JTextField Bewertung;
    private JPanel LeistungsuebersichtPanel;
    private JButton zurueckButton;
    private JTree tree1;
    private JButton logoutButton;
    private JButton teambewertungButton;
    private JButton hinzufuegen;


    public String getNachname() {

        return "Leistungsübersicht";
    }

    public JPanel getPanel() {

        return LeistungsuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DLeistungsuebersicht() {
        hinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do: Einzelleistung aus obigem Textfeld einem Studenten zuordnen + in DB speichern

            }
        });
        teambewertungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do: Teamleistung aus obigem Textfeld einem Team zuordnen + in DB speichern
            }
        });
        LBhinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do: neuen LB in Tree und DB hinzufügen

                mainFrame.setContent(new DLeistungsuebersicht());
            }
        });
        UBhinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do: neuen UB in Tree und DB hinzufügen

                mainFrame.setContent(new DLeistungsuebersicht());
            }
        });
        loeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DLeistungsuebersicht());
            }
        });
        zurueckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DGruppenuebersicht());
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
