package GUI;

import com.sun.source.tree.Tree;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DGruppenbearbeiten implements FrameContent{

    private GUIMain mainFrame;

    private JButton bestätigen;
    private JButton zurückButton;
    private JPanel GruppenbearbeitenPanel;
    private JPanel TreePanel;
    private JTree tree;
    private JButton button1;

    public String getNachname() {

        return "Gruppen und Teams bearbeiten";
    }

    public JPanel getPanel() {
        return GruppenbearbeitenPanel;
    }

    public void setParentFrame(GUIMain m) {

        mainFrame = m;
    }


    public DGruppenbearbeiten() {

        bestätigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To Do:

            }
        });
        zurückButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new DGruppenübersicht());
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setContent(new LogoutSeite());
            }
        });
    }
}
