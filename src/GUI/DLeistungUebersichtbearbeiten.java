/**@author Diana
 * Klasse erstellt und erweitert von Diana
 *
 * Fenster zum Erstellen und bearbeiten der Leistungsuebersicht in der Dozentenansicht
 */

package GUI;

import Klassen.*;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class DLeistungUebersichtbearbeiten implements FrameContent {

    private GUIMain mainFrame;
    private JPanel DLeistungsUebersichtbearbeitenPanel;
    private JTree tree;
    private JScrollPane treeScrollPane;
    //Label und Testfeld zum Einlesen der Anzahl an hinzuzufuegenden Leistungen
    private JLabel leistungsAnzahlLabel;
    private JTextField leistungTextField;
    //Button zum Hinzufuegen der Leistungen
    private JButton leistungHinzufuegenButton;
    //Label und Testfeld zum Einlesen der Anzahl an hinzuzufuegenden Unterbloecke
    private JLabel ubAnzahlLabel;
    private JTextField ubTextField;
    //Button zum Hinzufuegen der Unterbloecke
    private JButton unterblockHinzufügenButton;
    //Label und Testfeld zum Einlesen der Anzahl an hinzuzufuegenden Aufgaben
    private JLabel aufgabenAnzahlLabel;
    private JTextField aufgabeTextField;
    //Button zum Hinzufuegen der Aufgaben
    private JButton aufgabeHinzufügenButton;
    //Button zum Loeschen der Leistungen
    private JButton leistungLoeschenButton;
    //Button zum Loeschen der Unterbloecke
    private JButton unterblockLoeschenButton;
    //Button zum Loeschen der Aufgaben
    private JButton aufgabeLoeschenButton;
    //Button zum Zurueckkehren zur Gruppenuebersicht
    private JButton zurueckButton;

    public String getName() {
        return "Leistunsübersicht bearbeiten  - Dozent";
    }

    public JPanel getPanel() {
        return DLeistungsUebersichtbearbeitenPanel;
    }

    public void setParentFrame(GUIMain m) {
        mainFrame = m;
    }

    public DLeistungUebersichtbearbeiten(ArrayList<Veranstaltung> dVL, int index) {

        //initialisiere den Baum
        treeScrollPane.setViewportView(tree);
        //Überprüfung des ScrollPane auf Veränderungen und Aktualisierung der Daten mit Hilfe der DB

        treeScrollPane.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                ArrayList<Student> studenten = mainFrame.getController().getStudenten(dVL.get(index));
                tree = mainFrame.getController().createLeistungsTreeAlle(dVL.get(index), studenten.get(0), treeScrollPane);
                for (int i = 0; i < tree.getRowCount(); i++) {
                    tree.expandRow(i);
                }
            }
        });
        leistungHinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int leistAnzahl = Integer.parseInt(leistungTextField.getText());
                mainFrame.setContent(new DLeistungsInformationen(dVL, leistAnzahl, index, 1));
            }
        });
        unterblockHinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int unterblockAnzahl = Integer.parseInt(ubTextField.getText());
                try {
                    if (tree.getSelectionPath().getPath().length >= 2) {
                        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Leistungsname, Unterblockname, Aufgabenname zurück
                        //Auswahl des 2. Arrayelements = Name der Leistung
                        String leistung = tree.getSelectionPath().getPathComponent(1).toString();
                        mainFrame.setContent(new DUbInformationen(dVL, unterblockAnzahl, leistung, index, 1));
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
        aufgabeHinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int aufAnzahl = Integer.parseInt(aufgabeTextField.getText());
                try {
                    if (tree.getSelectionPath().getPath().length >= 3) {
                        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Leistungsname, Unterblockname, Aufgabenname zurück
                        //Auswahl des 2. Arrayelements = Name der Leistung
                        String leistung = tree.getSelectionPath().getPathComponent(1).toString();
                        //Auswahl des 3. Arrayelements = Name des Unterblocks
                        String ub = tree.getSelectionPath().getPathComponent(2).toString();
                        mainFrame.setContent(new DAufgabenInformationen(dVL, aufAnzahl, leistung, ub, index, 1));
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
        leistungLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tree.getSelectionPath().getPath().length >= 1) {
                        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Leistungsname, Unterblockname, Aufgabe zurück
                        //Auswahl des 2. Arrayelements = Name der Leistung
                        String leistungsname = tree.getSelectionPath().getPathComponent(1).toString();
                        //DB-Eintrag löschen
                        mainFrame.getController().deleteLeistung(dVL.get(index), leistungsname);
                        //Fenster Gruppenübersicht aktualisieren
                        mainFrame.setContent(new DLeistungUebersichtbearbeiten(dVL, index));
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
        unterblockLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tree.getSelectionPath().getPath().length >= 2) {
                        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Leistungsname, Unterblockname, Aufgabe zurück
                        //Auswahl des 2. Arrayelements = Name der Leistung
                        String leistungsname = tree.getSelectionPath().getPathComponent(1).toString();
                        //Auswahl des 3. Arrayelements = Name des Unterblocks
                        String ubname = tree.getSelectionPath().getPathComponent(2).toString();
                        //DB-Eintrag löschen
                        mainFrame.getController().deleteUnterblock(dVL.get(index), leistungsname, ubname);
                        //Fenster Gruppenübersicht aktualisieren
                        mainFrame.setContent(new DLeistungUebersichtbearbeiten(dVL, index));
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
        aufgabeLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tree.getSelectionPath().getPath().length >= 3) {
                        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Leistungsname, Unterblockname, Aufgabe zurück
                        //Auswahl des 2. Arrayelements = Name der Leistung
                        String leistungsname = tree.getSelectionPath().getPathComponent(1).toString();
                        //Auswahl des 3. Arrayelements = Name des Unterblocks
                        String ubname = tree.getSelectionPath().getPathComponent(2).toString();
                        //Auswahl des 4. Arrayelements = Name des Unterblocks
                        String aufgabenname = tree.getSelectionPath().getPathComponent(3).toString();
                        aufgabenname = aufgabenname.split(" ")[0];
                        //DB-Eintrag löschen
                        mainFrame.getController().deleteAufgabe(dVL.get(index), leistungsname, ubname, aufgabenname);
                        //Fenster Gruppenübersicht aktualisieren
                        mainFrame.setContent(new DLeistungUebersichtbearbeiten(dVL, index));
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
        zurueckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new DGruppenuebersicht(dVL, index));
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
        DLeistungsUebersichtbearbeitenPanel = new JPanel();
        DLeistungsUebersichtbearbeitenPanel.setLayout(new GridLayoutManager(12, 3, new Insets(50, 20, 50, 20), -1, -1));
        treeScrollPane = new JScrollPane();
        DLeistungsUebersichtbearbeitenPanel.add(treeScrollPane, new GridConstraints(0, 0, 12, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tree = new JTree();
        treeScrollPane.setViewportView(tree);
        leistungHinzufuegenButton = new JButton();
        leistungHinzufuegenButton.setText("Leistung hinzufügen");
        DLeistungsUebersichtbearbeitenPanel.add(leistungHinzufuegenButton, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        leistungTextField = new JTextField();
        DLeistungsUebersichtbearbeitenPanel.add(leistungTextField, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, -1), new Dimension(80, -1), new Dimension(80, -1), 0, false));
        ubTextField = new JTextField();
        DLeistungsUebersichtbearbeitenPanel.add(ubTextField, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, -1), new Dimension(80, -1), new Dimension(80, -1), 0, false));
        unterblockHinzufügenButton = new JButton();
        unterblockHinzufügenButton.setText("Unterblock hinzufügen");
        DLeistungsUebersichtbearbeitenPanel.add(unterblockHinzufügenButton, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        aufgabeTextField = new JTextField();
        DLeistungsUebersichtbearbeitenPanel.add(aufgabeTextField, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, -1), new Dimension(80, -1), new Dimension(80, -1), 0, false));
        aufgabeHinzufügenButton = new JButton();
        aufgabeHinzufügenButton.setText("Aufgabe hinzufügen");
        DLeistungsUebersichtbearbeitenPanel.add(aufgabeHinzufügenButton, new GridConstraints(5, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        DLeistungsUebersichtbearbeitenPanel.add(spacer1, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        leistungLoeschenButton = new JButton();
        leistungLoeschenButton.setText("Leistung löschen");
        DLeistungsUebersichtbearbeitenPanel.add(leistungLoeschenButton, new GridConstraints(7, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        unterblockLoeschenButton = new JButton();
        unterblockLoeschenButton.setText("Unterblock löschen");
        DLeistungsUebersichtbearbeitenPanel.add(unterblockLoeschenButton, new GridConstraints(8, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        aufgabeLoeschenButton = new JButton();
        aufgabeLoeschenButton.setText("Aufgabe löschen");
        DLeistungsUebersichtbearbeitenPanel.add(aufgabeLoeschenButton, new GridConstraints(9, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        DLeistungsUebersichtbearbeitenPanel.add(spacer2, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        zurueckButton = new JButton();
        zurueckButton.setText("zurück");
        DLeistungsUebersichtbearbeitenPanel.add(zurueckButton, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        leistungsAnzahlLabel = new JLabel();
        leistungsAnzahlLabel.setText("Anzahl der Leistungen");
        DLeistungsUebersichtbearbeitenPanel.add(leistungsAnzahlLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ubAnzahlLabel = new JLabel();
        ubAnzahlLabel.setText("Anzahl der Unterblöcke");
        DLeistungsUebersichtbearbeitenPanel.add(ubAnzahlLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        aufgabenAnzahlLabel = new JLabel();
        aufgabenAnzahlLabel.setText("Anzahl der Aufgaben");
        DLeistungsUebersichtbearbeitenPanel.add(aufgabenAnzahlLabel, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return DLeistungsUebersichtbearbeitenPanel;
    }

}
