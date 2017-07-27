package GUI.Views;

import GUI.Resizeable;

import javax.swing.*;

public class ListView<T> extends JList<T> implements Resizeable {

    public ListView() {
        super();
    }

    public ListView(ListModel<T> model) {
        super(model);
    }

    @Override
    public void resize(double scaleX, double scaleY) {

        // Scale Component
        int X = this.getX();
        int Y = this.getY();
        int width = this.getWidth();
        int height = this.getHeight();

        this.setBounds((int)(X*scaleX), (int)(Y*scaleY), (int)(width*scaleX), (int)(height*scaleY));

        // Scale Font // TODO: Scale Font in ListView
        /*try {

            int textMaxLenght = 0;

            for (int i = 0; i < this.getModel().getSize(); i++) {

                String actualElement = (String)(this.getModel().getElementAt(i));
                if (textMaxLenght < actualElement.length()) textMaxLenght = actualElement.length();
            }

            if((height*scaleY / 2.f) * textMaxLenght / 1.3 < getWidth())
            this.setFont(this.getFont().deriveFont((float)(height*scaleY / 1.7f)));

        } catch (ClassCastException e) { }*/


    }
}
