/**@author Kristi, Diana
 * Klasse erstellt von Kristi und erweitert von Diana
 *
 * Fenster in dem der Student alle Veranstaltung einsehen und ausgewählten beitreten kann
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
import java.util.ArrayList;

public class SAlleVeranstaltungen implements FrameContent {

    /**
     * @author Kristi
     */
    private GUIMain mainFrame;

    private JPanel AlleVeranstaltungen;
    //JList wird erstellt
    private JList veranstaltungenList;
    private DefaultListModel alleLV = new DefaultListModel();
    private JScrollPane scrollPane;
    //Button zum Eintragen in die ausgewählte Veranstaltung
    private JButton eintragen;
    private JButton zurueckButton;
    /**
     * @author Diana
     */
    private DefaultListModel dLM = new DefaultListModel();
    private JButton logoutButton;
    private JLabel errorLabel;

    /**
     * @author Kristi
     */
    public String getName() {

        return "Veranstaltungsübersicht - Student";
    }

    public JPanel getPanel() {

        return AlleVeranstaltungen;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }

    /**
     * @author Oleg, Diana
     */
    public SAlleVeranstaltungen(GUIMain m) {
        mainFrame = m;
        StudentController ctr = (StudentController) mainFrame.getController();
        Student student = (Student) ctr.getSubject();
        ArrayList<Veranstaltung> alleVL = ctr.getAlleV();
        ArrayList<Veranstaltung> sVL = ctr.getVeranstaltungen();
        ArrayList<String> veranstaltungen = new ArrayList<String>();

        for (Veranstaltung v : alleVL) {
            veranstaltungen.add(v.getName());
            dLM.add(dLM.size(), v.getName());
        }

        //dLM.addAll(veranstaltungen);
        veranstaltungenList.setModel(dLM);

        eintragen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (veranstaltungenList.getSelectedIndex() >= 0) {
                    Veranstaltung v = alleVL.get(veranstaltungenList.getSelectedIndex());
                    ctr.eintragen(v);
                    //zurueck zur Uebersicht
                    mainFrame.setContent(new SVeranstaltungsuebersicht(mainFrame));
                    //alternativ gleich die neue Veranstaltung betrachten
                    //mainFrame.setContent(new SGruppenuebersicht(mainFrame,v));
                } else {
                    errorLabel.setVisible(true);
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
        AlleVeranstaltungen = new JPanel();
        AlleVeranstaltungen.setLayout(new GridLayoutManager(4, 3, new Insets(20, 50, 50, 20), -1, -1));
        zurueckButton = new JButton();
        zurueckButton.setText("zurück");
        AlleVeranstaltungen.add(zurueckButton, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        AlleVeranstaltungen.add(spacer1, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        eintragen = new JButton();
        eintragen.setText("in Veranstaltung eintragen");
        AlleVeranstaltungen.add(eintragen, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        logoutButton = new JButton();
        logoutButton.setText("Logout");
        AlleVeranstaltungen.add(logoutButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scrollPane = new JScrollPane();
        AlleVeranstaltungen.add(scrollPane, new GridConstraints(0, 0, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        veranstaltungenList = new JList();
        scrollPane.setViewportView(veranstaltungenList);
        errorLabel = new JLabel();
        errorLabel.setForeground(new Color(-52480));
        errorLabel.setText("Keine Veranstaltung ausgewählt");
        errorLabel.setVisible(false);
        AlleVeranstaltungen.add(errorLabel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return AlleVeranstaltungen;
    }

}
