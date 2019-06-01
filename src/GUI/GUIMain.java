package GUI;

import javax.swing.*;
import Controller.*;

public class GUIMain extends JFrame{

    private FrameContent content;
    private MainController controller;

    public GUIMain(int width, int height) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("GUIMain");
        this.setSize(width, height);
        setContent(new LoginSeite());
        this.setVisible(true);
    }
    
    public void setController(MainController c) {
    	controller = c;
    }
    
    public MainController getController() {
    	if(controller == null) {
    		return controller = new MainController(this);
    	}
        return controller;
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
