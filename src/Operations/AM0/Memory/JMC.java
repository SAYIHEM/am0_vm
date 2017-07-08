package Operations.AM0.Memory;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Operations.AM0.AM0operation;
import Hardware.Stacks.Stack;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class JMC extends AM0operation {

    public JMC(Heap heap, Stack stack, CommandPointer commandPointer)
    {
        super(heap, stack, commandPointer);
        this.name = "JMC";
    }

    @Override
    public void run(Integer arg) {
        Integer value = this.stack.pop();
        if(value == 0) {

            this.commandPointer.setValue(arg);

        } else {

            increment();
        }

    }
}
