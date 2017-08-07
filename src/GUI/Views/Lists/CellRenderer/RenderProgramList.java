package GUI.Views.Lists.CellRenderer;

import Constants.Colors;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RenderProgramList extends DefaultListCellRenderer implements Highlightable {

    private Map<Integer, Color> highlightedRows = new HashMap<>();

    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        component.setBackground(this.highlightedRows.getOrDefault(index, Colors.WHITE));

        return component;
    }

    @Override
    public void highlight(int index) {

        // Remove old value if existing
        if (this.highlightedRows.containsKey(index)) this.highlightedRows.remove(index);

        this.highlightedRows.put(index, Color.gray);
        updateUI();
    }

    @Override
    public void highlight(int index, Color backgroundColor) {

        if (backgroundColor == null) throw new NullPointerException("Color to highlight row was NULL!");

        // Remove old value if existing
        if (this.highlightedRows.containsKey(index)) this.highlightedRows.remove(index);

        this.highlightedRows.put(index, backgroundColor);
        updateUI();
    }

    @Override
    public void lowlight(int index) {

        this.highlightedRows.remove(index);
        updateUI();
    }


}
