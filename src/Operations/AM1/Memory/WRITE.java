package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Constants.ColorConsole;
import Constants.Flag;
import Exceptions.HeapException;
import Exceptions.InvalidOperationArgumentException;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class WRITE extends AM1operation {

    public WRITE(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, commandPointer, reference);
    }

    @Override
    public void run(String arg) throws InvalidOperationArgumentException, HeapException {

        // Test argument string
        if (!arg.matches(ArgPatterns.GLOBAL_LOKAL))
            throw new InvalidOperationArgumentException("Error in "+ this.name + ". Argument was '" + arg + "'.");

        String[] args = this.GLOBAL_LOKAL(arg);
        String flag = args[0];
        int address = Integer.parseInt(args[1]);

        int out = 0;

        // For 'global' flag
        if (flag.equals(Flag.GLOBAL)) {

            out = heap.load(address);
        }

        // For 'lokal' flag
        if (flag.equals(Flag.LOKAL)) {

            out = heap.load(reference.getValue() + address);
        }

        System.out.println(ColorConsole.RED_BACK + ColorConsole.BLACK + "OUTPUT ->" + ColorConsole.RESET + " " + Integer.toString(out));

        increment();
    }
}
