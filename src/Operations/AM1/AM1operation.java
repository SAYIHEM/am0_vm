package Operations.AM1;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Pointer;
import Hardware.Stacks.Stack;
import Operations.Operation;

public abstract class AM1operation extends Operation {

    protected Heap heap;
    protected Stack stack;
    protected CommandPointer commandPointer;
    protected Pointer reference;

    public AM1operation(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference) {

        this.name = this.getClass().getSimpleName();

        this.heap = heap;
        this.stack = stack;
        this.commandPointer = commandPointer;
        this.reference = reference;
    }

    @Override
    protected void increment() {

        commandPointer.increment();
    }

    protected String[] GLOBAL_LOKAL(String arg) {

        arg = arg.replace("(", "");
        arg = arg.replace(")", "");
        arg = arg.replace(",", "");

        return arg.split(" ");
    }

    protected int BRACKET_INT(String arg) {

        arg = arg.replace("(", "");
        arg = arg.replace(")", "");

        return Integer.parseInt(arg);
    }
}