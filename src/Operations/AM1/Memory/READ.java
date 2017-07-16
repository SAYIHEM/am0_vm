package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Constants.Colors;
import Constants.Flag;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

import java.util.Scanner;

public class READ extends AM1operation {

    public READ(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, commandPointer, reference);
    }

    @Override
    public void run(String arg) {

        // Test argument string
        if (!arg.matches(ArgPatterns.GLOBAL_LOKAL))
            throw new IllegalArgumentException("Error in " + this.name + ". Argument was '" + arg + "'.");

        String[] args = this.GLOBAL_LOKAL(arg);
        String flag = args[0];
        int address = Integer.parseInt(args[1]);

        // Get Value Input
        System.out.print(Colors.BLUE_BACK + Colors.BLACK + "INPUT <-" + Colors.RESET + " ");
        Scanner in = new Scanner(System.in);
        int value = Integer.parseInt(in.nextLine().trim());

        // For 'global' flag
        if (flag.equals(Flag.GLOBAL)) {

            heap.store(address, value);
        }

        // For 'lokal' flag
        if (flag.equals(Flag.LOKAL)) {

            heap.store(reference.getValue() + address, value);
        }

        increment();
    }
}
