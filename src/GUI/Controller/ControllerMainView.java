package GUI.Controller;

import Constants.Colors;
import Exceptions.IllegalMachineStateException;
import Exceptions.InvalidStartConfigException;
import GUI.JPanel.MainView;
import GUI.Views.Lists.ScrollView;
import Tools.FileArrayProvider;
import VirtualMachines.AM1Machine;
import VirtualMachines.MachineState.AM1State;

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

    // Machine States for DebugMode
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

        // SetUp EventOutput
        EventOutput.setEventView(this.listOutput);
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

            // TODO: Check for .AM0 / .AM1 ending of File!

            if (result == JFileChooser.APPROVE_OPTION) {

                File selectedFile = fileChooser.getSelectedFile();

                // Convert File to String[]
                String[] program = new String[0];
                try {

                    program = FileArrayProvider.readLines(selectedFile.getAbsolutePath());

                } catch (IOException e1) {

                    // Add new ErrorOutput
                    EventOutput.add("Error while reading File!\n" + e1.getMessage(), Colors.RED);
                }

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
            }
        }
    }

    public class RunListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Check for program was load
            if (listProgram.getIndexLastElement() < 0) {

                // ErrorOutput
                EventOutput.add("No Program was loaded!", Colors.RED);
                return;
            }

            // Clear StackList
            listStack.clear();

            // Performing Run in DebugMode
            if (mainView.inDebugMode()) {

                // SetUp StartConfig and prepare
                AM1State initialState;
                try {

                    runtimeMachine.setStartConfig(mainView.textFieldStartConfig.getText());
                    initialState = runtimeMachine.prepare();

                } catch (InvalidStartConfigException | IllegalMachineStateException e1) {

                    // ErrorOutput
                    EventOutput.add(e1.getMessage(), Colors.RED);
                    return;
                }

                // Add initial State to MachineStates
                machineStates.add(initialState);

                // Highlight EntryPoint in ProgramList
                listProgram.highlight(runtimeMachine.getCommandValue()-1);

                // Set StackOutput
                for (String line : runtimeMachine.getOutput()) {

                    listStack.addElement(line);
                }

                // EventOutput
                EventOutput.add("Starting Program in Debug Mode...", Colors.ORANGE_LIGHT);



            // Performing Run normal
            } else {

                // SetUp StartConfig
                try {

                    runtimeMachine.setStartConfig(mainView.textFieldStartConfig.getText());

                } catch (InvalidStartConfigException e1) {

                    // ErrorOutput
                    EventOutput.add(e1.getMessage(), Colors.RED);
                    return;
                }

                // EventOutput
                EventOutput.add("Starting Program...");

                // Start machine
                runtimeMachine.run();

                // Set StackOutput TODO: create stack table!
                for (String line : runtimeMachine.getOutput()) {

                    listStack.addElement(line);
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
            listProgram.highlight(runtimeMachine.getCommandValue()-1);

            // Set StackOutput
            for (String line : runtimeMachine.getOutput()) {

                listStack.addElement(line);
            }
        }
    }

}
