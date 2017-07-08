package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Constants.Colors;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class WRITEI extends AM1operation {

    public WRITEI(Heap heap, Stack stack, Heap runtimeHeap, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, runtimeHeap, commandPointer, reference);
    }

    @Override
    public void run(String arg) {

        // Test argument string
        if (!arg.matches(ArgPatterns.BRACKET_INT))
            throw new IllegalArgumentException("Error in " + this.name + ". Argument was '" + arg + "'.");

        int address_runtimeHeap = this.BRACKET_INT(arg);
        int address_heap = runtimeHeap.load(address_runtimeHeap);
        int out = heap.load(address_heap);

        System.out.println(Colors.RED_BACK + Colors.BLACK + "OUTPUT ->" + Integer.toString(out) + Colors.RESET);

        increment();
    }
}
