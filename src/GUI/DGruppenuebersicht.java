package GUI;

import Klassen.Veranstaltung;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DGruppenuebersicht implements FrameContent {


    private GUIMain mainFrame;
    private JPanel GruppenuebersichtPanel;
    private JButton einsehen;
    private JButton bearbeiten;
    private JButton zurueck;
    private JButton logoutButton;
    private JTree tree;

    public String getName() {

        return "Gruppen- und Teamübersicht - Dozent";
    }

    public JPanel getPanel() {

        return GruppenuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    public DGruppenuebersicht(ArrayList<Veranstaltung> dVL, int index) {


        einsehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DLeistungsuebersicht(dVL, index));
            }
        });
        bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new DGruppenbearbeiten(dVL, index));
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
        GruppenuebersichtPanel.setLayout(new GridLayoutManager(4, 3, new Insets(50, 20, 50, 20), -1, -1));
        einsehen = new JButton();
        einsehen.setText("Leistung einsehen");
        GruppenuebersichtPanel.add(einsehen, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        zurueck = new JButton();
        zurueck.setText("zurück");
        GruppenuebersichtPanel.add(zurueck, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logoutButton = new JButton();
        logoutButton.setText("Logout");
        GruppenuebersichtPanel.add(logoutButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bearbeiten = new JButton();
        bearbeiten.setText("Gruppen und Teams bearbeiten");
        GruppenuebersichtPanel.add(bearbeiten, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        GruppenuebersichtPanel.add(spacer1, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tree = new JTree();
        GruppenuebersichtPanel.add(tree, new GridConstraints(0, 0, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return GruppenuebersichtPanel;
    }
}
