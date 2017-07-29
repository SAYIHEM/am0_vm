package VirtualMachines.MachineState;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.AM1Heap;
import Hardware.Stacks.AM1Stack;
import Hardware.Pointer;

public class AM1State {

    private CommandPointer commandPointer;
    private AM1Stack stack;
    private AM1Heap heap;
    private Pointer reference;

    public AM1State(CommandPointer commandPointer, AM1Stack stack, AM1Heap heap, Pointer reference) {

        if (commandPointer == null || stack == null || heap == null || reference == null) throw new NullPointerException();

        this.commandPointer = new CommandPointer(commandPointer);
        this.stack = new AM1Stack(stack);
        this.heap = new AM1Heap(heap);
        this.reference = new Pointer(reference);
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
