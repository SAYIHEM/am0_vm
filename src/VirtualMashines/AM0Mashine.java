package VirtualMashines;

import CommandPointers.CommandPointer;
import Heaps.Heap;
import InstructionSets.AM0Instructions;
import Interpreters.AM0Interpreter;
import Interpreters.Interpreter;
import Stacks.Stack;

public class AM0Mashine extends RuntimeMachine {

    CommandPointer cmdPointer = new CommandPointer();
    Interpreter interpreter = new AM0Interpreter(new AM0Instructions()); // TODO parse stack and heap into operations
    Stack stack = new Stack();
    Heap heap = new Heap();


    @Override
    public void run(String program) {

        // TODO split program string
        String[] commandList = program.split("\n");

        while(cmdPointer.getValue() < commandList.length) {

            // Write output
            this.output += commandList[cmdPointer.getValue()] + "\n";

            // Execute command line
            interpreter.execute(commandList[cmdPointer.getValue()]);
        }
    }
}
