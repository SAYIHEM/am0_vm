package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Exceptions.HeapException;
import Exceptions.InvalidOperationArgumentException;
import Exceptions.StackException;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class STOREI extends AM1operation {

    public STOREI(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference, Stack input, Stack output) {
        super(heap, stack, commandPointer, reference, input, output);
    }

    @Override
    public void run(String arg) throws InvalidOperationArgumentException, HeapException, StackException {

        // Test argument string
        if (!arg.matches(ArgPatterns.BRACKET_INT))
            throw new InvalidOperationArgumentException("Error in " + this.name + ". Argument was '" + arg + "'.");

        int address_pointer = this.BRACKET_INT(arg);
        int address_value = heap.load(reference.getValue() + address_pointer);
        heap.store(address_value, stack.pop());

        increment();
    }
}
