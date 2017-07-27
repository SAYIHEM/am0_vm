package GUI.Views;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileChooser extends JFileChooser {

    public FileChooser(Component frame) {
        super();

        if (frame == null) throw new NullPointerException("Component were FileChooser is shown was NULL!");

        this.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = this.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            // user selects a file
        }
    }
}
