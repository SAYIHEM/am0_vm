package Operations.AM1.Memory;

import Constants.ArgPatterns;
import Exceptions.InvalidOperationArgumentException;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Pointer;
import Operations.AM0.AM0operation;
import Hardware.Stacks.Stack;
import Operations.AM1.AM1operation;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class JMP extends AM1operation {

    public JMP(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference, Stack input, Stack output) {
        super(heap, stack, commandPointer, reference, input, output);
    }

    @Override
    public void run(String arg) throws InvalidOperationArgumentException {

        // Test argument string
        if (!arg.matches(ArgPatterns.INT))
            throw new InvalidOperationArgumentException("Error in "+ this.name + ". Argument was '" + arg + "'.");

        this.commandPointer.setValue(Integer.parseInt(arg));
    }
}
