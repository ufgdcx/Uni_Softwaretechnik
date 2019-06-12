/**@author Diana
 * Klasse erstellt und erweitert von Diana
 *
 * Fenster zum Einlesen der Gruppeninformationen (wie Datum, Uhrzeit, Einschreibefrist,...) in der Dozentenansicht
 */

package GUI;

import Klassen.Veranstaltung;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DGruppenInformationen implements FrameContent {
    private GUIMain mainFrame;
    private JPanel DGruppenInformationenPanel;
    private JLabel grIDLabel;
    private JTextField tag;
    private JTextField zeit;
    private JTextField rhythmus;
    private JTextField frist;
    private JButton weiterButton;
    private JLabel fristLabel;
    private JLabel rhythmusLabel;
    private JLabel tagLabel;
    private JLabel zeitLabel;
    private JLabel seitenLabel;
    private JLabel dateFormat;
    private JLabel timeFormat;

    public String getName() {
        return "Gruppeninformationen hinzufügen - Dozent";
    }

    public JPanel getPanel() {
        return DGruppenInformationenPanel;
    }

    public void setParentFrame(GUIMain m) {
        mainFrame = m;
    }

    public DGruppenInformationen(ArrayList<Veranstaltung> dVL, int index, int gruppenanzahl, int counter) {


        //grIDLabel.setText(mainFrame.getController().createGruppenID(dVL.get(index)) + ":");
        seitenLabel.setText(counter + " / " + gruppenanzahl);

        if (gruppenanzahl == counter) {
            weiterButton.setText("OK");
        }
        weiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Umwandlung des String aus fristTextField in sql-Date
                    String efrist = frist.getText();
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy");
                    java.util.Date date1 = sdf1.parse(efrist);
                    Date einschreibefrist = new Date(date1.getTime());

                    //Umwandlung des String aus zeitTextField in sql-Time
                    String uzeit = zeit.getText();
                    SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
                    java.util.Date date2 = sdf2.parse(uzeit);
                    Time uhrzeit = new Time(date2.getTime());

                    mainFrame.getController().createGruppe(mainFrame.getController().createGruppenID(dVL.get(index)), dVL.get(index).getDozenten().get(0), dVL.get(index).getName(), einschreibefrist, uhrzeit, tag.getText(), rhythmus.getText());

                    if (gruppenanzahl == counter) {
                        mainFrame.setContent(new DGruppenbearbeiten(dVL, index));
                    } else {
                        mainFrame.setContent(new DGruppenInformationen(dVL, index, gruppenanzahl, counter + 1));
                    }

                } catch (ParseException ex) {
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
        DGruppenInformationenPanel = new JPanel();
        DGruppenInformationenPanel.setLayout(new GridLayoutManager(6, 4, new Insets(50, 150, 300, 500), -1, -1));
        grIDLabel = new JLabel();
        grIDLabel.setText("GruppenID");
        DGruppenInformationenPanel.add(grIDLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tagLabel = new JLabel();
        tagLabel.setText("Wochentag");
        DGruppenInformationenPanel.add(tagLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        zeitLabel = new JLabel();
        zeitLabel.setText("Uhrzeit");
        DGruppenInformationenPanel.add(zeitLabel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        rhythmusLabel = new JLabel();
        rhythmusLabel.setText("Wochenrhythmus");
        DGruppenInformationenPanel.add(rhythmusLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fristLabel = new JLabel();
        fristLabel.setText("Einschreibefrist");
        DGruppenInformationenPanel.add(fristLabel, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tag = new JTextField();
        tag.setToolTipText("Montag, Dienstag, ...");
        DGruppenInformationenPanel.add(tag, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(100, -1), new Dimension(100, -1), new Dimension(100, -1), 0, false));
        zeit = new JTextField();
        DGruppenInformationenPanel.add(zeit, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(100, -1), new Dimension(100, -1), new Dimension(100, -1), 0, false));
        rhythmus = new JTextField();
        DGruppenInformationenPanel.add(rhythmus, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(100, -1), new Dimension(100, -1), new Dimension(100, -1), 0, false));
        frist = new JTextField();
        frist.setToolTipText("tt-mm-jjjj");
        DGruppenInformationenPanel.add(frist, new GridConstraints(4, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(100, -1), new Dimension(100, -1), new Dimension(100, -1), 0, false));
        seitenLabel = new JLabel();
        seitenLabel.setText("Seitenanzahl");
        DGruppenInformationenPanel.add(seitenLabel, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        weiterButton = new JButton();
        weiterButton.setText("weiter");
        DGruppenInformationenPanel.add(weiterButton, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        timeFormat = new JLabel();
        timeFormat.setText("HH:mm");
        DGruppenInformationenPanel.add(timeFormat, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dateFormat = new JLabel();
        dateFormat.setText("dd.MM.yyyy");
        DGruppenInformationenPanel.add(dateFormat, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return DGruppenInformationenPanel;
    }

}
