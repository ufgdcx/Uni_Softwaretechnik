/**@author Kristi, Diana
 * Klasse erstellt von Kristi und erweitert von Diana
 *
 * Fenster in dem der Student alle Veranstaltungen einsehen kann, in die er sich eingetragen hat
 * */

package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import Controller.*;
import javax.swing.*;
import java.awt.*;
import Klassen.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SVeranstaltungsuebersicht implements FrameContent {
    /**
     * @author Kristi
     */
    private GUIMain mainFrame;

    private JPanel VeranstaltungsuebersichtPanel;
    //Liste, in der die Veranstaltungen zu sehen sind, denen der Student beigetreten ist
    private JList veranstaltungenList;
    //Button zum Fenster "Gruppenübersicht", um Übungsgruppe/Team beizutreten oder zu verlassen
    private JButton bearbeiten;
    //Button zum Fenster "Leistungsübersicht", um studentische Leistungen einzusehen
    private JButton ansehen;
    //Button zum Fenster mit allen Veranstaltungen, um Veranstaltung(en) beizutreten
    private JButton hinzufuegen;
    /**
     * @author Diana
     */
    //Button für Logout
    private JButton logoutButton;
    //Button zum Verlassen einer Veranstaltung
    private JButton verlassen;
    //für eine dynamische Liste
    private DefaultListModel dLM = new DefaultListModel();

    /**
     * @author Kristi
     */
    public String getName() {
        return "Veranstaltungsübersicht - Student";
    }

    public JPanel getPanel() {
        return VeranstaltungsuebersichtPanel;
    }

    public void setParentFrame(GUIMain m) {
        mainFrame = m;
    }

    /**
     * @author Oleg, Diana
     */
    public SVeranstaltungsuebersicht(GUIMain m) {
    	mainFrame = m;
    	StudentController ctr = (StudentController) mainFrame.getController();
    	Student student = (Student) ctr.getSubject();
    	ArrayList<Veranstaltung> VL = ctr.getVeranstaltungen();
    	int preview = 1;
    	
    	ArrayList<String> veranstaltungen = new ArrayList<String>();

        for (Veranstaltung v : VL) {
            veranstaltungen.add(v.getName());
            dLM.add(dLM.size(), v.getName());
        }

        //dLM.addAll(veranstaltungen);
        veranstaltungenList.setModel(dLM);

        hinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new SAlleVeranstaltungen(mainFrame));
            }
        });
        verlassen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (veranstaltungenList.getSelectedIndex() >= 0) {
	            	Veranstaltung v = VL.get(veranstaltungenList.getSelectedIndex());
	            	ctr.austragen(v);
	            	//Uebersicht neu laden
	            	mainFrame.setContent(new SVeranstaltungsuebersicht(mainFrame));
            	}
            }
        });
        bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (veranstaltungenList.getSelectedIndex() >= 0) {
                	Veranstaltung v = VL.get(veranstaltungenList.getSelectedIndex());
                    mainFrame.setContent(new SGruppenuebersicht(mainFrame,v));
                }
            }
        });
        ansehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (veranstaltungenList.getSelectedIndex() >= 0) {
            		Veranstaltung v = VL.get(veranstaltungenList.getSelectedIndex());
            		mainFrame.setContent(new SLeistungsuebersicht(mainFrame, v));
            	}
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
     *//*
    public SVeranstaltungsuebersicht(Student student, ArrayList<Veranstaltung> alleVL, ArrayList<Veranstaltung> sVL, int index, int preview) {

        ArrayList<String> veranstaltungen = new ArrayList<String>();

        for (Veranstaltung v : sVL) {
            veranstaltungen.add(v.getName());
            dLM.add(dLM.size(), v.getName());
        }

        //dLM.addAll(veranstaltungen);
        veranstaltungenList.setModel(dLM);

        hinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setContent(new SAlleVeranstaltungen(student, alleVL, sVL, veranstaltungenList.getSelectedIndex(), preview));
            }
        });
        verlassen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (veranstaltungenList.getSelectedIndex() >= 0) {
                    mainFrame.setContent(new SGruppenuebersicht(student, alleVL, sVL, veranstaltungenList.getSelectedIndex(), 1));
                }
            }
        });
        ansehen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (veranstaltungenList.getSelectedIndex() >= 0) {
            		mainFrame.setContent(new SLeistungsuebersicht(student, alleVL, sVL, veranstaltungenList.getSelectedIndex(), preview));
            	}
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new LogoutSeite());
            }
        });
    }*/

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
        VeranstaltungsuebersichtPanel = new JPanel();
        VeranstaltungsuebersichtPanel.setLayout(new GridLayoutManager(5, 3, new Insets(50, 20, 50, 20), -1, -1));
        veranstaltungenList = new JList();
        VeranstaltungsuebersichtPanel.add(veranstaltungenList, new GridConstraints(0, 0, 5, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        hinzufuegen = new JButton();
        hinzufuegen.setText("Veranstaltung hinzufügen");
        VeranstaltungsuebersichtPanel.add(hinzufuegen, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bearbeiten = new JButton();
        bearbeiten.setText("Gruppen und Teams bearbeiten");
        VeranstaltungsuebersichtPanel.add(bearbeiten, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ansehen = new JButton();
        ansehen.setText("Leistung ansehen");
        VeranstaltungsuebersichtPanel.add(ansehen, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        VeranstaltungsuebersichtPanel.add(spacer1, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        logoutButton = new JButton();
        logoutButton.setText("Logout");
        VeranstaltungsuebersichtPanel.add(logoutButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        verlassen = new JButton();
        verlassen.setText("Veranstaltung verlassen");
        VeranstaltungsuebersichtPanel.add(verlassen, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return VeranstaltungsuebersichtPanel;
    }

}
