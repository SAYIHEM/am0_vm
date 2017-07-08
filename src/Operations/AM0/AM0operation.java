package Operations.AM0;

import Constants.ArgPatterns;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Stack;
import Operations.Operation;

public abstract class AM0operation extends Operation {

    protected Heap heap;
    protected Stack stack;
    protected CommandPointer commandPointer;

    public AM0operation(Heap heap, Stack stack, CommandPointer commandPointer)
    {
        this.name = this.getClass().getSimpleName();

        this.heap = heap;
        this.stack = stack;
        this.commandPointer = commandPointer;
    }


    protected void increment()
    {
        commandPointer.increment();
    }
}
