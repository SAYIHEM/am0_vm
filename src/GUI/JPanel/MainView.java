package GUI.JPanel;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    // Lists
    private JList listStack;
    private JList listProgram;
    private JList listEventOutput;

    // Buttons
    private Button buttonLoadFile;
    private Button buttonRun;
    private Button buttonTerminate;
    private Button buttonSetBreakpoint;
    private Button buttonBreak;
    private Button buttonMakeStep;


    public MainView(int width, int height) {

        // Set size of window
        setSize(width, height);


        init();
    }


    private void init() {

        // Init ListViews
        this.listStack = new JList();
        this.listProgram = new JList();
        this.listEventOutput = new JList();



    }


}
