package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DLeistungsübersicht implements FrameContent{

    private GUIMain mainFrame;

    private JLabel BewertungLabel;
    private JButton hinzufügen;
    private JButton LBhinzufügen;
    private JButton UBhinzufügen;
    private JButton löschen;
    private JTextField Bewertung;
    private JPanel LeistungsübersichtPanel;
    private JButton zurückButton;
    private JTree tree1;
    private JButton logoutButton;
    private JButton teambewertungButton;


    public String getNachname() {

        return "Leistungsübersicht";
    }

    public JPanel getPanel() {

        return LeistungsübersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DLeistungsübersicht() {
        hinzufügen.addActionListener(new ActionListener() {
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
        LBhinzufügen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do: neuen LB in Tree und DB hinzufügen

                mainFrame.setContent(new DLeistungsübersicht());
            }
        });
        UBhinzufügen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do: neuen UB in Tree und DB hinzufügen

                mainFrame.setContent(new DLeistungsübersicht());
            }
        });
        löschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DLeistungsübersicht());
            }
        });
        zurückButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DGruppenübersicht());
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
