package Anmeldung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSeite {

    private JPanel LoginPanel;
    //Eingabe der E-Mailadresse (vorname.name)
    private JTextField emailField;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton registrierenButton;
    private JLabel passwortLabel;
    private JLabel eMailadresseLabel;
    private JLabel uniRostockDeLabel;

    //Erzeugt Seite zum Login bzw. erstmaligen Registrieren
    public static void erzeugeLogin() {

        JFrame frame = new JFrame("Login");
        frame.setContentPane(new LoginSeite().LoginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Öffnet Seite zum Regiestrieren durch Klick auf "Registrieren"
    public LoginSeite() {
        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            new RegistrierenSeite().erzeugeRegistrieren();
            }
        });
    }


    //Zum Funktionstest; muss später in die HauptMainFunktion
    public static void main(String[] args) {

        erzeugeLogin();
    }
}
