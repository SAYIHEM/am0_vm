package VirtualMachines;

import Constants.ArgPatterns;
import Constants.Colors;
import Exceptions.HeapException;
import Exceptions.IllegalMachineStateException;
import Exceptions.InvalidStartConfigException;
import GUI.Controller.Callbacks.Callback;
import GUI.Controller.Callbacks.TerminationCaller;
import GUI.Controller.EventOutput;
import GUI.Controller.StackOutput;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.AM1Heap;
import Hardware.Stacks.AM1Stack;
import Hardware.Pointer;
import Hardware.Stacks.Stack;
import InstructionSets.AM1Instructions;
import Interpreters.AM1Interpreter;
import Interpreters.Interpreter;
import OutputHandler.AM1Output;
import OutputHandler.Displayable;
import OutputHandler.OutputHandler;
import VirtualMachines.MachineState.AM1State;

import java.util.ArrayList;
import java.util.List;

public class AM1Machine extends RuntimeMachine implements TerminationCaller {

    private CommandPointer commandPointer;
    private AM1Stack runtimeStack;
    private AM1Heap runtimeHeap;
    private Pointer reference;
    private Stack inputList;
    private Stack outputList;
    private String startConfig;
    private String[] program;
    private boolean configSet = false;

    private Interpreter interpreter = null;

    // Reference for MachineTermination Callback
    private Callback callback;


    public AM1Machine() {

        init();
    }

    public AM1Machine(String[] program) {

        this.program = program;

        init();
        run(program);
    }

    private void init() {

        // Create new Machine Components
        commandPointer = new CommandPointer();
        runtimeStack = new AM1Stack();
        runtimeHeap = new AM1Heap();
        reference = new Pointer();
        inputList = new Stack();
        outputList = new Stack();

        // Set up List for console output
        List<Displayable> devices = new ArrayList<>();
        devices.add(commandPointer);
        devices.add(runtimeStack);
        devices.add(runtimeHeap);
        devices.add(reference);
        devices.add(inputList);
        devices.add(outputList);
        output = new AM1Output(devices);
    }

    public void run() {

        run(this.program);
    }

    @Override
    public void run(String[] program) {

        try {

            this.prepare();

        } catch (IllegalMachineStateException e) {

            // ErrorOutput
            EventOutput.add(e.getMessage(), Colors.RED);
        }

        while (commandPointer.getValue() > 0 && commandPointer.getValue() < program.length) {

            // Write stack output
            StackOutput.add(this.getOutput());

            this.interpreter.execute(program[commandPointer.getValue()]);
        }

        // EventOutput
        EventOutput.add("Program terminated.");

        // Call controller machine termination
        this.doCall();

        // Reset machine
        reset();
    }


    public AM1State StepForward() {

        if (commandPointer.getValue() > 0 && commandPointer.getValue() < program.length) {

            // Write output
            //this.output.add(String.format("%2s: %s", commandPointer.getValue(), program[commandPointer.getValue()]));

            interpreter.execute(program[commandPointer.getValue()]);

        } else {

            // EventOutput
            EventOutput.add("Program terminated.");

            // Call controller machine termination
            this.doCall();

            // Reset machine
            reset();
        }

        return getMachineState();
    }

    public void StepBackward(AM1State machineState) {

        if (machineState == null) throw new NullPointerException("State to step backward was NULL!");

        this.setMachineState(machineState);
    }

    public void setStartConfig(String startConfig) throws InvalidStartConfigException {

        if (startConfig == null) throw new NullPointerException("StartConfig was NULL!");

        // Test for correct input
        startConfig = startConfig.replace(" ", "");
        if (!startConfig.matches(ArgPatterns.AM1_INPUT))
            throw new InvalidStartConfigException("Invalid StartConfig, please check input!");

        this.startConfig = startConfig;
        this.configSet = true;
    }

    public AM1State prepare() throws IllegalMachineStateException {

        // Exceptions: Check for correct SetUp
        if (program == null) throw new IllegalMachineStateException("Program to execute was not set!");
        if (!configSet) throw new IllegalMachineStateException("StartConfig is not set!");

        this.startConfig = this.startConfig.replace("(", "");
        this.startConfig = this.startConfig.replace(")", "");

        String[] configArray = this.startConfig.split(",");

        // Set commandPointer
        this.commandPointer.setValue(Integer.parseInt(configArray[0]));

        // SetUp Stack
        String[] stack = configArray[1].split(":");
        if (!stack[0].equals("-")) {

            for (int i = stack.length - 1; i >= 0; i--) {

                this.runtimeStack.push(Integer.parseInt(stack[i]));
            }
        }

        // SetUp Heap
        String[] heap = configArray[2].split(":");
        if (!heap[0].equals("-")) {

            int address = 1;
            for (int i = heap.length - 1; i >= 0; i--) {

                try {

                    this.runtimeHeap.store(address, Integer.parseInt(heap[i]));

                } catch (HeapException e) {

                    // Error Output
                    EventOutput.add(e.getMessage(), Colors.RED);
                }

                address++;
            }
        }

        // Set Ref-pointer
        this.reference.setValue(Integer.parseInt(configArray[3]));

        // Set Input List
        String[] input = configArray[4].split(":");
        if (!input[0].equals("-")) {

            for (int i = input.length - 1; i >= 0; i--) {

                this.inputList.push(Integer.parseInt(input[i]));
            }
        }

        // Set Input List
        String[] output = configArray[5].split(":");
        if (!output[0].equals("-")) {

            for (int i = output.length - 1; i >= 0; i--) {

                this.outputList.push(Integer.parseInt(output[i]));
            }
        }

        // Initialize Interpreter
        this.interpreter = new AM1Interpreter(new AM1Instructions(runtimeHeap, runtimeStack, commandPointer, reference, inputList, outputList));

        // Return initial State
        return this.getMachineState();
    }

    public void setProgram(String[] program) {

        if (program == null) throw new NullPointerException("Program to set was NULL!");

        this.program = program;
    }

    public int getCommandValue() {

        return this.commandPointer.getValue();
    }

    private void reset() {

        init();
        this.startConfig = null;
        this.configSet = false;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getter & Setter for Machine State
    ///////////////////////////////////////////////////////////////////////////
    private AM1State getMachineState() {

        return new AM1State(commandPointer, runtimeStack, runtimeHeap, reference);
    }

    private void setMachineState(AM1State state) {

        this.commandPointer = state.getCommandPointer();
        this.runtimeStack = state.getStack();
        this.runtimeHeap =  state.getHeap();
        this.reference = state.getReference();
    }


    @Override
    public void register(Callback callback) {

        if (callback == null) throw new NullPointerException("Callback to register was NULL!");

        this.callback = callback;

    }

    @Override
    public void doCall() {

        this.callback.call();
    }
}
