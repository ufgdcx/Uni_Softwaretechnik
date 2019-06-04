package adminGui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
	
public class AdminFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	JList<String> veranstaltungen;
		
	public AdminFrame() {
		BufferedImage myImage;
		setLayout(new FlowLayout());
		try {
			myImage = ImageIO.read(new File("src\\adminGui\\testbild.jpg"));
			setContentPane(new ImagePanel(myImage));
		} catch (IOException er) {
			try {
				myImage = ImageIO.read(new File("src/adminGui/testbild.jpg"));
				setContentPane(new ImagePanel(myImage));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		setLayout(new GridBagLayout());
		setMinimumSize(new Dimension(417, 439));
		setSize(417,439);


		add(new AdminPanel());
	}
}
	

