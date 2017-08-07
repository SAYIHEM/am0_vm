package Operations.AM1.FunctionCommands;

import Exceptions.HeapException;
import Exceptions.InvalidOperationArgumentException;
import Exceptions.StackException;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class PUSH extends AM1operation {

    public PUSH(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference, Stack input, Stack output) {
        super(heap, stack, commandPointer, reference, input, output);
    }

    @Override
    public void run(String arg) throws InvalidOperationArgumentException, StackException, HeapException {

        heap.store(heap.getMaxAddress() + 1, stack.pop());

        increment();
    }
}
