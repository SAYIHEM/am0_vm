package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Exceptions.HeapException;
import Exceptions.InvalidOperationArgumentException;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class LOADI extends AM1operation {

    public LOADI(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, commandPointer, reference);
    }

    @Override
    public void run(String arg) throws InvalidOperationArgumentException, HeapException {

        // Test argument string
        if (!arg.matches(ArgPatterns.BRACKET_INT))
            throw new InvalidOperationArgumentException("Error in " + this.name + ". Argument was '" + arg + "'.");

        int address_pointer = this.BRACKET_INT(arg);
        int address_value = heap.load(reference.getValue() + address_pointer);
        stack.push(heap.load(address_value));

        increment();
    }
}
