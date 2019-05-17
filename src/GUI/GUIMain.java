package GUI;

import javax.swing.*;
import java.awt.*;


public class GUIMain extends JFrame {
  private FrameContent content;

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


}