package GUI;

import javax.swing.*;

public interface FrameContent {
    String getName();
    JPanel getPanel();
    void setParentFrame(GUIMain m);
}