package Operations.AM0.Memory;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Operations.AM0.AM0operation;
import Hardware.Stacks.Stack;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class STORE extends AM0operation {

    public STORE(Heap heap, Stack stack, CommandPointer commandPointer) {

        super(heap, stack, commandPointer);
        this.name = "store";
    }

    @Override
    public void run(Integer arg) {

        Integer value = this.stack.pop();
        this.heap.store(arg, value);
        increment();
    }
}
