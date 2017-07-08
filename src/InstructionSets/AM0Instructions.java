package InstructionSets;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Operations.AM0.*;
import Operations.AM0.Arithmethic.*;
import Operations.AM0.Logical.*;
import Operations.AM0.Memory.*;
import Hardware.Stacks.Stack;
import Operations.AM0.Memory.READ;

import java.util.Map;

public class AM0Instructions extends Instructions {

    public AM0Instructions(Heap heap, Stack stack, CommandPointer commandPointer) {

        // SetUp AM0.Operation-Map for AM0
        instructions.put("ADD", new ADD(heap, stack, commandPointer));
        instructions.put("MUL", new MUL(heap, stack, commandPointer));
        instructions.put("SUB", new SUB(heap, stack, commandPointer));
        instructions.put("DIV", new DIV(heap, stack, commandPointer));
        instructions.put("MOD", new MOD(heap, stack, commandPointer));
        instructions.put("EQ", new EQ(heap, stack, commandPointer));
        instructions.put("NE", new NE(heap, stack, commandPointer));
        instructions.put("LT", new LT(heap, stack, commandPointer));
        instructions.put("GT", new GT(heap, stack, commandPointer));
        instructions.put("LE", new LE(heap, stack, commandPointer));
        instructions.put("GE", new GE(heap, stack, commandPointer));
        instructions.put("LOAD", new LOAD(heap, stack, commandPointer));
        instructions.put("STORE", new STORE(heap, stack, commandPointer));
        instructions.put("LIT", new LIT(heap, stack, commandPointer));
        instructions.put("WRITE", new WRITE(heap, stack, commandPointer));
        instructions.put("READ", new READ(heap, stack, commandPointer));
        instructions.put("JMP", new JMP(heap, stack, commandPointer));
        instructions.put("JMC", new JMC(heap, stack, commandPointer));
    }

    public Map<String, AM0operation> getInstructions() {

        return instructions;
    }
}
