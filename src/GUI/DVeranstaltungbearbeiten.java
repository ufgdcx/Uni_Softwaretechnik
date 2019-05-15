package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class DVeranstaltungbearbeiten implements FrameContent {
  private String name = "Veranstaltung bearbeiten";
  private GUIMain mainFrame;
  private JPanel panel = new JPanel();
  private JPanel epanel = new JPanel();
  private JPanel cpanel = new JPanel();

  private JButton bestaetigen = new JButton("Änderungen bestätigen");
  private JButton abbrechen = new JButton("abbrechen");

  private JTextArea dozent = new JTextArea("Dozent der Veranstaltung"); //Platzhalter für verantwortlichen Dozenten aus DB
  private JTextArea infos = new JTextArea("Infos über Veranstaltung"); //Platzhalter für Veranstaltungsinfos aus DB

  private Listener def = new Listener();

  String veranstaltungen[] = {"Softwaretechnik", "Betriebssysteme", "Verteilte Systeme"}; //Platzhalter für eingeschriebene Veranstaltungen aus DB


  public DVeranstaltungbearbeiten() {
    panel.setLayout(new BorderLayout());
    epanel.setLayout(new GridLayout(2, 1));
    cpanel.setLayout(new GridLayout(2, 1));


    panel.add(cpanel, BorderLayout.CENTER);
    panel.add(epanel, BorderLayout.EAST);

    epanel.add(bestaetigen);
    epanel.add(abbrechen);

    cpanel.add(infos);
    cpanel.add(dozent);

    bestaetigen.addActionListener(def);
    abbrechen.addActionListener(def);
    //infos.addActionListener(def);
    //dozent.addActionListener(def);
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
      if (e.getSource() == bestaetigen) {
        System.out.println("bestaetigen");
        mainFrame.setContent(new DVeranstaltung());
      }
      if (e.getSource() == abbrechen) {
        System.out.println("abbrechen");
        mainFrame.setContent(new DVeranstaltung());
      }
      if (e.getSource() == infos) {
        //System.out.println("infos");

      }
      if (e.getSource() == dozent) {
        //System.out.println("dozent");

      }
    }
  }
}