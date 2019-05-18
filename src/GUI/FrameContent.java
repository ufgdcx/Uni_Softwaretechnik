package GUI;

import javax.swing.*;

public interface FrameContent {
    String getNachname();
    JPanel getPanel();
    void setParentFrame(GUIMain m);
}