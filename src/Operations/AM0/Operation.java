package Operations.AM0;

import CommandPointers.CommandPointer;
import Heaps.Heap;
import Stacks.Stack;

public abstract class Operation {

    protected String name;
    protected Stack runtimeStack = Stack.getRuntimeStack();
    protected Heap heap = Heap.getInstance();
    protected CommandPointer stackPointer = CommandPointer.getInstance();

    public abstract void run(Integer arg);

    public String getName() {

        return this.name;
    }

    public void increment() {

        this.stackPointer.increment();
    }

}
