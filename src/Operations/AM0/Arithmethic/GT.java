package Operations.AM0.Arithmethic;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Operations.AM0.AM0operation;
import Hardware.Stacks.Stack;

public class GT extends AM0operation {

    public GT(Heap heap, Stack stack, CommandPointer commandPointer) {

        super(heap, stack, commandPointer);
    }

    @Override
    public void run(String arg) {

        int y = this.stack.pop();
        int x = this.stack.pop();

        this.stack.push(x > y ? 1 : 0);

        increment();
    }
}
