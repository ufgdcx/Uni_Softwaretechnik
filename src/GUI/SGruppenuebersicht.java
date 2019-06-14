/**@author Kristi, Diana
 * Klasse erstellt von Kristi und erweitert von Diana
 *
 * Fenster in dem der Student alle Gruppen und Teams einsehen und einem ausgewählten Team beitreten kann
 * */

package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import Controller.StudentController;

import Klassen.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class SGruppenuebersicht implements FrameContent {
    /**
     * @author Kristi
     */
    private GUIMain mainFrame;

    private JPanel GruppenuebersichtPanel;
    private JButton beitreten;
    private JButton verlassen;
    private JButton zurueckButton;
    private JTree tree;
    /**
     * @author Diana
     */
    private JButton logoutButton;
    private JScrollPane treeScrollPane;

    /**
     * @author Kristi
     */
    public String getName() {

        return "Gruppenübersicht - Student";
    }

    public JPanel getPanel() {

        return GruppenuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    /**
     * @author Oleg, Diana
     */
    public SGruppenuebersicht(GUIMain m, Veranstaltung v) {
        mainFrame = m;
        StudentController ctr = (StudentController) mainFrame.getController();
        Student student = (Student) ctr.getSubject();
        ArrayList<Veranstaltung> alleVL = ctr.getAlleV();
        ArrayList<Veranstaltung> sVL = ctr.getVeranstaltungen();
        ArrayList<String> veranstaltungen = new ArrayList<String>();

        //initialisiere den Baum
        treeScrollPane.setViewportView(tree);
        //Überprüfung des ScrollPane auf Veränderungen und Aktualisierung der Daten mit Hilfe der DB
        treeScrollPane.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                tree = mainFrame.getController().createGruppenTree(v, treeScrollPane);
            }
        });

        beitreten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tree.getSelectionPath().getPath().length >= 3) {
                    //getSelectionPath().getPathComponent gibt Array mit Veranstaltungsname, Gruppe, Team, Student zurück
                    //Auswahl des 1. Arrayelements
                    String veranstaltungsname = tree.getSelectionPath().getPathComponent(0).toString();
                    //Auswahl des 2. Arrayelements und absplitten der GruppenID
                    String gruppenID = tree.getSelectionPath().getPathComponent(1).toString();
                    gruppenID = gruppenID.split(" ")[1];
                    //Auswahl des 3. Arrayelements und absplitten der TeamID
                    String teamID = tree.getSelectionPath().getPathComponent(2).toString();
                    teamID = teamID.split(" ")[1];
                    //DB-Eintrag löschen
                    mainFrame.getController().createGehoertZu(student.getMatrikelnr(), Integer.parseInt(teamID), Integer.parseInt(gruppenID), veranstaltungsname);
                    //Fenster Gruppenübersicht aktualisieren
                    mainFrame.setContent(new SGruppenuebersicht(mainFrame, v));
                } else {
                    //TODO: ErrorDialog öffnen
                }
            }
        });
        verlassen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tree.getSelectionPath().getPath().length >= 3) {
                        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Gruppe, Team, Student zurück
                        //Auswahl des 1. Arrayelements
                        String veranstaltungsname = tree.getSelectionPath().getPathComponent(0).toString();
                        //Auswahl des 2. Arrayelements und absplitten der GruppenID
                        String gruppenID = tree.getSelectionPath().getPathComponent(1).toString();
                        gruppenID = gruppenID.split(" ")[1];
                        //Auswahl des 3. Arrayelements und absplitten der TeamID
                        String teamID = tree.getSelectionPath().getPathComponent(2).toString();
                        teamID = teamID.split(" ")[1];
                        //DB-Eintrag löschen
                        mainFrame.getController().deleteGehoertZu(student.getMatrikelnr(), Integer.parseInt(teamID), Integer.parseInt(gruppenID), veranstaltungsname);
                        //Fenster Gruppenübersicht aktualisieren
                        mainFrame.setContent(new SGruppenuebersicht(mainFrame, v));
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
                mainFrame.setContent(new SVeranstaltungsuebersicht(mainFrame));
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new LogoutSeite());
            }
        });
    }

    /**
     * @author Diana, Oleg
     * urspruenglicher Code von Diana, Anpassung als Funktion von Oleg
     */
    String[] getTreeSelection() {
        String[] slc = new String[3];
        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Gruppe, Team, Student zurück
        //Auswahl des 1. Arrayelements (Veranstaltungsname)
        slc[0] = tree.getSelectionPath().getPathComponent(0).toString();
        //Auswahl des 2. Arrayelements und absplitten der GruppenID
        slc[1] = tree.getSelectionPath().getPathComponent(1).toString();
        slc[1] = slc[1].split(" ")[1];
        //Auswahl des 3. Arrayelements und absplitten der TeamID
        slc[2] = tree.getSelectionPath().getPathComponent(2).toString();
        slc[2] = slc[2].split(" ")[1];
        return slc;
    }

    /**
     * @author Diana
     */
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
        GruppenuebersichtPanel.setLayout(new GridLayoutManager(4, 3, new Insets(20, 50, 50, 20), -1, -1));
        beitreten = new JButton();
        beitreten.setText("Team beitreten");
        GruppenuebersichtPanel.add(beitreten, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        GruppenuebersichtPanel.add(panel1, new GridConstraints(0, 0, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        treeScrollPane = new JScrollPane();
        panel1.add(treeScrollPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tree = new JTree();
        treeScrollPane.setViewportView(tree);
        verlassen = new JButton();
        verlassen.setText("Team verlassen");
        GruppenuebersichtPanel.add(verlassen, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        zurueckButton = new JButton();
        zurueckButton.setText("zurück");
        GruppenuebersichtPanel.add(zurueckButton, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        GruppenuebersichtPanel.add(spacer1, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        logoutButton = new JButton();
        logoutButton.setText("Logout");
        GruppenuebersichtPanel.add(logoutButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return GruppenuebersichtPanel;
    }

}
