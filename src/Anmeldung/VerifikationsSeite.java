package Anmeldung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerifikationsSeite {

    private JPanel VerifikationsPanel;
    private JLabel verifikationscodeLabel;
    private JLabel codeLabel;
    private JTextField code;
    private JButton abbrechenButton;
    private JButton codeErneutSendenButton;
    private JButton okButton;

    //Erzeugt Seite zum Verifizieren
    public static void erzeugeVerifizieren() {

        JFrame frame = new JFrame("Verifizieren");
        frame.setContentPane(new VerifikationsSeite().VerifikationsPanel);

        //Schließt das Fenster nach Klick auf das "x" rechts oben in der Ecke
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public VerifikationsSeite() {

        //Schließt das Fenster nach Klick auf "Abbrechen"
        abbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JComponent component = (JComponent) e.getSource();
                Window window = SwingUtilities.getWindowAncestor(component);
                window.dispose();
            }
        });
    }

}
