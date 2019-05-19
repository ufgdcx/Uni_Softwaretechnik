package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import Database.*;

public class RegistrierenSeite implements FrameContent {

    private GUIMain mainFrame;

    private JPanel RegistrierenPanel;
    private JLabel titelLabel;
    private JTextField titel;
    private JLabel vornameLabel;
    private JTextField vorname;
    private JLabel nachnameLabel;
    private JTextField nachname;
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

    public String getNachname() {

        return "Registrieren";
    }

    public JPanel getPanel() {

        return RegistrierenPanel;
    }

    public void setParentFrame(
            GUIMain m) {
        mainFrame = m;
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
                    fakultaetLabel.setVisible(false);
                    fakultaet.setVisible(false);
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
                    fakultaetLabel.setVisible(true);
                    fakultaet.setVisible(true);
                }
            }
        });

        verifizierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Titel = titel.getText();
                String Vorname = vorname.getText();
                String Nachname = nachname.getText();
                String EMail = emailadresse.getText() + "@uni-rostock.de";
                String Passwort = String.valueOf(passwort.getPassword());

                DBrequest b = new DBrequest();


                if (studentRadioButton.isSelected()) {

                    int Matrikel = Integer.parseInt(matrikelnummer.getText());
                    String Studiengang = studiengang.getText();

                    try {
                        b.createNutzer(EMail, Titel, Vorname, Nachname, Passwort);
                    } catch (DatabaseExeption databaseExeption) {
                        databaseExeption.printStackTrace();
                    }
                    try {
                        b.createStudent(EMail, Matrikel, Studiengang);
                    } catch (DatabaseExeption databaseExeption) {
                        databaseExeption.printStackTrace();
                    }
                }

                if (dozentRadioButton.isSelected()) {

                    String Fakultaet = fakultaet.getText();

                    try {
                        b.createNutzer(EMail, Titel, Vorname, Nachname, Passwort);
                    } catch (DatabaseExeption databaseExeption) {
                        databaseExeption.printStackTrace();
                    }
                    try {
                        b.createDozent(EMail, Fakultaet);
                    } catch (DatabaseExeption databaseExeption) {
                        databaseExeption.printStackTrace();
                    }
                }


                mainFrame.setContent(new VerifikationsSeite());
            }
        });
        abbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new LoginSeite());
            }
        });
    }

}