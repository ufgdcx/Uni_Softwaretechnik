package Anmeldung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Statement;

public class RegistrierenSeite {

    private JPanel RegistrierenPanel;
    private JLabel titelLabel;
    private JTextField titel;
    private JLabel vornameLabel;
    private JTextField vorname;
    private JLabel nameLabel;
    private JTextField name;
    private JLabel fakultaetLabel;
    private JTextField fakultaet;
    private JRadioButton studentRadioButton;
    private JRadioButton dozentRadioButton;
    private JLabel matrikelnummerLabel;
    private JTextField matrikelnummer;
    private JLabel studiengangLabel;
    private JTextField studiengang;
    private JButton verifizierenButton;
    private JLabel eMailadresseLabel;
    private JLabel passwortLabel;
    private JLabel passwortWiederholenLabel;
    private JTextField emailadresse;
    private JPasswordField passwort;
    private JPasswordField passwortwdh;
    private JLabel uniRostockDeLabel;
    private JButton abbrechenButton;

    private Statement statement;

    //Erzeugt Seite zum Registrieren
    public  static void erzeugeRegistrieren() {

        JFrame frame = new JFrame("Registrieren");
        frame.setContentPane(new RegistrierenSeite().RegistrierenPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Für Auswahl Student oder Dozent
    public RegistrierenSeite() {
        studentRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                //Wenn Student ausgewählt, erscheint Label und Textfeld für Matrikel-Nr. und Studiengang
                if (studentRadioButton.isSelected()) {
                    matrikelnummerLabel.setVisible(true);
                    matrikelnummer.setVisible(true);
                    studiengangLabel.setVisible(true);
                    studiengang.setVisible(true);
                }
            }
        });
        dozentRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                //Wenn Dozent ausgewählt, bleiben Label und Textfeld für Matrikel-Nr. und Studiengang ausgeblendet
                if (dozentRadioButton.isSelected()) {
                    matrikelnummerLabel.setVisible(false);
                    matrikelnummer.setVisible(false);
                    studiengangLabel.setVisible(false);
                    studiengang.setVisible(false);
                }
            }
        });

        //Funktionen von "Verifizieren"
        verifizierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Speichert eingegebene Daten in MySQL DB



                //Sendet E-Mail mit Verifizierungscode



                //Öffnet Seite zum Verifizieren durch Klick auf "Verifizieren"
                new VerifikationsSeite().erzeugeVerifizieren();
            }
        });

        //Schließt das Fenster nach Klick auf "Abbrechen"
        abbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComponent component = (JComponent) e.getSource();
                Window window = SwingUtilities.getWindowAncestor(component);
                window.dispose();
            }
        });

    }



}