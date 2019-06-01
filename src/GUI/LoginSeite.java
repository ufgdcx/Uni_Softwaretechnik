package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Controller.*;
import Database.DatabaseException;

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
    private JLabel errorLabel;


    public String getName() {

        return "Login";
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
                //TODO: Fehlermeldung, wenn E-Mailfeld leer
                try {
                    emailField.getText().isEmpty();
                }
                catch (Exception ex){

                    errorLabel.setVisible(true);
                    errorLabel.setText("leere Eingabe im E-Mailfeld");
                    ex.printStackTrace();
                    System.out.println(ex);
                    return;
                }
                //TODO: Fehlermeldung bei falscher Eingabe des Passwortes


                //gets the controller reference from the GUIMain object
                //then calls the login method with the data in the data from the email and password text fields
                mainFrame.getController().login(emailField.getText() + "@uni-rostock.de", passwordField.getPassword());
            }
        });

        //TODO: Exception bei Eingabe von @
        /*emailField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                try {
                    String str = emailField.getText();
                }
                catch (){

                    errorLabel.setVisible(true);
                    errorLabel.setText("Eingabe ohne @uni-rostock.de");
            }
        });*/
    }

}
