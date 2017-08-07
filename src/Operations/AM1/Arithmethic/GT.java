package Operations.AM1.Arithmethic;

import Exceptions.InvalidOperationArgumentException;
import Exceptions.StackException;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Pointer;
import Operations.AM0.AM0operation;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

public class GT extends AM1operation {

    public GT(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference, Stack input, Stack output) {
        super(heap, stack, commandPointer, reference, input, output);
    }

    @Override
    public void run(String arg) throws InvalidOperationArgumentException, StackException {

        int y = this.stack.pop();
        int x = this.stack.pop();

        this.stack.push(x > y ? 1 : 0);

        increment();
    }
}
