package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class INIT extends AM1operation {

    public INIT(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, commandPointer, reference);
    }

    @Override
    public void run(String arg) {

        // Test argument string
        if (!arg.matches(ArgPatterns.INT))
            throw new IllegalArgumentException("Error in "+ this.name + ". Argument was '" + arg + "'.");

        int count = Integer.parseInt(arg);

        // Pushing multiple '0' on the heap
        while (count > 0) {

            heap.store(heap.getMaxAddress() + 1, 0);
            count--;
        }

        increment();
    }
}
