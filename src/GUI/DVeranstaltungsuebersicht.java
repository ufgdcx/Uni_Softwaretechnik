package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class DVeranstaltungsuebersicht implements FrameContent{
  private String name = "Veranstaltungsübersicht";
  private GUIMain mainFrame;
  private Listener def = new Listener();

  private JPanel panel = new JPanel();
  private JPanel epanel = new JPanel();
  private JPanel spanel = new JPanel();

  private JButton ansehen = new JButton("Veranstaltung ansehen");

  private JLabel infos = new JLabel("Infos über Veranstaltung"); //Platzhalter für Veranstaltungsinfos aus DB


  String veranstaltungen[] = {"Softwaretechnik", "Betriebssysteme", "Verteilte Systeme"}; //Platzhalter für zugeordnete Veranstaltungen aus DB


  public DVeranstaltungsuebersicht() {

    JList<String> veranstaltungsAuswahl = new JList<String>(veranstaltungen);
    veranstaltungsAuswahl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
    //add(new JScrollPane(veranstaltungsAuswahl));

    panel.setLayout(new BorderLayout());
    epanel.setLayout(new GridLayout(3,1));
    spanel.setLayout(new BorderLayout());


    panel.add(veranstaltungsAuswahl, BorderLayout.CENTER);
    panel.add(epanel, BorderLayout.EAST);
    panel.add(spanel, BorderLayout.SOUTH);

    epanel.add(ansehen);


    spanel.add(infos,BorderLayout.CENTER);
    ansehen.addActionListener(def);

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
      if (e.getSource() == ansehen) {
        //System.out.println("ansehen");
        mainFrame.setContent(new DVeranstaltung());
      }
    }
  }
}
