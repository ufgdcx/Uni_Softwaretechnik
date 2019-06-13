/**@author Diana
 * Klasse erstellt und erweitert von Diana
 *
 * Fenster zum Einlesen der Teaminformationen (Thema) in der Dozentenansicht
 */

package GUI;

import Klassen.Gruppe;
import Klassen.Veranstaltung;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DTeamInformationen implements FrameContent {

    private GUIMain mainFrame;
    private JLabel teamIDLabel;
    private JLabel themaLabel;
    private JTextField thema;
    private JLabel seitenzahlLabel;
    private JButton weiterButton;
    private JPanel teamInformationenPanel;

    public String getName() {
        return "Teaminformationen hinzufügen - Dozent";
    }

    public JPanel getPanel() {
        return teamInformationenPanel;
    }

    public void setParentFrame(GUIMain m) {
        mainFrame = m;
    }

    public DTeamInformationen(ArrayList<Veranstaltung> dVL, int index, int gruppenID, int teamanzahl, int counter) {

        seitenzahlLabel.setText(counter + " / " + teamanzahl);

        if (teamanzahl == counter) {
            weiterButton.setText("OK");
        }

        weiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Holt die Gruppen der Veranstaltung vom Maincontroller und testet, ob GruppenID der gewählten GruppenID entspricht
                    for (Gruppe g : mainFrame.getController().getGruppen(dVL.get(index))) {
                        if (g.getGruppenID() == gruppenID) {
                            mainFrame.getController().createTeam(gruppenID, mainFrame.getController().createTeamID(g), dVL.get(index).getName(), thema.getText());
                            break;
                        }
                    }
                    if (teamanzahl == counter) {
                        mainFrame.setContent(new DGruppenbearbeiten(dVL, index));
                    } else {
                        mainFrame.setContent(new DTeamInformationen(dVL, index, gruppenID, teamanzahl, counter + 1));
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
        teamInformationenPanel = new JPanel();
        teamInformationenPanel.setLayout(new GridLayoutManager(3, 3, new Insets(50, 150, 500, 500), -1, -1));
        teamIDLabel = new JLabel();
        teamIDLabel.setText("TeamID");
        teamInformationenPanel.add(teamIDLabel, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        themaLabel = new JLabel();
        themaLabel.setText("Thema");
        teamInformationenPanel.add(themaLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        thema = new JTextField();
        teamInformationenPanel.add(thema, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        seitenzahlLabel = new JLabel();
        seitenzahlLabel.setText("Seitenanzahl");
        teamInformationenPanel.add(seitenzahlLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        weiterButton = new JButton();
        weiterButton.setText("weiter");
        teamInformationenPanel.add(weiterButton, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return teamInformationenPanel;
    }

}