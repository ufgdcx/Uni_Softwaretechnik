/**@author Diana
 * Klasse erstellt und erweitert von Diana
 *
 * Fenster zum Einlesen der Gruppeninformationen (wie Datum, Uhrzeit, Einschreibefrist,...) in der Dozentenansicht
 */
package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DGruppenInformationen {
    private JButton ok = new JButton("OK");

    private JButton zurueck = new JButton("zurück");

    public DGruppenInformationen(int gruppenanzahl) {
        JFrame frame = new JFrame("Gruppeninformationen");
        for(int i = 1; i < gruppenanzahl; i++ ){
            JLabel g = new JLabel("Gruppe" );

            JLabel wochentagLabel = new JLabel("Wochentag");
            frame.add(wochentagLabel);
            JTextField wochentag = new JTextField();
            frame.add(wochentag);
            JLabel zeitLabel = new JLabel("Uhrzeit");
            frame.add(zeitLabel);
            JTextField zeit = new JTextField();
            frame.add(zeit);
            JLabel rhythmusLabel = new JLabel("Rhythmus");
            frame.add(rhythmusLabel);
            JTextField rhythmus = new JTextField();
            frame.add(rhythmus);
            JLabel fristLabel = new JLabel("Einschreibefrist");
            frame.add(fristLabel);
            JTextField frist = new JTextField();
            frame.add(frist);

        }
        frame.add(ok);
        frame.add(zurueck);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        zurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
