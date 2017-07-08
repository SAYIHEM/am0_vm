package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Constants.Colors;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class WRITE extends AM1operation {

    public WRITE(Heap heap, Stack stack, Heap runtimeHeap, CommandPointer commandPointer, Pointer reference) {
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

        int out = 0;

        // For 'global' flag
        if (flag.equals("global")) {

            out = heap.load(address);
        }

        // For 'lokal' flag
        if (flag.equals("lokal")) {

            out = heap.load(reference.getValue() + address);
        }

        System.out.println(Colors.RED_BACK + Colors.BLACK + "OUTPUT ->" + Integer.toString(out) + Colors.RESET);

        increment();
    }
}