package Operations.AM0.Memory;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Operations.AM0.AM0operation;
import Hardware.Stacks.Stack;

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
        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + "OUTPUT ->" + ANSI_RESET + " " + heap.load(arg));
        increment();
    }
}
