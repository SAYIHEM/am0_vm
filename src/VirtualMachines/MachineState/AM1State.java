package VirtualMachines.MachineState;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.AM1Heap;
import Hardware.Stacks.AM1Stack;
import Hardware.Stacks.Pointer;

public class AM1State {

    private CommandPointer commandPointer;
    private AM1Stack stack;
    private AM1Heap heap;
    private Pointer reference;

    public AM1State(CommandPointer commandPointer, AM1Stack stack, AM1Heap heap, Pointer reference) {

        if (commandPointer == null || stack == null || heap == null || reference == null) throw new NullPointerException();

        this.commandPointer = commandPointer;
        this.stack = stack;
        this.heap = heap;
        this.reference = reference;
    }

    public CommandPointer getCommandPointer() {

        return commandPointer;
    }

    public AM1Stack getStack() {

        return stack;
    }

    public AM1Heap getHeap() {

        return heap;
    }

    public Pointer getReference() {

        return reference;
    }
}
