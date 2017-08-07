package InstructionSets;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM1.Arithmethic.*;
import Operations.AM1.FunctionCommands.*;
import Operations.AM1.Logical.*;
import Operations.AM1.Memory.*;
import Operations.Operation;

import java.util.Map;

public class AM1Instructions extends Instructions {

    public AM1Instructions(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference, Stack input, Stack output) {

        // SetUp Operation-Map for AM1
        instructions.put("ADD", new ADD(heap, stack, commandPointer, reference, input, output));
        instructions.put("MUL", new MUL(heap, stack, commandPointer, reference, input, output));
        instructions.put("SUB", new SUB(heap, stack, commandPointer, reference, input, output));
        instructions.put("DIV", new DIV(heap, stack, commandPointer, reference, input, output));
        instructions.put("MOD", new MOD(heap, stack, commandPointer, reference, input, output));

        instructions.put("EQ", new EQ(heap, stack, commandPointer, reference, input, output));
        instructions.put("NE", new NE(heap, stack, commandPointer, reference, input, output));
        instructions.put("LT", new LT(heap, stack, commandPointer, reference, input, output));
        instructions.put("GT", new GT(heap, stack, commandPointer, reference, input, output));
        instructions.put("LE", new LE(heap, stack, commandPointer, reference, input, output));
        instructions.put("GE", new GE(heap, stack, commandPointer, reference, input, output));

        instructions.put("JMP", new JMP(heap, stack, commandPointer, reference, input, output));
        instructions.put("JMC", new JMC(heap, stack, commandPointer, reference, input, output));
        instructions.put("LIT", new LIT(heap, stack, commandPointer, reference, input, output));

        // AM1-specific Operations
        instructions.put("LOAD", new LOAD(heap, stack, commandPointer, reference, input, output));
        instructions.put("WRITE", new WRITE(heap, stack, commandPointer, reference, input, output));
        instructions.put("LOADI", new LOADI(heap, stack, commandPointer, reference, input, output));
        instructions.put("WRITEI", new WRITEI(heap, stack, commandPointer, reference, input, output));
        instructions.put("LOADA", new LOADA(heap, stack, commandPointer, reference, input, output));
        instructions.put("STORE", new STORE(heap, stack, commandPointer, reference, input, output));
        instructions.put("READ", new READ(heap, stack, commandPointer, reference, input, output));
        instructions.put("STOREI", new STOREI(heap, stack, commandPointer, reference, input, output));
        instructions.put("READI", new READI(heap, stack, commandPointer, reference, input, output));
        instructions.put("PUSH", new PUSH(heap, stack, commandPointer, reference, input, output));
        instructions.put("CALL", new CALL(heap, stack, commandPointer, reference, input, output));
        instructions.put("INIT", new INIT(heap, stack, commandPointer, reference, input, output));
        instructions.put("RET", new RET(heap, stack, commandPointer, reference, input, output));
    }

    @Override
    public Map<String, Operation> getInstructions() {

        return instructions;
    }
}
