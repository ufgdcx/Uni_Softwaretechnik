package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DGruppenbearbeiten implements FrameContent{

    private GUIMain mainFrame;

    private JButton bestaetigen;
    private JButton zurueckButton;
    private JPanel GruppenbearbeitenPanel;
    private JPanel TreePanel;
    private JTree tree;
    private JButton button1;

    public String getNachname() {

        return "Gruppen und Teams bearbeiten";
    }

    public JPanel getPanel() {
        return GruppenbearbeitenPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }


    public DGruppenbearbeiten() {

        bestaetigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do:

            }
        });
        zurueckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new DGruppenuebersicht());
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new LogoutSeite());
            }
        });
    }
}
