package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class LOADI extends AM1operation {

    public LOADI(Heap heap, Stack stack, Heap runtimeHeap, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, runtimeHeap, commandPointer, reference);
    }

    @Override
    public void run(String arg) {

        // Test argument string
        if (!arg.matches(ArgPatterns.BRACKET_INT))
            throw new IllegalArgumentException("Error in " + this.name + ". Argument was '" + arg + "'.");

        int address_runtimeHeap = this.BRACKET_INT(arg);
        int address_heap = runtimeHeap.load(address_runtimeHeap);
        stack.push(heap.load(address_heap));

        increment();
    }
}
