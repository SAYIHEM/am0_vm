package Operations.AM0.Memory;

import Constants.ArgPatterns;
import Exceptions.HeapException;
import Exceptions.InvalidOperationArgumentException;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Operations.AM0.AM0operation;
import Hardware.Stacks.Stack;

public class LOAD extends AM0operation {

    public LOAD(Heap heap, Stack stack, CommandPointer commandPointer) {

        super(heap, stack, commandPointer);
    }

    @Override
    public void run(String arg) throws InvalidOperationArgumentException, HeapException {

        // Test argument string
        if (!arg.matches(ArgPatterns.INT))
            throw new InvalidOperationArgumentException("Error in "+ this.name + ". Argument was '" + arg + "'.");

        this.stack.push(this.heap.load(Integer.parseInt(arg)));
        increment();
    }
}
