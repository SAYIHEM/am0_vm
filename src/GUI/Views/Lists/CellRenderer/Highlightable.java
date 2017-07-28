package GUI.Views.Lists.CellRenderer;

import java.awt.*;

public interface Highlightable {

    void highlight(int index);
    void highlight(int index, Color fontColor);
    void lowlight(int index);
}
