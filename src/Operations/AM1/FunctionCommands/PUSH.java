package Operations.AM1.FunctionCommands;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class PUSH extends AM1operation {

    public PUSH(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference) {
        super(heap, stack, commandPointer, reference);
    }

    @Override
    public void run(String arg) {

        heap.store(heap.getMaxAddress() + 1, stack.pop());

        increment();
    }
}
