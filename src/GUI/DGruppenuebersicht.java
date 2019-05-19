package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DGruppenuebersicht implements FrameContent {


    private GUIMain mainFrame;
    private JPanel GruppenuebersichtPanel;
    private JButton bearbeiten;
    private JButton zurueck;
    private JPanel PanelFuerTree;
    private JTree tree;
    private JButton logoutButton;
    private JScrollPane TreeScrollPane;
    private JButton einsehenButton;


    public String getNachname() {

        return "Gruppen- und Teamübersicht";
    }

    public JPanel getPanel() {

        return GruppenuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DGruppenuebersicht() {

        zurueck.addActionListener(new ActionListener() {
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
        bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new DGruppenbearbeiten());
            }
        });
        einsehenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new DLeistungsuebersicht());
            }
        });
    }

}
