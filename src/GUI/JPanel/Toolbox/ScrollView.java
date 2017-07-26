package GUI.JPanel.Toolbox;

import GUI.JPanel.Resizeable;

import javax.swing.*;

public class ScrollView extends JList implements Resizeable, Scrollable {

    private JScrollPane scrollPane;

    public ScrollView() {

        scrollPane = new JScrollPane();
        scrollPane.setViewportView(this);
    }

    @Override
    public void resize(double scaleX, double scaleY) {

        int X = this.getX();
        int Y = this.getY();
        int width = this.getWidth();
        int height = this.getHeight();

        this.setBounds((int)(X*scaleX), (int)(Y*scaleY), (int)(width*scaleX), (int)(height*scaleY));
    }
}
