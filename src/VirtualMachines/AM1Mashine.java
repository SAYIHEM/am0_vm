package VirtualMachines;

import Constants.ArgPatterns;
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

        Interpreter interpreter = new AM1Interpreter(new AM1Instructions(runtimeHeap, runtimeStack, commandPointer, reference));

        while(commandPointer.getValue() < program.length) {

            // Write output
            output += program[commandPointer.getValue()] + "\n";
            Log.d("AM1", program[commandPointer.getValue()]);

            interpreter.execute(program[commandPointer.getValue()]);

        }
    }

    // TODO: Input and Output is ignored right now!
    public void setStartConfig(String startConfig) {

        if (startConfig == null) throw new NullPointerException("StartConfig was NULL!");

        // Test for correct input
        startConfig = startConfig.replace(" ", "");
        if (!startConfig.matches(ArgPatterns.AM1_INPUT))
            throw new IllegalArgumentException("Invalid StartConfig! Config was: " + startConfig);

        String[] configArray = startConfig.split(",");

        // Set commandPointer
        this.commandPointer.setValue(Integer.parseInt(configArray[0]));

        // SetUp Stack
        // TODO !!!!!
    }

    public void setEntryPoint(int entryPoint) {

        // Exceptions
        if (entryPoint <= 0) throw new IllegalArgumentException("Invalid EntryPoint! Input was: " + entryPoint);

        commandPointer.setValue(entryPoint);
    }
}
