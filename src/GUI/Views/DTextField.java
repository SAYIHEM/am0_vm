package GUI.Views;

import GUI.Resizeable;
import GUI.Views.Lists.CellRenderer.Highlightable;

import javax.swing.*;
import java.awt.*;

public class DTextField extends JTextField implements Resizeable, Highlightable {



    @Override
    public void highlight(int index) {

    }

    @Override
    public void highlight(int index, Color fontColor) {

    }

    @Override
    public void lowlight(int index) {

    }

    @Override
    public void resize(double scaleX, double scaleY) {

        // Scale Component
        int X = this.getX();
        int Y = this.getY();
        int width = this.getWidth();
        int height = this.getHeight();

        this.setBounds((int)(X*scaleX), (int)(Y*scaleY), (int)(width*scaleX), (int)(height*scaleY));

        // Scale Font
        if((height*scaleY / 2.f) * getText().length() / 1.3 < getWidth())
            this.setFont(this.getFont().deriveFont((float)(height*scaleY / 1.7f)));
    }
}
