package adminGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JButton confirmButton;

	JList<String> Dozenten;

	public ErrorDialog(String errormsg) {
		setTitle("                                     Fehler");
		setModal(true);
		setSize(300, 130);
		setLayout(null);
		
		JLabel errorLabel = new JLabel(errormsg,SwingConstants.CENTER);
		errorLabel.setBounds(0, 10, 275, 25);
		add(errorLabel);

		confirmButton = new JButton("OK");
		confirmButton.setFocusable(false);
		confirmButton.setBounds(85, 50, 100, 25);
		confirmButton.addActionListener(new Listener());
		add(confirmButton);
		
	}

private class Listener implements ActionListener{

		Listener(){
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==confirmButton) {
				dispose();
			}
		}
		
	}
}