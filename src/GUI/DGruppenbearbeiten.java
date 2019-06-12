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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
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
    private JLabel gruppenanzahl;
    private JTextField grAnzahlTextField;
    private JLabel teamanzahl;
    private JTextField tAnzahlTextField;
    private JLabel teamgroesse;
    private JTextField tGroesseTextField;
    private JButton gruppeHinzufuegenButton;
    private JButton teamHinzufuegenButton;
    private JButton gruppeLoeschenButton;
    private JButton teamLoeschenButton;
    private JLabel errorLabel;
    private JButton logoutButton;

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
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(dVL.get(index).getName());
        treeScrollPane.setViewportView(new JTree(root));
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

        //Überprüfung des ScrollPane auf Veränderungen und Aktualisierung der Daten mit Hilfe der Datenbank
        treeScrollPane.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                mainFrame.getController().createGruppenTree(dVL.get(index), treeScrollPane);
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
        //zum Hinzufügen von Teams als Child in den Tree
        teamHinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //zum Löschen von Gruppen als Parent in den Tree
        gruppeLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //zum Löschen von Teams als Child in den Tree
        teamLoeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                root.remove(selectedNode);
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
        GruppenbearbeitenPanel.setLayout(new GridLayoutManager(11, 4, new Insets(50, 20, 50, 20), -1, -1));
        zurueckButton = new JButton();
        zurueckButton.setText("zurück");
        GruppenbearbeitenPanel.add(zurueckButton, new GridConstraints(10, 1, 1, 2, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gruppeLoeschenButton = new JButton();
        gruppeLoeschenButton.setText("Gruppe löschen");
        GruppenbearbeitenPanel.add(gruppeLoeschenButton, new GridConstraints(7, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        teamLoeschenButton = new JButton();
        teamLoeschenButton.setText("Team löschen");
        GruppenbearbeitenPanel.add(teamLoeschenButton, new GridConstraints(8, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        GruppenbearbeitenPanel.add(spacer1, new GridConstraints(9, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        treeScrollPane = new JScrollPane();
        GruppenbearbeitenPanel.add(treeScrollPane, new GridConstraints(0, 0, 11, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
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
        errorLabel = new JLabel();
        errorLabel.setForeground(new Color(-52480));
        errorLabel.setText("Bitte alle Textfelder füllen.");
        errorLabel.setVisible(false);
        GruppenbearbeitenPanel.add(errorLabel, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gruppeHinzufuegenButton = new JButton();
        gruppeHinzufuegenButton.setText("neue Gruppe hinzufügen");
        GruppenbearbeitenPanel.add(gruppeHinzufuegenButton, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        teamHinzufuegenButton = new JButton();
        teamHinzufuegenButton.setText("neues Team hinzufügen");
        GruppenbearbeitenPanel.add(teamHinzufuegenButton, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        GruppenbearbeitenPanel.add(spacer2, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return GruppenbearbeitenPanel;
    }

}
