package VirtualMachines;

import Constants.ArgPatterns;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Pointer;
import Hardware.Stacks.Stack;
import InstructionSets.AM1Instructions;
import Interpreters.AM1Interpreter;
import Interpreters.Interpreter;
import Logs.Log;

public class AM1Mashine extends RuntimeMachine {

    private CommandPointer commandPointer;
    private Stack runtimeStack;
    private Heap runtimeHeap;
    private Pointer reference;
    private String startConfig;
    private boolean configSet = false;

    public AM1Mashine() {

        init();
    }

    public AM1Mashine(String[] program) {

        init();
        run(program);
    }

    private void init() {

        commandPointer = new CommandPointer();
        runtimeStack = new Stack();
        runtimeHeap = new Heap();
        reference = new Pointer();
    }

    @Override
    public void run(String[] program) {

        // Check if StartConfig is set
        if (!this.configSet) throw new IllegalStateException("Missing Start-config!");

        // Console output
        System.out.println("Starting AM1-program with config: " + this.startConfig);

        // Interpret StartConfig
        interpretStartConfig();

        Interpreter interpreter = new AM1Interpreter(new AM1Instructions(runtimeHeap, runtimeStack, commandPointer, reference));

        while(commandPointer.getValue() > 0 && commandPointer.getValue() < program.length) {

            // Write output
            output += program[commandPointer.getValue()] + "\n";
            Log.d(commandPointer.getValue() + "", program[commandPointer.getValue()]);

            interpreter.execute(program[commandPointer.getValue()]);

        }

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

    // TODO: Input and Output is ignored right now!
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

    public void setEntryPoint(int entryPoint) {

        // Exceptions
        if (entryPoint <= 0) throw new IllegalArgumentException("Invalid EntryPoint! Input was: " + entryPoint);

        commandPointer.setValue(entryPoint);
    }
}
