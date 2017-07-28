package GUI.JPanel;

import GUI.Resizeable;
import GUI.Views.DButton;
import GUI.Views.DCheckBox;
import GUI.Views.DTextField;
import GUI.Views.Lists.CellRenderer.RenderOutputList;
import GUI.Views.Lists.CellRenderer.RenderProgramList;
import GUI.Views.Lists.DisabledItemSelectionModel;
import GUI.Views.Lists.ScrollView;
import Tools.FontManager;
import Constants.Symbols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;

public class MainView extends JFrame {

    private JPanel panel;

    // Lists
    public ScrollView<String> listStack;
    public ScrollView<String> listProgram;
    public ScrollView<String> listOutput;

    // Buttons
    public DButton buttonLoadFile;
    public DButton buttonRun;
    public DButton buttonTerminate;
    public DButton buttonSetBreakpoint;
    public DButton buttonBreak;
    public DButton buttonMakeStep;

    // CheckBoxes
    private DCheckBox checkDebugMode;

    // TextFields
    public DTextField textFieldStartConfig;

    // FontManager
    FontManager fontManager = new FontManager();

    private List<Component> componentList = new ArrayList<>();

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


        init();
        resize();
    }


    private void scaleElement(Component element, double scaleX, double scaleY) {

        int X = element.getX();
        int Y = element.getY();
        int width = element.getWidth();
        int height = element.getHeight();

        element.setBounds((int)(X*scaleX), (int)(Y*scaleY), (int)(width*scaleX), (int)(height*scaleY));

    }


    private void resize() {

        // Set ListBox positions
        this.listStack.setBounds(10, 10, 345,460);
        this.listProgram.setBounds(360,40, 200, 430);
        this.listOutput.setBounds(10, 475, 726, 108);

        // Set Button position
        this.buttonLoadFile.setBounds(360,10, 200, 25);
        this.buttonRun.setBounds(565, 40, 200, 45);
        this.buttonTerminate.setBounds(565, 115, 200, 45);
        this.buttonSetBreakpoint.setBounds(371, 430, 75, 23);
        this.buttonBreak.setBounds(581, 429, 75, 23);
        this.buttonMakeStep.setBounds(659, 429, 75, 23);

        // Set CheckBox position
        this.checkDebugMode.setBounds(565, 85, 200, 20);

        // Set TextField position
        this.textFieldStartConfig.setBounds(565, 10, 200, 25);

/*        // Set ListBox positions
        this.listStack.setBounds(13, 13, 345,460);
        this.listProgram.setBounds(363,41, 375, 316);
        this.listOutput.setBounds(13, 478, 726, 108);

        // Set Button position
        this.buttonLoadFile.setBounds(363, 12, 373, 23);
        this.buttonRun.setBounds(365, 363, 119, 46);
        this.buttonTerminate.setBounds(584, 363, 150, 46);
        this.buttonSetBreakpoint.setBounds(371, 430, 75, 23);
        this.buttonBreak.setBounds(581, 429, 75, 23);
        this.buttonMakeStep.setBounds(659, 429, 75, 23);*/
    }



    private void init() {

        // Set size of window
        setSize(766, 635);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Init
        this.panel = new JPanel();
        this.panel.setSize(1920, 1080);


        // Init ListViews
        this.listStack = new ScrollView<>(new DefaultListModel<>());
        listStack.setCellRenderer(new DefaultListCellRenderer()); // TODO Create renderer for Table!
        listStack.setSelectionMode(new DisabledItemSelectionModel());
        listStack.setFontList(listStack.getFontList().deriveFont((float)11));

        this.listProgram = new ScrollView<>(new DefaultListModel<>());
        listProgram.setCellRenderer(new RenderProgramList());
        listProgram.setSelectionMode(new DisabledItemSelectionModel());
        listProgram.setFontList(listProgram.getFontList().deriveFont((float)14));

        this.listOutput = new ScrollView<>(new DefaultListModel<>());
        listOutput.setCellRenderer(new RenderOutputList());
        listOutput.setSelectionMode(new DisabledItemSelectionModel());
        listOutput.setFontList(listOutput.getFontList().deriveFont((float)11));



        // Init Buttons
        this.buttonLoadFile = new DButton();
        this.buttonLoadFile.setText("LOAD FILE");

        this.buttonRun = new DButton();
        this.buttonRun.setText("RUN");

        this.buttonTerminate = new DButton();
        this.buttonTerminate.setText("TERMINATE");

        this.buttonSetBreakpoint = new DButton();
        this.buttonSetBreakpoint.setText(Symbols.SET_BREAKPOINT);
        this.buttonSetBreakpoint.setFont(FontManager.UNICODE);

        this.buttonBreak = new DButton();
        this.buttonBreak.setText(Symbols.BREAK);
        this.buttonSetBreakpoint.setFont(FontManager.UNICODE);

        this.buttonMakeStep = new DButton();
        this.buttonMakeStep.setText("MAKE STEP");
        this.buttonMakeStep.setFont(FontManager.UNICODE);


        // Init CheckBoxes
        this.checkDebugMode = new DCheckBox();
        this.checkDebugMode.setText("Run in Debug Mode");


        // Init TextFields
        this.textFieldStartConfig = new DTextField();


        // Init Listeners
        initListeners();


        // Add Elements to Panel
        this.panel.add(listStack);
        this.panel.add(listProgram);
        this.panel.add(listOutput);
        this.panel.add(buttonLoadFile);
        this.panel.add(buttonRun);
        this.panel.add(buttonTerminate);
        this.panel.add(buttonSetBreakpoint);
        this.panel.add(buttonBreak);
        this.panel.add(buttonMakeStep);
        this.panel.add(checkDebugMode);
        this.panel.add(textFieldStartConfig);



        //JFrame layout
        this.setLayout(null);

        //JPanel layout
        panel.setLayout(null);

        // Add Panel to Frame
        this.add(panel);


        setVisible(true);

        createBufferStrategy(3);
        revalidate();
        repaint();
    }


    private double n = 0;
    private void initListeners() {

        this.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent e) {

                double width = getWidth();
                double height = getHeight();

                resize();


                double scaleX = width/initialWidth;
                double scaleY = height/initialHeight;

                // Resize Elements
                for (Component element : panel.getComponents()) {

                    if (element instanceof Resizeable) {

                        Resizeable resizeableElement = (Resizeable) element;
                        resizeableElement.resize(scaleX, scaleY);
                    }
                }

                // Resize Panel
                panel.setSize((int)width, (int)height);

                revalidate();
                repaint();

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

    public boolean inDebugMode() {

        return this.checkDebugMode.isSelected();
    }

}
