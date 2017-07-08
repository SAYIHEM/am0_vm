package Operations.AM0;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Stack;

public abstract class AM0operation {

    protected String name;
    protected Heap heap;
    protected Stack stack;
    protected CommandPointer commandPointer;

    public AM0operation(Heap heap, Stack stack, CommandPointer commandPointer)
    {
        this.heap = heap;
        this.stack = stack;
        this.commandPointer = commandPointer;
    }

    public abstract void run(Integer arg);

    public String getName() {

        return this.name;
    }

    protected void increment()
    {
        commandPointer.increment();
    }
}
