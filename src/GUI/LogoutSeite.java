package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutSeite implements FrameContent{
    private JPanel LogoutPanel;
    private JLabel logoutLabel;
    private JButton loginButton;

    private GUIMain mainFrame;

    public String getNachname() {
        return "Logoutseite";
    }

    public JPanel getPanel() {
        return LogoutPanel;
    }

    public void setParentFrame(GUIMain m) {
        mainFrame = m;
    }

    public LogoutSeite() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new LoginSeite());
            }
        });
    }
}