package Operations.AM1.FunctionCommands;

import Constants.ArgPatterns;
import Exceptions.HeapException;
import Exceptions.InvalidOperationArgumentException;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class CALL extends AM1operation {

    public CALL(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, commandPointer, reference);
    }

    @Override
    public void run(String arg) throws InvalidOperationArgumentException, HeapException {

        // Test argument string
        if (!arg.matches(ArgPatterns.INT))
            throw new InvalidOperationArgumentException("Error in "+ this.name + ". Argument was '" + arg + "'.");

        // Pushing next commandPointer value in heap
        heap.store(heap.getMaxAddress() + 1, commandPointer.getValue() + 1);

        // Set new commandPointer value
        commandPointer.setValue(Integer.parseInt(arg));

        // Pushing actual Ref-value in heap
        heap.store(heap.getMaxAddress() + 1, reference.getValue());

        // Ref-value is the new length of heap
        reference.setValue(heap.getMaxAddress());
    }
}
