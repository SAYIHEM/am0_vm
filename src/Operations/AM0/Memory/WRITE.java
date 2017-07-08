package Operations.AM0.Memory;

import Constants.Colors;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Stack;
import Operations.AM0.AM0operation;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class WRITE extends AM0operation {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";


    public WRITE(Heap heap, Stack stack, CommandPointer commandPointer)
    {
        super(heap, stack, commandPointer);
        this.name = "WRITE";
    }

    @Override
    public void run(Integer arg) {
        System.out.println(Colors.RED_BACK + Colors.BLACK + "OUTPUT ->" + Colors.RESET + " " + heap.load(arg));
        increment();
    }
}
