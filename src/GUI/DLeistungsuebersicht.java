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
    private JPanel LeistungsuebersichtPanel;
    private JTree tree;
    private JScrollPane treeScrollPane;
    //Label und Textfeld fuer die hinzuzufuegende Bewertung
    private JLabel BewertungLabel;
    private JTextField bewertung;
    //Button zum Hinzufuegen einer Bewertung eines Teams
    private JButton teambewertungHinzufuegenButton;
    //Button zum Hinzufuegen einer Bewertung eines Studenten
    private JButton einzelbewertungHinzufuegenButton;
    //Button zum Zurueckkehren zur Gruppenuebersicht
    private JButton zurueckButton;
    /**
     * @author Diana
     */
    private JButton logoutButton;
    private JButton aufgabeHinzufuegen;

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
                tree = mainFrame.getController().createLeistungsTreeStudent(dVL.get(index), student, treeScrollPane);
                for (int i = 0; i < tree.getRowCount(); i++) {
                    tree.expandRow(i);
                }
            }

        });
        //zum Hinzufuegen von Einzelleistungen für einen Studenten
        einzelbewertungHinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int punkte = Integer.parseInt(bewertung.getText());
                try {
                    if (tree.getSelectionPath().getPath().length >= 4) {
                        //tree.getSelectionPath().getPathComponent(index).toString() gibt Array mit Veranstaltungsname, Leistungsname, Unterblockname, Aufgabenname zurück
                        //Auswahl des 2. Arrayelements = Name der Leistung
                        String leistung = tree.getSelectionPath().getPathComponent(1).toString();
                        //Auswahl des 3. Arrayelements = Name des Unterblock
                        String ub = tree.getSelectionPath().getPathComponent(2).toString();
                        //Auswahl des 4. Arrayelements = Name der Aufgabe
                        String aufgabe = tree.getSelectionPath().getPathComponent(3).toString();
                        aufgabe = aufgabe.split(" ")[0];
                        mainFrame.getController().updateEinzelleistungPunkte(student.getMatrikelnr(), dVL.get(index).getName(), ub, aufgabe, leistung, punkte);
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
        //zum Hinzufuegen von Gruppenleistungen für ein Team
        teambewertungHinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        LeistungsuebersichtPanel.setLayout(new GridLayoutManager(5, 4, new Insets(50, 20, 50, 20), -1, -1));
        einzelbewertungHinzufuegenButton = new JButton();
        einzelbewertungHinzufuegenButton.setText("Einzelbewertung hinzufügen");
        LeistungsuebersichtPanel.add(einzelbewertungHinzufuegenButton, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        BewertungLabel = new JLabel();
        BewertungLabel.setText("Bewertung");
        LeistungsuebersichtPanel.add(BewertungLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        zurueckButton = new JButton();
        zurueckButton.setText("zurück");
        LeistungsuebersichtPanel.add(zurueckButton, new GridConstraints(4, 1, 1, 2, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        teambewertungHinzufuegenButton = new JButton();
        teambewertungHinzufuegenButton.setText("Teambewertung hinzufügen");
        LeistungsuebersichtPanel.add(teambewertungHinzufuegenButton, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bewertung = new JTextField();
        bewertung.setText("");
        LeistungsuebersichtPanel.add(bewertung, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, -1), new Dimension(50, -1), new Dimension(50, -1), 0, false));
        final Spacer spacer1 = new Spacer();
        LeistungsuebersichtPanel.add(spacer1, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        treeScrollPane = new JScrollPane();
        LeistungsuebersichtPanel.add(treeScrollPane, new GridConstraints(0, 0, 5, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tree = new JTree();
        treeScrollPane.setViewportView(tree);
        logoutButton = new JButton();
        logoutButton.setText("Logout");
        LeistungsuebersichtPanel.add(logoutButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return LeistungsuebersichtPanel;
    }

}
