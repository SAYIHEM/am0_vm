package GUI.Controller;

import javax.swing.*;

public abstract class StackOutput extends Output {

    private StackOutput() {}

    public static void removeLastLine() {

        ((DefaultListModel<String>) view.getModel()).remove(view.getModel().getSize() - 1);
    }
}
