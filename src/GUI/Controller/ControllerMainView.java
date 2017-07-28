package GUI.Controller;

import Constants.Colors;
import GUI.JPanel.MainView;
import GUI.Views.Lists.ScrollView;
import Tools.FileArrayProvider;
import VirtualMachines.AM1Machine;
import VirtualMachines.MachineState.AM1State;
import VirtualMachines.RuntimeMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerMainView {

    private MainView mainView;
    private AM1Machine runtimeMachine;

    // ListModels
    private ScrollView<String> listStack;
    private ScrollView<String> listProgram;
    private ScrollView<String> listOutput;

    private List<AM1State> machineStates;

    public ControllerMainView() {

        // Start MainView
        this.mainView = new MainView(500,500);

        // Set Listeners
        this.setListeners();

        this.runtimeMachine = new AM1Machine();
        this.machineStates = new ArrayList<>();

        // Get references of Lists
        this.listStack = this.mainView.listStack;
        this.listProgram = this.mainView.listProgram;
        this.listOutput = this.mainView.listOutput;

    }

    private void setListeners() {

        this.mainView.buttonLoadFile.addActionListener(new LoadFileListener());
        this.mainView.buttonRun.addActionListener(new RunListener());
        this.mainView.buttonTerminate.addActionListener(new TerminateListener());
        this.mainView.buttonSetBreakpoint.addActionListener(new SetBreakpointListener());
        this.mainView.buttonBreak.addActionListener(new BreakListener());
        this.mainView.buttonMakeStep.addActionListener(new MakeStepListener());
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
                    listProgram.clear();
                    int lineNumber = 1;
                    for (String line : program) {

                        if (!line.isEmpty()) {

                            line = String.format("%2d  %s", lineNumber, line);
                            listProgram.addElement(line);
                            lineNumber++;
                        }
                    }

                } catch (IOException e1) {

                    // Add new ErrorOutput
                    listOutput.addElement("Error while reading File!\n" + e1.getMessage());
                    listOutput.highlight(listOutput.getListSize()-1, Color.RED);
                }


            } else {

                // Add new ErrorOutput
                /*listOutput.addElement("Error while reading File!");*/
                /*listOutput.highlight(listOutput.getListSize()-1, Color.RED);*/
            }
        }
    }

    public class RunListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Performing Run in DebugMode
            if (mainView.inDebugMode()) {

                // EventOutput
                listOutput.addElement("Starting Program...");



            // Performing Run normal
            } else {

                // EventOutput
                listOutput.addElement("Starting Program in Debug Mode...");
                listOutput.highlight(listOutput.getListSize()-1);

                try {

                    // SetUp StartConfig and run program
                    runtimeMachine.setStartConfig("TTT"); // TODO: Set Start Config
                    runtimeMachine.run();

                } catch (Exception e1) {


                }

            }
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
