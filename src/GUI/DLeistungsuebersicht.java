/**@author Kristi, Diana
 * Klasse erstellt von Kristi und erweitert von Diana
 *
 * Fenster in dem der Dozent eine Übersicht über die Leistungen hat
 * */

package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import Klassen.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class DLeistungsuebersicht implements FrameContent {

    /**
     * @author Kristi
     */
    private GUIMain mainFrame;
    private JLabel BewertungLabel;
    private JButton leistungHinzufuegen;
    private JButton UBhinzufuegen;
    private JButton loeschen;
    private JTextField Bewertung;
    private JPanel LeistungsuebersichtPanel;
    private JButton zurueckButton;
    private JButton teambewertungButton;
    private JButton hinzufuegen;
    private JScrollPane treeScrollPane;
    private JTree tree;
    /**
     * @author Diana
     */
    private JButton logoutButton;
    private JButton aufgabeHinzufuegen;
    private JLabel leistungsAnzahlLabel;
    private JTextField leistungsAnzahl;
    private JLabel ubAnzahlLabel;
    private JTextField ubAnzahl;
    private JLabel aufgabenAnzahlLabel;
    private JTextField aufgabeAnzahl;

    /**
     * @author Kristi
     */
    public String getName() {

        return "Leistungsübersicht - Dozent";
    }

    public JPanel getPanel() {

        return LeistungsuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    /**
     * @param dVL
     * @param index
     * @author Diana
     */
    public DLeistungsuebersicht(ArrayList<Veranstaltung> dVL, Student student, int index) {

        //Initialisierung Baum mit Gruppen, Teams und Mitglieder
        treeScrollPane.setViewportView(tree);

        //Überpruefung des ScrollPane auf Veraenderungen und Aktualisierung der Daten mit Hilfe der Datenbank
        treeScrollPane.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                tree = mainFrame.getController().createLeistungsTree(dVL.get(index), student, treeScrollPane);
            }
        });

        //zum Hinzufuegen von Leistungen als Parent in den Tree (z.B. Hausaufgaben, Projekt, Testate)
        leistungHinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int leistAnzahl = Integer.parseInt(leistungsAnzahl.getText());
                mainFrame.setContent(new DLeistungsInformationen(dVL, student, leistAnzahl, index, 1));
            }
        });
        //zum Hinzufuegen von Unterbloecken als Child in den Tree (z.B. Hausaufgabe 1, Testat 1, Teatat 2)
        UBhinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int unterblockAnzahl = Integer.parseInt(ubAnzahl.getText());
                try {
                    if (tree.getSelectionPath().getPath().length >= 2) {
                        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Leistungsname, Unterblockname, Aufgabenname zurück
                        //Auswahl des 2. Arrayelements = Name der Leistung
                        String leistung = tree.getSelectionPath().getPathComponent(1).toString();
                        mainFrame.setContent(new DUbInformationen(dVL, student, unterblockAnzahl, leistung, index, 1));
                    }
                } catch (Exception ex) {
                    ErrorDialog eD = new ErrorDialog("ups, something went wrong");
                    eD.setResizable(false);
                    eD.setLocationRelativeTo(null);
                    eD.setVisible(true);
                    return;
                }
            }
        });
        //zum Hinzufuegen von Aufgaben (z.b. Aufgabe 1, Aufgabe 2 von Hausaufgabe 1)
        aufgabeHinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int aufAnzahl = Integer.parseInt(aufgabeAnzahl.getText());
                try {
                    if (tree.getSelectionPath().getPath().length >= 3) {
                        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Leistungsname, Unterblockname, Aufgabenname zurück
                        //Auswahl des 2. Arrayelements = Name der Leistung
                        String leistung = tree.getSelectionPath().getPathComponent(1).toString();
                        //Auswahl des 3. Arrayelements = Name des Unterblocks
                        String ub = tree.getSelectionPath().getPathComponent(2).toString();
                        mainFrame.setContent(new DAufgabenInformationen(dVL, student, aufAnzahl, leistung, ub, index, 1));
                    }
                } catch (Exception ex) {
                    ErrorDialog eD = new ErrorDialog("ups, something went wrong");
                    eD.setResizable(false);
                    eD.setLocationRelativeTo(null);
                    eD.setVisible(true);
                    return;
                }
            }
        });
        //zum Hinzufuegen von Einzelleistungen für einen Studenten
        hinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do: Einzelleistung aus obigem Textfeld einem Studenten zuordnen + in DB speichern

            }
        });
        //zum Hinzufuegen von Gruppenleistungen für ein Team
        teambewertungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do: Teamleistung aus obigem Textfeld einem Team zuordnen + in DB speichern
            }
        });
        //zum Loeschen des ausgewaehlten Leistungs- oder Unterblocks
        loeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DLeistungsuebersicht(dVL, student, index));
            }
        });
        //Wechsel zurück zum Fenster Gruppenübersicht in der Dozentenansicht
        zurueckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DGruppenuebersicht(dVL, index));
            }
        });
        //Logout
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new LogoutSeite());
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
        LeistungsuebersichtPanel = new JPanel();
        LeistungsuebersichtPanel.setLayout(new GridLayoutManager(13, 4, new Insets(50, 20, 50, 20), -1, -1));
        hinzufuegen = new JButton();
        hinzufuegen.setText("Einzelbewertung hinzufügen");
        LeistungsuebersichtPanel.add(hinzufuegen, new GridConstraints(8, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        loeschen = new JButton();
        loeschen.setText("Element löschen");
        LeistungsuebersichtPanel.add(loeschen, new GridConstraints(10, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        BewertungLabel = new JLabel();
        BewertungLabel.setText("Bewertung");
        LeistungsuebersichtPanel.add(BewertungLabel, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        zurueckButton = new JButton();
        zurueckButton.setText("zurück");
        LeistungsuebersichtPanel.add(zurueckButton, new GridConstraints(12, 1, 1, 2, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        teambewertungButton = new JButton();
        teambewertungButton.setText("Teambewertung hinzufügen");
        LeistungsuebersichtPanel.add(teambewertungButton, new GridConstraints(9, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Bewertung = new JTextField();
        Bewertung.setText("");
        LeistungsuebersichtPanel.add(Bewertung, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, -1), new Dimension(50, -1), new Dimension(50, -1), 0, false));
        final Spacer spacer1 = new Spacer();
        LeistungsuebersichtPanel.add(spacer1, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        treeScrollPane = new JScrollPane();
        LeistungsuebersichtPanel.add(treeScrollPane, new GridConstraints(0, 0, 13, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tree = new JTree();
        treeScrollPane.setViewportView(tree);
        UBhinzufuegen = new JButton();
        UBhinzufuegen.setText("Unterblock hinzufügen");
        LeistungsuebersichtPanel.add(UBhinzufuegen, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logoutButton = new JButton();
        logoutButton.setText("Logout");
        LeistungsuebersichtPanel.add(logoutButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        aufgabeHinzufuegen = new JButton();
        aufgabeHinzufuegen.setText("Aufgabe hinzufügen");
        LeistungsuebersichtPanel.add(aufgabeHinzufuegen, new GridConstraints(5, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        LeistungsuebersichtPanel.add(spacer2, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        leistungsAnzahlLabel = new JLabel();
        leistungsAnzahlLabel.setText("Anzahl der Leistungen:");
        LeistungsuebersichtPanel.add(leistungsAnzahlLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        leistungsAnzahl = new JTextField();
        LeistungsuebersichtPanel.add(leistungsAnzahl, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, -1), new Dimension(80, -1), new Dimension(80, -1), 0, false));
        leistungHinzufuegen = new JButton();
        leistungHinzufuegen.setText("Leistung hinzufügen");
        LeistungsuebersichtPanel.add(leistungHinzufuegen, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ubAnzahlLabel = new JLabel();
        ubAnzahlLabel.setText("Anzahl der Unterblöcke");
        LeistungsuebersichtPanel.add(ubAnzahlLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ubAnzahl = new JTextField();
        LeistungsuebersichtPanel.add(ubAnzahl, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, -1), new Dimension(80, -1), new Dimension(80, -1), 0, false));
        aufgabenAnzahlLabel = new JLabel();
        aufgabenAnzahlLabel.setText("Anzahl der Aufgaben");
        LeistungsuebersichtPanel.add(aufgabenAnzahlLabel, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        aufgabeAnzahl = new JTextField();
        LeistungsuebersichtPanel.add(aufgabeAnzahl, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, -1), new Dimension(80, -1), new Dimension(80, -1), 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return LeistungsuebersichtPanel;
    }

}
