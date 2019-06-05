package GUI;

import javax.swing.*;

/**
 * Interface für GUI-Klassen, ermöglicht einfachen Wechsel von verschiedenen Ansichten.
 * @author Oleg
 */

public interface FrameContent {
    String getName();
    JPanel getPanel();
    void setParentFrame(GUIMain m);
}