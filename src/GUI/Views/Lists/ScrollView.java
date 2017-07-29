package GUI.Views.Lists;

import GUI.Resizeable;
import GUI.Views.Lists.CellRenderer.Highlightable;

import javax.swing.*;
import java.awt.*;

public class ScrollView<T> extends JScrollPane implements Resizeable, Highlightable {

    public ListView<T> listView;

    public ScrollView() {
        super(new ListView<>());

        this.listView = (this.getViewport().getView() instanceof ListView) ? (ListView) this.getViewport().getView() : null;

        // Exceptions
        if (this.listView == null) throw new NullPointerException("Error in creating Scrollview, could not get ListView!");

        init();
    }

    public ScrollView(ListModel<T> model) {
        super(new ListView<>(model));

        // Exceptions
        if (model == null) throw new NullPointerException("Model in constructor was NULL!");

        this.listView = (this.getViewport().getView() instanceof ListView) ? (ListView) this.getViewport().getView() : null;

        // Exceptions
        if (this.listView == null) throw new NullPointerException("Error in creating Scrollview, could not get ListView!");

        init();
    }

    public void init() {

    }

    public void setCellRenderer(DefaultListCellRenderer renderer) {

        if (renderer == null) throw new NullPointerException("Renderer to set was NULL!");

        this.listView.setCellRenderer(renderer);
    }

    public DefaultListCellRenderer getCellRenderer() {

        return (DefaultListCellRenderer) this.listView.getCellRenderer();
    }

    public void setSelectionMode(DefaultListSelectionModel selectionMode) {

        if (selectionMode == null) throw new NullPointerException("SelectionMode to set was NULL!");

        this.listView.setSelectionModel(selectionMode);
    }

    public DefaultListSelectionModel getSelectionMode() {

        return (DefaultListSelectionModel) this.listView.getSelectionModel();
    }

    public void addElement(T element) {

        if (element == null) throw new NullPointerException("Element to add was NULL!");

        ((DefaultListModel<T>)this.listView.getModel()).addElement(element);
    }

    public void clear() {

        if (this.getModel() instanceof DefaultListModel) ((DefaultListModel) this.getModel()).clear();
    }

    public int getIndexLastElement() {

        return this.getModel().getSize() - 1;
    }

    public ListModel<T> getModel() {

        return this.listView.getModel();
    }

    public void setModel(ListModel<T> model) {

        // Exceptions
        if (model == null) throw new NullPointerException("Model to set was NULL!");

        this.listView.setModel(model);
    }

    @Override
    public void resize(double scaleX, double scaleY) {

        int X = this.getX();
        int Y = this.getY();
        int width = this.getWidth();
        int height = this.getHeight();

        this.setBounds((int)(X*scaleX), (int)(Y*scaleY), (int)(width*scaleX), (int)(height*scaleY));

        this.listView.resize(scaleX, scaleY);
    }

    public void setFontList(Font font) {

        if (font == null) throw new NullPointerException("Font to set was NULL!");

        this.listView.setFont(font);
    }

    public Font getFontList() {

        if (this.listView == null) return super.getFont();

        return this.listView.getFont();
    }

    @Override
    public void highlight(int index) {

        if (this.listView.getCellRenderer() instanceof Highlightable)
            ((Highlightable) this.listView.getCellRenderer()).highlight(index);

        updateUI();
    }

    @Override
    public void highlight(int index, Color color) {

        if (this.listView.getCellRenderer() instanceof Highlightable)
            ((Highlightable) this.listView.getCellRenderer()).highlight(index, color);

        updateUI();
    }

    @Override
    public void lowlight(int index) {

        if (this.listView.getCellRenderer() instanceof Highlightable)
            ((Highlightable) this.listView.getCellRenderer()).lowlight(index);

        updateUI();
    }
}
