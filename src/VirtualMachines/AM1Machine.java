package VirtualMachines;

import Constants.ArgPatterns;
import Constants.Colors;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.AM1Heap;
import Hardware.Stacks.AM1Stack;
import Hardware.Stacks.Pointer;
import InstructionSets.AM1Instructions;
import Interpreters.AM1Interpreter;
import Interpreters.Interpreter;
import OutputHandler.AM1ConsoleOutput;
import OutputHandler.Displayable;

import java.util.ArrayList;
import java.util.List;

public class AM1Machine extends RuntimeMachine {

    private CommandPointer commandPointer;
    private AM1Stack runtimeStack;
    private AM1Heap runtimeHeap;
    private Pointer reference;
    private String startConfig;
    private boolean configSet = false;

    // For console output
    private AM1ConsoleOutput consoleOutput;

    public AM1Machine() {

        init();
    }

    public AM1Machine(String[] program) {

        init();
        run(program);
    }

    private void init() {

        commandPointer = new CommandPointer();
        runtimeStack = new AM1Stack();
        runtimeHeap = new AM1Heap();
        reference = new Pointer();

        // Set up List for console output
        List<Displayable> devvices = new ArrayList<>();
        devvices.add(commandPointer);
        devvices.add(runtimeStack);
        devvices.add(runtimeHeap);
        devvices.add(reference);
        consoleOutput = new AM1ConsoleOutput(devvices);
    }

    @Override
    public void run(String[] program) {

        // Check if StartConfig is set
        if (!this.configSet) {

            System.out.println(Colors.RED + "Run failed: Missing Start-config!" + Colors.RESET);
            return;
        }

        // Console output
        System.out.println("Starting AM1-program with config: " + this.startConfig);

        // Interpret StartConfig
        interpretStartConfig();

        Interpreter interpreter = new AM1Interpreter(new AM1Instructions(runtimeHeap, runtimeStack, commandPointer, reference));

        while(commandPointer.getValue() > 0 && commandPointer.getValue() < program.length) {

            // Write output
            output += program[commandPointer.getValue()] + "\n";

            // TODO: Fix Console Output
            //System.out.printf("%2s: %s%20s", commandPointer.getValue(), program[commandPointer.getValue()], consoleOutput.getMachineState() + "\n"); // TODO: Implementation with 'Log.d'
            System.out.printf("%2s: %s", commandPointer.getValue(), program[commandPointer.getValue()] + "\n"); // TODO: Implementation with 'Log.d'


            interpreter.execute(program[commandPointer.getValue()]);
        }

        // Reset machine
        reset();

        System.out.println("Program terminated.");
    }

    public void setStartConfig(String startConfig) {

        if (startConfig == null) throw new NullPointerException("StartConfig was NULL!");

        // Test for correct input
        startConfig = startConfig.replace(" ", "");
        if (!startConfig.matches(ArgPatterns.AM1_INPUT))
            throw new IllegalArgumentException("Invalid StartConfig! Config was: " + startConfig);

        this.startConfig = startConfig;
        this.configSet = true;
    }

    // TODO: Input and Output is manuel right now!
    private void interpretStartConfig() {

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

                this.runtimeHeap.store(address, Integer.parseInt(heap[i]));
                address++;
            }
        }

        // Set Ref-pointer
        this.reference.setValue(Integer.parseInt(configArray[3]));
    }

    private void reset() {

        init();
        this.startConfig = null;
        this.configSet = false;
    }

    public void setEntryPoint(int entryPoint) {

        // Exceptions
        if (entryPoint <= 0) throw new IllegalArgumentException("Invalid EntryPoint! Input was: " + entryPoint);

        commandPointer.setValue(entryPoint);
    }
}
