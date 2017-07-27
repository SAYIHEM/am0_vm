package GUI.Controller;

import Constants.Colors;
import GUI.JPanel.MainView;
import Tools.FileArrayProvider;
import VirtualMachines.AM1Machine;
import VirtualMachines.RuntimeMachine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ControllerMainView {

    private MainView mainView;
    private AM1Machine runtimeMachine;

    // ListModels
    private DefaultListModel<String> modelStack;
    private DefaultListModel<String> modelProgram;
    private DefaultListModel<String> modelOutput;

    public ControllerMainView() {

        // Start MainView
        this.mainView = new MainView(500,500);
        this.mainView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainView.setVisible(true);

        // Set Listeners
        this.setListeners();

        // Create ListModels and add them to Lists
        this.setUpListModels();

        this.runtimeMachine = new AM1Machine();
    }

    private void setListeners() {

        this.mainView.buttonLoadFile.addActionListener(new LoadFileListener());
        this.mainView.buttonRun.addActionListener(new RunListener());
        this.mainView.buttonTerminate.addActionListener(new TerminateListener());
        this.mainView.buttonSetBreakpoint.addActionListener(new SetBreakpointListener());
        this.mainView.buttonBreak.addActionListener(new BreakListener());
        this.mainView.buttonMakeStep.addActionListener(new MakeStepListener());
    }

    private void setUpListModels() {

        this.modelStack = new DefaultListModel<>();
        this.modelProgram = new DefaultListModel<>();
        this.modelOutput = new DefaultListModel<>();

        this.mainView.listStack.setModel(modelStack);
        this.mainView.listProgram.setModel(modelProgram);
        this.mainView.listEventOutput.setModel(modelOutput);
    }


    public class LoadFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Open FileChooser
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(mainView);


            if (result == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooser.getSelectedFile();

                try {

                    // Convert File to String[]
                    String[] program = FileArrayProvider.readLines(selectedFile.getAbsolutePath());

                    // Add Program to AM1-machine
                    runtimeMachine.setProgram(program);

                    // Show Program in Program-ScrollView
                    modelProgram.clear();
                    int lineNumber = 1;
                    for (String line : program) {

                        if (!line.isEmpty()) {

                            line = String.format("%2d  %s", lineNumber, line);
                            modelProgram.addElement(line);
                            lineNumber++;
                        }
                    }

                } catch (IOException e1) {

                    // Add new ErrorOutput
                    modelOutput.addElement(Colors.RED + "Error while reading File!\n" + e1.getMessage() + Colors.RESET);

                }


            } else {

                // Add new ErrorOutput
                modelOutput.addElement(Colors.RED + "Error while reading File!" + Colors.RESET);
            }
        }
    }

    public class RunListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

    public class TerminateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

    public class SetBreakpointListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

    public class BreakListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

    public class MakeStepListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Highlight Line in ProgramModel

        }
    }

}
