package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DVeranstaltung implements FrameContent{

    private GUIMain mainFrame;

    private JPanel VeranstaltungPanel;
    private JButton InfosBearbeiten;
    private JButton dozentBearbeiten;
    private JButton GrTeBearbeiten;
    private JButton zurueck;
    private JTextPane infos;
    private JTextPane dozent;
    private JLabel infosField;
    private JLabel dozentField;
    private JButton logoutButton;

    public String getNachname() {

        return "Veranstaltung";
    }

    public JPanel getPanel() {

        return VeranstaltungPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DVeranstaltung() {
        InfosBearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //To Do: Information bearbeiten und in DB + TextArea DVeranstaltungsuebersicht eintragen


                mainFrame.setContent(new DVeranstaltungbearbeiten());
            }
        });
        dozentBearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //To Do: Dozent bearbeiten und in DB + TextArea DVeranstaltungsuebersicht eintragen

                mainFrame.setContent(new DVeranstaltungbearbeiten());
            }
        });
        GrTeBearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DGruppenuebersicht());
            }
        });
        zurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DVeranstaltungsuebersicht());
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
