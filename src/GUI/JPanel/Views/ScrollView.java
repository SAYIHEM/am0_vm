package GUI.JPanel.Views;

import GUI.JPanel.Resizeable;

import javax.swing.*;
import java.awt.*;

public class ScrollView<T> extends JList<T> implements Resizeable, Scrollable {

    private JScrollPane scrollPane;

    public ScrollView() {
        super();

        scrollPane = new JScrollPane(this);
    }

    public ScrollView(ListModel<T> model) {
        super(model);

        scrollPane = new JScrollPane(this);
    }


    @Override
    public void resize(double scaleX, double scaleY) {

        int X = this.getX();
        int Y = this.getY();
        int width = this.getWidth();
        int height = this.getHeight();

        this.setBounds((int)(X*scaleX), (int)(Y*scaleY), (int)(width*scaleX), (int)(height*scaleY));
    }

    public Component getView() {

        return this.scrollPane;
    }
}
