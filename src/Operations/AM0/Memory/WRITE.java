package Operations.AM0.Memory;

import Constants.ArgPatterns;
import Constants.Colors;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Stack;
import Operations.AM0.AM0operation;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class WRITE extends AM0operation {

    public WRITE(Heap heap, Stack stack, CommandPointer commandPointer)
    {
        super(heap, stack, commandPointer);
    }

    @Override
    public void run(String arg) {

        // Test argument string
        if (!arg.matches(ArgPatterns.INT))
            throw new IllegalArgumentException("Error in "+ this.name + ". Argument was '" + arg + "'.");


        System.out.println(Colors.RED_BACK + Colors.BLACK + "OUTPUT ->" + Colors.RESET
                + " " + heap.load(Integer.parseInt(arg)));

        increment();
    }
}
