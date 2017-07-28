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

            // Clear StackList
            listStack.clear();

            // Performing Run in DebugMode
            if (mainView.inDebugMode()) {

                // EventOutput
                listOutput.addElement("Starting Program in Debug Mode...");
                listOutput.highlight(listOutput.getListSize()-1, Color.orange);

                try {

                    // SetUp StartConfig and prepare
                    runtimeMachine.setStartConfig(mainView.textFieldStartConfig.getText());
                    AM1State initialState = runtimeMachine.prepare();
                    machineStates.add(initialState);

                    // Highlight EntryPoint in ProgramList
                    listProgram.highlight(runtimeMachine.getCommandValue()-1);


                } catch (Exception e1) {

                    // Add new ErrorOutput
                    listOutput.addElement(e1.getMessage());
                    listOutput.highlight(listOutput.getListSize()-1, Color.RED);
                }

                // Set StackOutput
                for (String line : runtimeMachine.getOutput()) {

                    listStack.addElement(line);
                }


            // Performing Run normal
            } else {

                // EventOutput
                listOutput.addElement("Starting Program...");

                try {

                    // SetUp StartConfig and Start Program
                    runtimeMachine.setStartConfig(mainView.textFieldStartConfig.getText());
                    runtimeMachine.run();

                    // Set StackOutput TODO: create stack table!
                    for (String line : runtimeMachine.getOutput()) {

                        listStack.addElement(line);
                    }

                } catch (Exception e1) {

                    // Add new ErrorOutput
                    listOutput.addElement(e1.getMessage());
                    listOutput.highlight(listOutput.getListSize()-1, Color.RED);
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

            // Lowlight Line in ProgramList
            listProgram.lowlight(machineStates.get(machineStates.size()-1).getCommandPointer().getValue()-1);

            // Make Step and safe to StateList
            AM1State newState = runtimeMachine.StepForward();
            machineStates.add(newState);

            // Highlight Line in ProgramModel
            listProgram.highlight(runtimeMachine.getCommandValue());

            // Set StackOutput
            for (String line : runtimeMachine.getOutput()) {

                listStack.addElement(line);
            }
        }
    }

}
