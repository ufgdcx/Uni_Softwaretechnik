package GUI;

import javax.swing.*;

/**
 * Interface für GUI-Klassen, ermoeglicht einfachen Wechsel von verschiedenen Ansichten.
 * @author Oleg
 */

public interface FrameContent {
    String getName();
    JPanel getPanel();
    void setParentFrame(GUIMain m);
}