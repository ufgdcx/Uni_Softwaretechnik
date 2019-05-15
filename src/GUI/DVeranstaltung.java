package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;


import javax.swing.*;

public class DVeranstaltung implements FrameContent {
  private String name = "Veranstaltung";
  private GUIMain mainFrame;
  private Listener def = new Listener();

  private JPanel panel = new JPanel();
  private JPanel epanel = new JPanel();
  private JPanel cpanel = new JPanel();

  private JButton bearbeiten = new JButton("Informationen bearbeiten");
  private JButton gruppen = new JButton("Gruppen und Teams ansehen");

  private JLabel dozent = new JLabel("Dozent der Veranstaltung"); //Platzhalter für verantwortlichen Dozenten aus DB
  private JLabel infos = new JLabel("Infos über Veranstaltung"); //Platzhalter für Veranstaltungsinfos aus DB

  String veranstaltungen[] = {"Softwaretechnik", "Betriebssysteme", "Verteilte Systeme"}; //Platzhalter für eingeschriebene Veranstaltungen aus DB


  public DVeranstaltung() {

    panel.setLayout(new BorderLayout());
    epanel.setLayout(new GridLayout(2, 1));
    cpanel.setLayout(new GridLayout(2, 1));


    panel.add(cpanel, BorderLayout.CENTER);
    panel.add(epanel, BorderLayout.EAST);

    epanel.add(bearbeiten);
    epanel.add(gruppen);

    cpanel.add(infos);
    cpanel.add(dozent);

    bearbeiten.addActionListener(def);
    gruppen.addActionListener(def);

  }

  public String getName() {
    return name;
  }

  public JPanel getPanel() {
    return panel;
  }

  public void setParentFrame(GUIMain p) {
    mainFrame = p;
  }

  private class Listener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == bearbeiten) {
        //System.out.println("bearbeiten");
        mainFrame.setContent(new DVeranstaltungbearbeiten());
      }
      if (e.getSource() == gruppen) {
        //System.out.println("gruppen");
        mainFrame.setContent(new DGruppenbearbeiten());
      }
    }
  }
}