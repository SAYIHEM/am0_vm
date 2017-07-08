package Operations.AM0.Memory;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Operations.AM0.AM0operation;
import Hardware.Stacks.Stack;

public class LOAD extends AM0operation {

    public LOAD(Heap heap, Stack stack, CommandPointer commandPointer) {

        super(heap, stack, commandPointer);
        this.name = "LOAD";
    }

    @Override
    public void run(Integer arg) {

        this.stack.push(this.heap.LOAD(arg));
        increment();
    }
}
