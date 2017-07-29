package Operations.AM0.Memory;

import Constants.ArgPatterns;
import Exceptions.HeapException;
import Exceptions.InvalidOperationArgumentException;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Operations.AM0.AM0operation;
import Constants.ColorConsole;
import Hardware.Stacks.Stack;

import java.util.Scanner;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class READ extends AM0operation {

    public READ(Heap heap, Stack stack, CommandPointer commandPointer)
    {
        super(heap, stack, commandPointer);
    }

    @Override
    public void run(String arg) throws InvalidOperationArgumentException, HeapException {

        // Test argument string
        if (!arg.matches(ArgPatterns.INT))
            throw new InvalidOperationArgumentException("Error in "+ this.name + ". Argument was '" + arg + "'.");


        System.out.print(ColorConsole.BLUE_BACK + ColorConsole.BLACK + "INPUT <-" + ColorConsole.RESET + " ");

        Scanner in = new Scanner(System.in);
        String input = in.nextLine().trim();

        this.heap.store(Integer.parseInt(arg), Integer.parseInt(input));

        increment();
    }
}
