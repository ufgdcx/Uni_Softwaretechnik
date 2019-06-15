/**@author Kristi, Diana
 * Klasse erstellt von Kristi und erweitert von Diana
 *
 * Fenster in dem der Dozent die (Uebungs-)Gruppen  und Teams bearbeiten kann
 * */

package GUI;

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
import Klassen.*;

public class DGruppenbearbeiten implements FrameContent {

    /**
     * @author Kristi
     */
    private GUIMain mainFrame;
    private JPanel GruppenbearbeitenPanel;
    private JButton zurueckButton;
    private JTree tree;
    private JScrollPane treeScrollPane;
    /**
     * @author Diana
     */
    //Label und Textfeld fuer Anzahl der Gruppen der Veranstaltung
    private JLabel gruppenanzahl;
    private JTextField grAnzahlTextField;
    //Label und Textfeld fuer Anzahl der Teams pro Gruppe
    private JLabel teamanzahl;
    private JTextField tAnzahlTextField;
    //Label und Textfeld fuer Anzahl der Teilnehmer pro Team
    private JLabel teamgroesse;
    private JTextField tGroesseTextField;
    //Button zum Hinzufuegen von Gruppen
    private JButton gruppeHinzufuegenButton;
    //Button zum Hinzufuegen von Teams
    private JButton teamHinzufuegenButton;
    //Button zum Setzten der Anzahl der Teilnehmer pro Team
    private JButton festlegenButton;
    //Label zur Anzeige des erfolgreichen Setzten der Anzahl der Teilnehmer pro Team
    private JLabel successLabel;
    //Button zum Loeschen einer Gruppe
    private JButton gruppeLoeschenButton;
    //Button zum Loeschen eines Teams
    private JButton teamLoeschenButton;
    //Button fuer Logout
    private JButton logoutButton;
    private JButton studentLoeschenButton;
    private JButton studentZuTeamHinzufuegenButton;
    private JTextField studentNameTextField;
    private JLabel studentNameLabel;
    private JLabel hinweisLabel;


    /**
     * @author Kristi
     */
    public String getName() {
        return "Gruppen und Teams bearbeiten - Dozent";
    }

    public JPanel getPanel() {
        return GruppenbearbeitenPanel;
    }

    public void setParentFrame(GUIMain m) {
        mainFrame = m;
    }

    /**
     * @author Diana
     */
    public DGruppenbearbeiten(ArrayList<Veranstaltung> dVL, int index) {

        //Initialisierung Baum mit Gruppen, Teams und Mitglieder
        treeScrollPane.setViewportView(tree);

        //Überprüfung des ScrollPane auf Veränderungen und Aktualisierung der Daten mit Hilfe der Datenbank
        treeScrollPane.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                tree = mainFrame.getController().createGruppenTree(dVL.get(index), treeScrollPane);
            }
        });

        //zum Hinzufügen von Gruppen als Parent in den Tree
        gruppeHinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int grAnzahl = Integer.parseInt(grAnzahlTextField.getText());
                mainFrame.setContent(new DGruppenInformationen(dVL, index, grAnzahl, 1));
            }
        });
        //zum Hinzufuegen von Teams als Child in den Tree
        teamHinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Auswahl des 2. Arrayelements und absplitten der GruppenID
                String gruppenID = tree.getSelectionPath().getPathComponent(1).toString();
                gruppenID = gruppenID.split(" ")[1];


                int teamAnzahl = Integer.parseInt(tAnzahlTextField.getText());
                mainFrame.setContent(new DTeamInformationen(dVL, index, Integer.parseInt(gruppenID), teamAnzahl, 1));
            }
        });
        //zum Festlegen der maximalen Anzahl an Mitgliedern in einem Team
        festlegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getController().setMaximale_Teilnehmeranzahl_je_Team(dVL.get(index).getName(), Integer.parseInt(tAnzahlTextField.getText()));
            }
        });
        //zum Hinzufuegen eines Studenten (bspw. nach Ablauf der Anmeldefrist) zum ausgewählten Team
        studentZuTeamHinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tree.getSelectionPath().getPath().length >= 3) {
                        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Gruppe, Team, Student zurück
                        //Auswahl des 2. Arrayelements und absplitten der GruppenID
                        String gruppenID = tree.getSelectionPath().getPathComponent(1).toString();
                        gruppenID = gruppenID.split(" ")[1];
                        //Auswahl des 3. Arrayelements und absplitten der TeamID
                        String teamID = tree.getSelectionPath().getPathComponent(2).toString();
                        teamID = teamID.split(" ")[1];
                        String student = studentNameTextField.getText();
                        String vornameStudent = student.split(" ")[0];
                        String nachnameStudent = student.split(" ")[1];
                        for (Student s : mainFrame.getController().getAlleStudenten()) {
                            if (s.getVorname().equals(vornameStudent) && s.getNachname().equals(nachnameStudent)) {
                                //DB-Eintrag hinzufügen
                                mainFrame.getController().createGehoertZu(s.getMatrikelnr(), Integer.parseInt(teamID), Integer.parseInt(gruppenID), dVL.get(index).getName());
                                break;
                            } 
                        }
                        //Fenster Gruppenübersicht aktualisieren
                        mainFrame.setContent(new DGruppenbearbeiten(dVL, index));
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
        //zum Löschen von Gruppen aus der Veranstaltung
        gruppeLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tree.getSelectionPath().getPath().length >= 1) {
                        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Gruppe, Team, Student zurück
                        //Auswahl des 2. Arrayelements und absplitten der GruppenID
                        String gruppenID = tree.getSelectionPath().getPathComponent(1).toString();
                        gruppenID = gruppenID.split(" ")[1];
                        for (Gruppe g : mainFrame.getController().getGruppen(dVL.get(index))) {
                            if (Integer.parseInt(gruppenID) == g.getGruppenID()) {
                                for (Team t : mainFrame.getController().getTeams(g)) {
                                    mainFrame.getController().deleteTeam(Integer.parseInt(gruppenID), t.getTeamID(), dVL.get(index).getName());
                                    for (Student s : mainFrame.getController().getStudenten(t)) {
                                        mainFrame.getController().deleteStudent(s);
                                    }
                                }
                            }
                            //DB-Eintrag löschen
                            mainFrame.getController().deleteGruppe(Integer.parseInt(gruppenID), dVL.get(index));
                        }

                        //Fenster Gruppenübersicht aktualisieren
                        mainFrame.setContent(new DGruppenbearbeiten(dVL, index));
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
        //zum Löschen von Teams aus einer Gruppe
        teamLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tree.getSelectionPath().getPath().length >= 3) {
                        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Gruppe, Team, Student zurück
                        //Auswahl des 2. Arrayelements und absplitten der GruppenID
                        String gruppenID = tree.getSelectionPath().getPathComponent(1).toString();
                        gruppenID = gruppenID.split(" ")[1];
                        //Auswahl des 3. Arrayelements und absplitten der TeamID
                        String teamID = tree.getSelectionPath().getPathComponent(2).toString();
                        teamID = teamID.split(" ")[1];
                        //DB-Eintrag löschen
                        mainFrame.getController().deleteTeam(Integer.parseInt(gruppenID), Integer.parseInt(teamID), dVL.get(index).getName());
                        //Fenster Gruppenübersicht aktualisieren
                        mainFrame.setContent(new DGruppenbearbeiten(dVL, index));
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
        //zum Loeschen von Studenten aus einem Team
        studentLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tree.getSelectionPath().getPath().length >= 4) {
                        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Gruppe, Team, Student zurück
                        //Auswahl des 2. Arrayelements und absplitten der GruppenID
                        String gruppenID = tree.getSelectionPath().getPathComponent(1).toString();
                        gruppenID = gruppenID.split(" ")[1];
                        //Auswahl des 3. Arrayelements und absplitten der TeamID
                        String teamID = tree.getSelectionPath().getPathComponent(2).toString();
                        teamID = teamID.split(" ")[1];
                        //Auswahl des 3. Arrayelements (Student) und absplitten des Vor- und Nachnamen
                        String student = tree.getSelectionPath().getPathComponent(3).toString();
                        String vornameStudent = student.split(" ")[0];
                        String nachnameStudent = student.split(" ")[1];

                        for (Gruppe g : mainFrame.getController().getGruppen(dVL.get(index))) {
                            if (g.getGruppenID() == Integer.parseInt(gruppenID)) {
                                for (Team t : mainFrame.getController().getTeams(g)) {
                                    if (t.getTeamID() == Integer.parseInt(teamID)) {
                                        for (Student s : mainFrame.getController().getStudenten(t)) {
                                            if (s.getVorname().equals(vornameStudent) && s.getNachname().equals(nachnameStudent)) {
                                                //DB-Eintrag löschen
                                                mainFrame.getController().deleteGehoertZu(s.getMatrikelnr(), Integer.parseInt(teamID), Integer.parseInt(gruppenID), dVL.get(index).getName());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        //Fenster Gruppenübersicht aktualisieren
                        mainFrame.setContent(new DGruppenbearbeiten(dVL, index));
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
        //Wechsel zurück zum Fenster Gruppenübersicht in der Dozentenansicht
        zurueckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DGruppenuebersicht(dVL, index));
            }
        });
        //für Logout
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
        GruppenbearbeitenPanel = new JPanel();
        GruppenbearbeitenPanel.setLayout(new GridLayoutManager(16, 4, new Insets(50, 20, 50, 20), -1, -1));
        zurueckButton = new JButton();
        zurueckButton.setText("zurück");
        GruppenbearbeitenPanel.add(zurueckButton, new GridConstraints(15, 1, 1, 2, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gruppeLoeschenButton = new JButton();
        gruppeLoeschenButton.setText("Gruppe löschen");
        GruppenbearbeitenPanel.add(gruppeLoeschenButton, new GridConstraints(11, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        teamLoeschenButton = new JButton();
        teamLoeschenButton.setText("Team löschen");
        GruppenbearbeitenPanel.add(teamLoeschenButton, new GridConstraints(12, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        GruppenbearbeitenPanel.add(spacer1, new GridConstraints(14, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        treeScrollPane = new JScrollPane();
        GruppenbearbeitenPanel.add(treeScrollPane, new GridConstraints(0, 0, 16, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tree = new JTree();
        treeScrollPane.setViewportView(tree);
        gruppenanzahl = new JLabel();
        gruppenanzahl.setText("Anzahl der Übungsgruppen");
        GruppenbearbeitenPanel.add(gruppenanzahl, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        grAnzahlTextField = new JTextField();
        GruppenbearbeitenPanel.add(grAnzahlTextField, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, -1), new Dimension(80, -1), new Dimension(80, -1), 0, false));
        tAnzahlTextField = new JTextField();
        GruppenbearbeitenPanel.add(tAnzahlTextField, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, -1), new Dimension(80, -1), new Dimension(80, -1), 0, false));
        teamanzahl = new JLabel();
        teamanzahl.setText("Anzahl der Teams");
        GruppenbearbeitenPanel.add(teamanzahl, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tGroesseTextField = new JTextField();
        GruppenbearbeitenPanel.add(tGroesseTextField, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(80, -1), new Dimension(80, -1), new Dimension(80, -1), 0, false));
        teamgroesse = new JLabel();
        teamgroesse.setText("Anzahl der Teammitglieder");
        GruppenbearbeitenPanel.add(teamgroesse, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logoutButton = new JButton();
        logoutButton.setText("Logout");
        GruppenbearbeitenPanel.add(logoutButton, new GridConstraints(0, 3, 5, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gruppeHinzufuegenButton = new JButton();
        gruppeHinzufuegenButton.setText("neue Gruppe hinzufügen");
        GruppenbearbeitenPanel.add(gruppeHinzufuegenButton, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        teamHinzufuegenButton = new JButton();
        teamHinzufuegenButton.setText("neues Team hinzufügen");
        GruppenbearbeitenPanel.add(teamHinzufuegenButton, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        GruppenbearbeitenPanel.add(spacer2, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        festlegenButton = new JButton();
        festlegenButton.setText("Anzahl festlegen");
        GruppenbearbeitenPanel.add(festlegenButton, new GridConstraints(5, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        successLabel = new JLabel();
        successLabel.setForeground(new Color(-16724992));
        successLabel.setText("Anzahl festgelegt");
        successLabel.setVisible(false);
        GruppenbearbeitenPanel.add(successLabel, new GridConstraints(9, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        studentLoeschenButton = new JButton();
        studentLoeschenButton.setText("Student löschen");
        GruppenbearbeitenPanel.add(studentLoeschenButton, new GridConstraints(13, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        studentZuTeamHinzufuegenButton = new JButton();
        studentZuTeamHinzufuegenButton.setText("Student zu Team hinzufügen");
        GruppenbearbeitenPanel.add(studentZuTeamHinzufuegenButton, new GridConstraints(8, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        studentNameTextField = new JTextField();
        GruppenbearbeitenPanel.add(studentNameTextField, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        studentNameLabel = new JLabel();
        studentNameLabel.setText("Name des Studenten");
        GruppenbearbeitenPanel.add(studentNameLabel, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        hinweisLabel = new JLabel();
        hinweisLabel.setText("(Vorname Nachname)");
        GruppenbearbeitenPanel.add(hinweisLabel, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return GruppenbearbeitenPanel;
    }

}
