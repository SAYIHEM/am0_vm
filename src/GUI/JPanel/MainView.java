package GUI.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MainView extends JFrame {

    private JPanel panel;

    // Lists
    private JList listStack;
    private JList listProgram;
    private JList listEventOutput;

    // Buttons
    private JButton buttonLoadFile;
    private JButton buttonRun;
    private JButton buttonTerminate;
    private JButton buttonSetBreakpoint;
    private JButton buttonBreak;
    private JButton buttonMakeStep;

    // Listener
    private ComponentListener listenerFrame;

    int initialWidth = 766;
    int initialHeight = 635;

    public MainView(int width, int height) {
        super();

        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Set size of window
        setSize(766, 635);



        init();
    }

    private void onResize() {


    }

    private void init() {

        // Init
        this.panel = new JPanel();
        panel.setSize(766, 635);



        // Init ListViews
        this.listStack = new JList();
        this.listProgram = new JList();
        this.listEventOutput = new JList();

        // Init Buttons
        this.buttonLoadFile = new JButton();
        this.buttonRun = new JButton();
        this.buttonTerminate = new JButton();
        this.buttonSetBreakpoint = new JButton();
        this.buttonBreak = new JButton();
        this.buttonMakeStep = new JButton();


        // Set ListBox positions
        this.listStack.setBounds(13, 13, 345,460);
        this.listProgram.setBounds(363,41, 375, 316);
        this.listEventOutput.setBounds(13, 478, 726, 108);

        // Set Button position
        this.buttonLoadFile.setBounds(363, 12, 373, 23);
        this.buttonRun.setBounds(365, 363, 119, 46);
        this.buttonTerminate.setBounds(615, 363, 119, 46);
        this.buttonSetBreakpoint.setBounds(371, 430, 75, 23);
        this.buttonBreak.setBounds(581, 429, 75, 23);
        this.buttonMakeStep.setBounds(659, 429, 75, 23);

        // Init Listeners
        initListeners();


        // Add Buttons to Panel
        this.panel.add(listStack);
        this.panel.add(listProgram);
        this.panel.add(listEventOutput);
        this.panel.add(buttonLoadFile);
        this.panel.add(buttonRun);
        this.panel.add(buttonTerminate);
        this.panel.add(buttonSetBreakpoint);
        this.panel.add(buttonBreak);
        this.panel.add(buttonMakeStep);


        //JFrame layout
        this.setLayout(null);

        //JPanel layout
        panel.setLayout(null);

        // Add Panel to Frame
        this.add(panel);


        setVisible(true);

        revalidate();
        repaint();
    }

    private void initListeners() {

        this.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent e) {




                double scaleX = getWidth() / initialWidth;
                double scalesY = getHeight() / initialHeight;

                initialWidth = getWidth();
                initialHeight = getHeight();

                System.out.println("Yau");

                listStack.setBounds();

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
        });
    }



}
