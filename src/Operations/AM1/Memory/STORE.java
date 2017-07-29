package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Constants.Flag;
import Exceptions.HeapException;
import Exceptions.InvalidOperationArgumentException;
import Exceptions.StackException;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class STORE extends AM1operation {

    public STORE(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, commandPointer, reference);
    }

    @Override
    public void run(String arg) throws InvalidOperationArgumentException, StackException, HeapException {

        // Test argument string
        if (!arg.matches(ArgPatterns.GLOBAL_LOKAL))
            throw new InvalidOperationArgumentException("Error in " + this.name + ". Argument was '" + arg + "'.");

        String[] args = this.GLOBAL_LOKAL(arg);
        String flag = args[0];
        int address = Integer.parseInt(args[1]);

        // For 'global' flag
        if (flag.equals(Flag.GLOBAL)) {

            heap.store(address, stack.pop());
        }

        // For 'lokal' flag
        if (flag.equals(Flag.LOKAL)) {

            heap.store(reference.getValue() + address, stack.pop());
        }

        increment();
    }
}
