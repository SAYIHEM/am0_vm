package GUI.Views;

import GUI.Resizeable;

import javax.swing.*;

public class ScrollView<T> extends JScrollPane implements Resizeable {

    private ListView<T> listView;

    public ScrollView() {
        super(new ListView<>());

        this.listView = (this.getViewport().getView() instanceof ListView) ? (ListView<T>) this.getViewport().getView() : null;

        // Exceptions
        if (this.listView == null) throw new NullPointerException("Error in creating Scrollview, could not get ListView!");
    }

    public ScrollView(ListModel<T> model) {
        super(new ListView<>(model));

        // Exceptions
        if (model == null) throw new NullPointerException("Model in constructor was NULL!");

        this.listView = (this.getViewport().getView() instanceof ListView) ? (ListView<T>) this.getViewport().getView() : null;

        // Exceptions
        if (this.listView == null) throw new NullPointerException("Error in creating Scrollview, could not get ListView!");
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
}
