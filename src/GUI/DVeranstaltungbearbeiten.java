package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DVeranstaltungbearbeiten implements FrameContent{

    private GUIMain mainFrame;

    private JPanel VeranstaltungbearbeitenPanel;
    private JButton bestätigen;
    private JButton zurückButton;
    private JTextArea infos;
    private JTextArea dozent;
    private JLabel infosLabel;
    private JLabel dozentLabel;
    private JButton logoutButton;


    public String getNachname() {

        return "Veranstaltung bearbeiten";
    }

    public JPanel getPanel() {

        return VeranstaltungbearbeitenPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DVeranstaltungbearbeiten() {
        bestätigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        zurückButton.addActionListener(new ActionListener() {
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
