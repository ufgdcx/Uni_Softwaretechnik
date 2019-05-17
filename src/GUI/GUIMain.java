package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUIMain extends JFrame {
  private FrameContent content;
  private Listener def = new Listener();

  private JPanel panel = new JPanel();
  private JPanel npanel = new JPanel();

  private JButton uebersicht = new JButton("Veranstaltungsübersicht");
  private JButton logout = new JButton("Logout");

  public GUIMain(int width, int height) {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("GUIMain");
    this.setSize(width, height);
    setContent(new Startseite());
    this.setVisible(true);
    uebersicht.addActionListener(def);
    logout.addActionListener(def);
  }

  public FrameContent getContent() {
    return content;
  }

  public void setContent(FrameContent content) {
    content.setParentFrame(this);
    this.content = content;
    this.setTitle(content.getName());
    this.getContentPane().removeAll();
    this.getContentPane().add(content.getPanel());
    panel = content.getPanel();
    if(!content.getName().equals("Startseite")) {
      panel.add(npanel, BorderLayout.NORTH);
      npanel.setLayout(new GridLayout());
      npanel.add(uebersicht);
      npanel.add(logout);
    }
    this.revalidate();
    this.repaint();
  }
  private class Listener implements ActionListener {
       @Override
       public void actionPerformed(ActionEvent e) {
           if (e.getSource() == uebersicht) {
               setContent(new SVeranstaltungsuebersicht());
           }
           if (e.getSource() == logout) {
               setContent(new Startseite());
           }
        }
    }

}