package GUI.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MainView extends JFrame implements ComponentListener {

    private JPanel panel;

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

    int initialWidth = 766;
    int initialHeight = 635;

    public MainView(int width, int height) {
        super();

        // Set size of window
        setSize(766, 635);


        init();
    }

    private void onResize() {


    }

    private void init() {

        // Init
        this.panel = new JPanel();

        // Init ListViews
        this.listStack = new JList();
        this.listProgram = new JList();
        this.listEventOutput = new JList();

        // Init Buttons
        this.buttonLoadFile = new Button();
        this.buttonRun = new Button();
        this.buttonTerminate = new Button();
        this.buttonSetBreakpoint = new Button();
        this.buttonBreak = new Button();
        this.buttonMakeStep = new Button();


        // Set ListBox positions
        this.listStack.setBounds(13, 13, 345,460);
        this.listProgram.setBounds(363,41, 375, 316);
        this.listEventOutput.setBounds(13, 378, 726, 108);

        // Set Button position
        this.buttonLoadFile.setBounds(363, 12, 373, 23);
        this.buttonRun.setBounds(365, 363, 119, 46);
        this.buttonTerminate.setBounds(615, 363, 119, 46);
        this.buttonSetBreakpoint.setBounds(371, 430, 75, 23);
        this.buttonBreak.setBounds(581, 429, 75, 23);
        this.buttonMakeStep.setBounds(659, 429, 75, 23);

        this.panel.add(listStack);
        this.panel.add(listProgram);
        this.panel.add(listEventOutput);
        this.panel.add(buttonLoadFile);
        this.panel.add(buttonRun);
        this.panel.add(buttonTerminate);
        this.panel.add(buttonSetBreakpoint);
        this.panel.add(buttonBreak);
        this.panel.add(buttonMakeStep);

        this.add(panel);

        setLocationByPlatform(true);
        setVisible(true);

        revalidate();
        repaint();
    }


    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
