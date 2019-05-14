package GUI;

import javax.swing.*;


public class GUIMain extends JFrame {
	private FrameContent content;
	
	public GUIMain(int width, int height) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setTitle("GUIMain");       
	    this.setSize(width, height);
	    setContent(new DGruppenbearbeiten());
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
		this.revalidate();
		this.repaint();
	}

	
}
