package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class LOAD extends AM1operation {


    public LOAD(Heap heap, Stack stack, Heap runtimeHeap, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, runtimeHeap, commandPointer, reference);
    }

    @Override
    public void run(String arg) {

        // Test argument string
        if (!arg.matches(ArgPatterns.GLOBAL_LOKAL))
            throw new IllegalArgumentException("Error in "+ this.name + ". Argument was '" + arg + "'.");

        String[] args = this.GLOBAL_LOKAL(arg);
        String flag = args[0];
        int address = Integer.parseInt(args[1]);

        // For 'global' flag
        if (flag.equals("global")) {

            stack.push(heap.load(address));
        }

        // For 'lokal' flag
        if (flag.equals("lokal")) {

            stack.push(heap.load(reference.getValue() + address));
        }

    }
}
