/**@author Kristi, Diana
 * Klasse erstellt von Kristi und erweitert von Diana
 *
 * Fenster in dem der Student alle seine ihm zugehörigen Leistungen einsehen kann
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


public class SLeistungsuebersicht implements FrameContent {
    /**
     * @author Kristi
     */
    private GUIMain mainFrame;

    private JPanel LeistungsuebersichtPanel;
    private JButton zurueck;
    /**
     * @author Diana
     */
    private JButton logoutButton;
    private JTree tree;
    private JScrollPane treeScrollPane;

    /**
     * @author Kristi
     */
    public String getName() {

        return "Leistungsübersicht - Student";
    }

    public JPanel getPanel() {

        return LeistungsuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    /**
     * @author Diana, Oleg
     */
    public SLeistungsuebersicht(GUIMain m, Veranstaltung v) {
        mainFrame = m;
        StudentController ctr = (StudentController) mainFrame.getController();

        //initialisiere den Baum
        treeScrollPane.setViewportView(tree);
        //Überprüfung des ScrollPane auf Veränderungen und Aktualisierung der Daten mit Hilfe der DB
        treeScrollPane.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                tree = ctr.createLeistungsTree(v, treeScrollPane);
                for (int i = 0; i < tree.getRowCount(); i++) {
                    tree.expandRow(i);
                }
            }
        });

        zurueck.addActionListener(new ActionListener() {
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
        LeistungsuebersichtPanel.setLayout(new GridLayoutManager(3, 2, new Insets(20, 50, 50, 20), -1, -1));
        logoutButton = new JButton();
        logoutButton.setText("Logout");
        LeistungsuebersichtPanel.add(logoutButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        treeScrollPane = new JScrollPane();
        LeistungsuebersichtPanel.add(treeScrollPane, new GridConstraints(0, 0, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tree = new JTree();
        treeScrollPane.setViewportView(tree);
        zurueck = new JButton();
        zurueck.setText("zurück");
        LeistungsuebersichtPanel.add(zurueck, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        LeistungsuebersichtPanel.add(spacer1, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return LeistungsuebersichtPanel;
    }

}
