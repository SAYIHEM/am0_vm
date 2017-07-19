package VirtualMachines;

import Constants.ArgPatterns;
import Constants.Colors;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Peripherals.Display;
import Hardware.Peripherals.Soundcard;
import Hardware.Stacks.Pointer;
import Hardware.Stacks.Stack;
import InstructionSets.AM0Instructions;
import InstructionSets.AM1Instructions;
import InstructionSets.Instructions;
import Interpreters.AM0Interpreter;
import Interpreters.AM1Interpreter;
import Interpreters.Interpreter;
import Logs.Log;

import javax.swing.*;
import java.util.ArrayList;

public class AM1Mashine extends RuntimeMachine {

    private CommandPointer commandPointer;
    private Stack runtimeStack;
    private Heap runtimeHeap;
    private Pointer reference;
    private String startConfig = Colors.RED + "Not defined!" + Colors.RESET;

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

        System.out.println("Starting AM1-program with config: " + this.startConfig + " ...");

        Interpreter interpreter = new AM1Interpreter(new AM1Instructions(runtimeHeap, runtimeStack, commandPointer, reference));

        while(commandPointer.getValue() < program.length) {

            // Write output
            output += program[commandPointer.getValue()] + "\n";
            Log.d("AM1", program[commandPointer.getValue()]);

            interpreter.execute(program[commandPointer.getValue()]);

        }

        System.out.println("Program terminated.");
    }

    // TODO: Input and Output is ignored right now!
    public void setStartConfig(String startConfig) {

        if (startConfig == null) throw new NullPointerException("StartConfig was NULL!");

        // Test for correct input
        startConfig = startConfig.replace(" ", "");
        if (!startConfig.matches(ArgPatterns.AM1_INPUT))
            throw new IllegalArgumentException("Invalid StartConfig! Config was: " + startConfig);
        startConfig = startConfig.replace("(", "");
        startConfig = startConfig.replace(")", "");

        String[] configArray = startConfig.split(",");

        // Set commandPointer
        this.commandPointer.setValue(Integer.parseInt(configArray[0]) - 1); // TODO: CommandPointer muss verschoben sein!

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

        // Save StartConfig for console output
        this.startConfig = startConfig;
    }

    public void setEntryPoint(int entryPoint) {

        // Exceptions
        if (entryPoint <= 0) throw new IllegalArgumentException("Invalid EntryPoint! Input was: " + entryPoint);

        commandPointer.setValue(entryPoint);
    }
}
