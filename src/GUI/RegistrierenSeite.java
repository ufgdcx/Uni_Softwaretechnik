/**
 * @author Diana
 *
 * Klasse für die Registrierung der Nutzer
 */

package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import Database.*;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

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
    private JLabel errorLabel;

    public String getName() {

        return "Registrierung";
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
                    } catch (DatabaseException databaseException) {
                        databaseException.printStackTrace();
                    }
                    try {
                        b.createStudent(EMail, Matrikel, Studiengang);
                    } catch (DatabaseException databaseException) {
                        databaseException.printStackTrace();
                    }
                }

                if (dozentRadioButton.isSelected()) {

                    String Fakultaet = fakultaet.getText();

                    try {
                        b.createNutzer(EMail, Titel, Vorname, Nachname, Passwort);
                    } catch (DatabaseException databaseException) {
                        databaseException.printStackTrace();
                    }
                    try {
                        b.createDozent(EMail, Fakultaet);
                    } catch (DatabaseException databaseException) {
                        databaseException.printStackTrace();
                    }
                }

                //TODO: Passwort und Passwort wiederholen abgleichen

                if (passwort.getPassword() != passwortwdh.getPassword()) {

                    errorLabel.setVisible(true);
                } else {
                    //TODO: Email mit Verifizierungscode senden

                    String verifyingCode = mainFrame.getController().generateVerifyingCode();

                    mainFrame.setContent(new VerifikationsSeite());
                }
            }
        });
        abbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new LoginSeite());
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        RegistrierenPanel = new JPanel();
        RegistrierenPanel.setLayout(new GridLayoutManager(12, 3, new Insets(50, 50, 200, 300), -1, -1));
        RegistrierenPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-4473925)), null));
        titelLabel = new JLabel();
        titelLabel.setText("Titel");
        RegistrierenPanel.add(titelLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        vornameLabel = new JLabel();
        vornameLabel.setText("Vorname");
        RegistrierenPanel.add(vornameLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nachname = new JTextField();
        RegistrierenPanel.add(nachname, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        nachnameLabel = new JLabel();
        nachnameLabel.setText("Name");
        RegistrierenPanel.add(nachnameLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        vorname = new JTextField();
        RegistrierenPanel.add(vorname, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        titel = new JTextField();
        RegistrierenPanel.add(titel, new GridConstraints(0, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        studentRadioButton = new JRadioButton();
        studentRadioButton.setText("Student");
        RegistrierenPanel.add(studentRadioButton, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dozentRadioButton = new JRadioButton();
        dozentRadioButton.setText("Dozent");
        RegistrierenPanel.add(dozentRadioButton, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        matrikelnummerLabel = new JLabel();
        matrikelnummerLabel.setText("Matrikel-Nr.");
        matrikelnummerLabel.setVerifyInputWhenFocusTarget(true);
        matrikelnummerLabel.setVisible(false);
        RegistrierenPanel.add(matrikelnummerLabel, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, -1), new Dimension(80, -1), new Dimension(80, -1), 0, false));
        matrikelnummer = new JTextField();
        matrikelnummer.setVisible(false);
        RegistrierenPanel.add(matrikelnummer, new GridConstraints(4, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        studiengangLabel = new JLabel();
        studiengangLabel.setText("Studiengang");
        studiengangLabel.setVisible(false);
        RegistrierenPanel.add(studiengangLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, -1), new Dimension(80, -1), new Dimension(80, -1), 0, false));
        studiengang = new JTextField();
        studiengang.setVisible(false);
        RegistrierenPanel.add(studiengang, new GridConstraints(5, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        eMailadresseLabel = new JLabel();
        eMailadresseLabel.setText("E-Mailadresse");
        RegistrierenPanel.add(eMailadresseLabel, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwortLabel = new JLabel();
        passwortLabel.setText("Passwort");
        RegistrierenPanel.add(passwortLabel, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwortWiederholenLabel = new JLabel();
        passwortWiederholenLabel.setText("Passwort wiederholen");
        RegistrierenPanel.add(passwortWiederholenLabel, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        emailadresse = new JTextField();
        RegistrierenPanel.add(emailadresse, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        passwort = new JPasswordField();
        RegistrierenPanel.add(passwort, new GridConstraints(8, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        passwortwdh = new JPasswordField();
        RegistrierenPanel.add(passwortwdh, new GridConstraints(9, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        uniRostockDeLabel = new JLabel();
        uniRostockDeLabel.setText("@uni-rostock.de");
        RegistrierenPanel.add(uniRostockDeLabel, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fakultaet = new JTextField();
        fakultaet.setVisible(false);
        RegistrierenPanel.add(fakultaet, new GridConstraints(6, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        fakultaetLabel = new JLabel();
        fakultaetLabel.setText("Fakultät");
        fakultaetLabel.setVisible(false);
        RegistrierenPanel.add(fakultaetLabel, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        abbrechenButton = new JButton();
        abbrechenButton.setText("Abbrechen");
        RegistrierenPanel.add(abbrechenButton, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), new Dimension(200, -1), new Dimension(200, -1), 0, false));
        verifizierenButton = new JButton();
        verifizierenButton.setLabel("Verifizieren");
        verifizierenButton.setText("Verifizieren");
        RegistrierenPanel.add(verifizierenButton, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(200, -1), new Dimension(200, -1), new Dimension(200, -1), 0, false));
        errorLabel = new JLabel();
        errorLabel.setForeground(new Color(-52480));
        errorLabel.setText("Passwörter stimmen nicht überein!");
        errorLabel.setVisible(false);
        RegistrierenPanel.add(errorLabel, new GridConstraints(10, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nachnameLabel.setLabelFor(nachname);
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(studentRadioButton);
        buttonGroup.add(dozentRadioButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return RegistrierenPanel;
    }
}