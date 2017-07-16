package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Constants.Colors;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class WRITEI extends AM1operation {

    public WRITEI(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, commandPointer, reference);
    }

    @Override
    public void run(String arg) {

        // Test argument string
        if (!arg.matches(ArgPatterns.BRACKET_INT))
            throw new IllegalArgumentException("Error in " + this.name + ". Argument was '" + arg + "'.");

        int address_pointer = this.BRACKET_INT(arg);
        int address_value = heap.load(reference.getValue() + address_pointer);
        int out = heap.load(address_value);

        System.out.println(Colors.RED_BACK + Colors.BLACK + "OUTPUT ->" + Integer.toString(out) + Colors.RESET);

        increment();
    }
}
