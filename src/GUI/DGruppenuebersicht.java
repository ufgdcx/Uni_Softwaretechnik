/**@author Kristi, Diana
 * Klasse erstellt von Kristi und erweitert von Diana
 *
 * Fenster in dem der Dozent eine Übersicht über die (Uebungs-)Gruppen und Teams hat
 * */

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

public class DGruppenuebersicht implements FrameContent {

    /**
     * @author Kristi
     */
    private GUIMain mainFrame;
    private JPanel GruppenuebersichtPanel;
    private JButton einsehen;
    private JButton bearbeiten;
    private JButton zurueck;
    private JButton logoutButton;
    private JTree tree;
    private JScrollPane treeScrollPane;
    private JButton leistungsuebersichtBearbeitenButton;
    private JButton alleAusklappenButton;
    private JButton allesEinklappenButton;

    public String getName() {
        return "Gruppen- und Teamübersicht - Dozent";
    }

    public JPanel getPanel() {
        return GruppenuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {
        mainFrame = m;
    }

    /**
     * @author Diana
     */
    public DGruppenuebersicht(ArrayList<Veranstaltung> dVL, int index) {

        //initialisiere den Baum
        treeScrollPane.setViewportView(tree);
        //Überprüfung des ScrollPane auf Veränderungen und Aktualisierung der Daten mit Hilfe der DB
        treeScrollPane.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                tree = mainFrame.getController().createGruppenTree(dVL.get(index), treeScrollPane);
            }
        });
        alleAusklappenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tree.getRowCount(); i++) {
                    tree.expandRow(i);
                }
            }
        });
        allesEinklappenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = tree.getRowCount(); i > 0; i--) {
                    tree.collapseRow(i);
                }
            }
        });
        bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DGruppenbearbeiten(dVL, index));
            }
        });
        einsehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tree.getSelectionPath().getPath().length >= 4) {
                    //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Gruppe, Team, Student zurück
                    //Auswahl des 2. Arrayelements und absplitten der GruppenID
                    String gruppenID = tree.getSelectionPath().getPathComponent(1).toString();
                    gruppenID = gruppenID.split(" ")[1];
                    //Auswahl des 3. Arrayelements und absplitten der TeamID
                    String teamID = tree.getSelectionPath().getPathComponent(2).toString();
                    teamID = teamID.split(" ")[1];
                    //Auswahl des 3. Arrayelements
                    String student = tree.getSelectionPath().getPathComponent(3).toString();
                    String vornameStudent = student.split(" ")[0];
                    String nachnameStudent = student.split(" ")[1];
                    for (Gruppe g : mainFrame.getController().getGruppen(dVL.get(index))) {
                        if (g.getGruppenID() == Integer.parseInt(gruppenID)) {
                            for (Team t : mainFrame.getController().getTeams(g)) {
                                if (t.getTeamID() == Integer.parseInt(teamID)) {
                                    for (Student s : mainFrame.getController().getStudenten(t)) {
                                        if (s.getVorname().equals(vornameStudent) && s.getNachname().equals(nachnameStudent)) {
                                            mainFrame.setContent(new DLeistungsuebersicht(dVL, s, index, t));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        leistungsuebersichtBearbeitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new DLeistungUebersichtbearbeiten(dVL, index));
            }
        });
        zurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DVeranstaltung(dVL, index));

            }
        });
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
        GruppenuebersichtPanel = new JPanel();
        GruppenuebersichtPanel.setLayout(new GridLayoutManager(9, 3, new Insets(50, 20, 50, 20), -1, -1));
        zurueck = new JButton();
        zurueck.setText("zurück");
        GruppenuebersichtPanel.add(zurueck, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logoutButton = new JButton();
        logoutButton.setText("Logout");
        GruppenuebersichtPanel.add(logoutButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        GruppenuebersichtPanel.add(spacer1, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        treeScrollPane = new JScrollPane();
        GruppenuebersichtPanel.add(treeScrollPane, new GridConstraints(0, 0, 9, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tree = new JTree();
        treeScrollPane.setViewportView(tree);
        einsehen = new JButton();
        einsehen.setText("Leistung einsehen und bearbeiten");
        GruppenuebersichtPanel.add(einsehen, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        GruppenuebersichtPanel.add(spacer2, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        leistungsuebersichtBearbeitenButton = new JButton();
        leistungsuebersichtBearbeitenButton.setText("Leistungsübersicht bearbeiten");
        GruppenuebersichtPanel.add(leistungsuebersichtBearbeitenButton, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bearbeiten = new JButton();
        bearbeiten.setText("Gruppen und Teams bearbeiten");
        GruppenuebersichtPanel.add(bearbeiten, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        alleAusklappenButton = new JButton();
        alleAusklappenButton.setText("Alle ausklappen");
        GruppenuebersichtPanel.add(alleAusklappenButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        allesEinklappenButton = new JButton();
        allesEinklappenButton.setText("Alles einklappen");
        GruppenuebersichtPanel.add(allesEinklappenButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        GruppenuebersichtPanel.add(spacer3, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return GruppenuebersichtPanel;
    }

}
