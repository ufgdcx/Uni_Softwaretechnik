package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;

public class LoginSeite implements FrameContent {

    private GUIMain mainFrame;

    private JPanel LoginPanel;
    //Eingabe der E-Mailadresse (vorname.name)
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registrierenButton;
    private JLabel passwortLabel;
    private JLabel eMailadresseLabel;
    private JLabel uniRostockDeLabel;


    public String getNachname() {

        return "Loginseite";
    }

    public JPanel getPanel() {

        return LoginPanel;
    }

    public void setParentFrame(GUIMain m) {
        mainFrame = m;
    }

    public LoginSeite() {
        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new RegistrierenSeite());

            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//gets the controller reference from the GUIMain object
            	//then calls the login method with the data in the data from the email and password text fields
                mainFrame.getController().login(emailField.getText(), passwordField.getPassword());
            }
        });
    }

}
