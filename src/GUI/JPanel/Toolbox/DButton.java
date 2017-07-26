package GUI.JPanel.Toolbox;

import GUI.JPanel.Resizeable;

import javax.swing.*;

public class DButton extends JButton implements Resizeable {

    public DButton() {
        super();
    }

    @Override
    public void resize(double scaleX, double scaleY) {

        int X = this.getX();
        int Y = this.getY();
        int width = this.getWidth();
        int height = this.getHeight();

        this.setBounds((int)(X*scaleX), (int)(Y*scaleY), (int)(width*scaleX), (int)(height*scaleY));
        if((height*scaleY / 2.f) * getText().length() / 1.3 < getWidth())
            this.setFont(this.getFont().deriveFont((float)(height*scaleY / 1.7f)));
    }
}
