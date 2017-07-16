package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Constants.Colors;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

import java.util.Scanner;

public class READI extends AM1operation {

    public READI(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, commandPointer, reference);
    }

    @Override
    public void run(String arg) {

        // Test argument string
        if (!arg.matches(ArgPatterns.BRACKET_INT))
            throw new IllegalArgumentException("Error in " + this.name + ". Argument was '" + arg + "'.");

        // Get Value Input
        System.out.print(Colors.BLUE_BACK + Colors.BLACK + "INPUT <-" + Colors.RESET + " ");
        Scanner in = new Scanner(System.in);
        int value = Integer.parseInt(in.nextLine().trim());

        int address_pointer = this.BRACKET_INT(arg);
        int address_value = heap.load(reference.getValue() + address_pointer);
        heap.store(address_value, value);

        increment();
    }
}
