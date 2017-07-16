package Operations.AM1.FunctionCommands;

import Constants.ArgPatterns;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class RET extends AM1operation {

    public RET(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, commandPointer, reference);
    }

    @Override
    public void run(String arg) {

        // Test argument string
        if (!arg.matches(ArgPatterns.INT))
            throw new IllegalArgumentException("Error in "+ this.name + ". Argument was '" + arg + "'.");

        // Empty heap right from the Ref-pointer
        heap.emptyfromAddress(reference.getValue());

        // Set new Ref-pointer, delete value from heap
        reference.setValue(heap.load(heap.getMaxAddress()));
        heap.emptyfromAddress(heap.getMaxAddress() - 1);

        // Read commandPointer value, delete value from heap;
        commandPointer.setValue(heap.load(heap.getMaxAddress()));
        heap.emptyfromAddress(heap.getMaxAddress() - 1);

        int count = Integer.parseInt(arg);

        // Delete multiple Items from heap
        while (count > 0) {

            heap.emptyfromAddress(heap.getMaxAddress() - 1);
            count--;
        }
    }
}
