package adminGui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main{
	public static void main(String[] args) {
		AdminFrame adminframe = new AdminFrame();
		adminframe.setLocationRelativeTo(null);
		adminframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminframe.setVisible(true);
		
		
	}
}