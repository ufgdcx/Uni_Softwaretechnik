package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerifikationsSeite implements FrameContent {

    private GUIMain mainFrame;

    private JPanel VerifikationsPanel;
    private JLabel verifikationscodeLabel;
    private JLabel codeLabel;
    private JTextField code;
    private JButton abbrechenButton;
    private JButton codeErneutSendenButton;
    private JButton okButton;

    public String getName() {

        return "Registrierung";
    }

    public JPanel getPanel() {

        return VerifikationsPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public VerifikationsSeite() {


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new LoginSeite());
            }
        });
        codeErneutSendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To DO: E-Mail versenden
            }
        });
        abbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new RegistrierenSeite());
            }
        });
    }


}
