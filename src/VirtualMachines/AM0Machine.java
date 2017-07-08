package VirtualMachines;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import InstructionSets.AM0Instructions;
import Interpreters.AM0Interpreter;
import Hardware.Stacks.Stack;

public class AM0Machine {

    private CommandPointer commandPointer = new CommandPointer();
    private Stack runtimeStack = new Stack();
    private Heap runtimeHeap = new Heap();

    public AM0Machine()
    {
        commandPointer = new CommandPointer();
        runtimeStack = new Stack();
        runtimeHeap = new Heap();
    }

    public AM0Machine(String[] program)
    {
        commandPointer = new CommandPointer();
        runtimeStack = new Stack();
        runtimeHeap = new Heap();
        run(program);
    }

    public void run(String[] program) {

        AM0Interpreter interpreter = new AM0Interpreter(new AM0Instructions(runtimeHeap, runtimeStack, commandPointer));

        while(commandPointer.getValue() < program.length) {

            System.out.println(program[commandPointer.getValue()]);
            interpreter.execute(program[commandPointer.getValue()]);
        }

        System.out.println("Program terminated...");
    }
}
