package GUI.Views.Lists.CellRenderer;

import Constants.Colors;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RenderOutputList extends DefaultListCellRenderer implements Highlightable {

    private Map<Integer, Color> highlightedRows = new HashMap<>();

    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        component.setForeground(this.highlightedRows.getOrDefault(index, Colors.BLACK));

        return component;
    }

    @Override
    public void highlight(int index) {

        // Remove old value if existing
        if (this.highlightedRows.containsKey(index)) this.highlightedRows.remove(index);

        this.highlightedRows.put(index, Color.gray);
    }

    @Override
    public void highlight(int index, Color backgroundColor) {

        if (backgroundColor == null) throw new NullPointerException("Color to highlight row was NULL!");

        // Remove old value if existing
        if (this.highlightedRows.containsKey(index)) this.highlightedRows.remove(index);

        this.highlightedRows.put(index, backgroundColor);
    }

    @Override
    public void lowlight(int index) {

        this.highlightedRows.remove(index);
    }


}
