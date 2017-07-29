package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Constants.ColorConsole;
import Exceptions.HeapException;
import Exceptions.InvalidOperationArgumentException;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

import java.util.Scanner;

public class READI extends AM1operation {

    public READI(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, commandPointer, reference);
    }

    @Override
    public void run(String arg) throws InvalidOperationArgumentException, HeapException {

        // Test argument string
        if (!arg.matches(ArgPatterns.BRACKET_INT))
            throw new InvalidOperationArgumentException("Error in " + this.name + ". Argument was '" + arg + "'.");

        // Get Value Input
        System.out.print(ColorConsole.BLUE_BACK + ColorConsole.BLACK + "INPUT <-" + ColorConsole.RESET + " ");
        Scanner in = new Scanner(System.in);
        int value = Integer.parseInt(in.nextLine().trim());

        int address_pointer = this.BRACKET_INT(arg);
        int address_value = heap.load(reference.getValue() + address_pointer);
        heap.store(address_value, value);

        increment();
    }
}
