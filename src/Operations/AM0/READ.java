package Operations.AM0;

import Constants.Colors;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
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
        System.out.print(Colors.BLUE_BACK + Colors.BLACK + "INPUT <-" + Colors.RESET + " ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        this.heap.store(arg, Integer.parseInt(input));
        increment();
    }
}
