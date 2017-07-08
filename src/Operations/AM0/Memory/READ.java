package Operations.AM0.Memory;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Operations.AM0.AM0operation;
import Constants.Colors;
import Hardware.Stacks.Stack;

import java.util.Scanner;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class READ extends AM0operation {

    public READ(Heap heap, Stack stack, CommandPointer commandPointer)
    {
        super(heap, stack, commandPointer);
        this.name = "READ";
    }

    @Override
    public void run(Integer arg) {
        System.out.print(Colors.BLUE_BACK + Colors.BLACK + "INPUT <-" + Colors.ANSI_RESET + " ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().trim();
        this.heap.STORE(arg, Integer.parseInt(input));
        increment();
    }
}
